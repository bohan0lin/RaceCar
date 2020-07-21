//Bohan Lin
//PA#04A
//03/05/2020

package needForSpeed;

public class RaceTrack {
	
	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events in part B. For more see the assignment PDF / documentation for TrackLoggerA.java
	 */
	// private TrackLoggerA logger;
	private RaceCar[] car;
	private int num; // the number of the race cars in the track
	private PitStop pitStop;
	private FinishLine finishLine ;
	private int rank = 1;

	public RaceTrack() {
		this.car = new RaceCar[10];
		this.num = 0;
		pitStop = new PitStop();
		finishLine = new FinishLine();
		// logger = new TrackLoggerA(); // DO NOT REMOVE THIS LINE
	}
	/**
	 * with the user input, get the data of the array of race cars into the race track object
	 * @param raceCars
	 */
	public void setCars(RaceCar[] raceCars) {
		for (int i = 0; i < raceCars.length; i++) {
			if (raceCars.length > this.car.length) {
				System.out.println("The number of cars should be less than 10.");
			} else {
				car[i] = raceCars[i];
			}
		}
		this.num = raceCars.length;
		finishLine.setCarForFinish(raceCars);
		pitStop.setCarForPS(raceCars);
	}
	
	/**
	 * time goes one tick in the race track
	 */
	public void tick() {
		 
		pitStop.tick();
		
		for (int i = 0; i < this.num ; i++) {
			if(this.car[i].getTime()==0) {
				System.out.println(this.car[i]+" has exited the pit stop. " );
				pitStop.exitPitStop(this.car[i]);
			}
			
			int newLocation = this.car[i].getSpeed()+ this.car[i].getLocation();
			if (newLocation>=100) {
				this.car[i].setLap(this.car[i].getLap() +1);
				
				newLocation -= 100;
			} 
			this.car[i].setLocation(newLocation);
		}
		
		
		
		for (int i = 0; i < this.num ; i++) {
			if (this.car[i].getLocation()>=75 && this.car[i].checkCollide()==true) {
				this.car[i].setLocation(75);
				pitStop.enterPitStop(this.car[i]);
				System.out.println(this.car[i] + " has entered the pit stop.");
			}
		}
		checkCollision();
		
		for (int i = 0; i < this.num ; i++) {
			if (this.car[i].getLap()>=10&&this.car[i].checkFinished()==false) {
				this.car[i].finishRace();
				System.out.println(this.car[i] + " has finished the race " + rank);
				
				rank++;
			}
		}
		
		
		
		/**
		 * get the location for each tick
		 */
		//for (int i =0; i <this.num; i++) {
		//	System.out.println(this.car[i].getLap() + " "+ this.car[i].getLocation());
		//}
		
	}
	
	/**
	 * check if there is two cars collide at this tick
	 * make one damaged only if it has not been damaged and either of the car cannot finish the race
	 */
	public void checkCollision() {
		
		for (int i = 0; i < this.num-1; i++) {
			for (int j = i+1; j <this.num; j++) {
				if (this.car[i].getLocation()==this.car[j].getLocation()&& this.car[i].getLocation()!=75){
					if (this.car[i].checkCollide()==false&&this.car[j].checkFinished()==false&&this.car[i].checkFinished()==false) {
						this.car[i].changeSpeed();
						this.car[i].collide();
						System.out.println(this.car[i]+" has been damaged.");
					}
					if (this.car[j].checkCollide()==false&&this.car[i].checkFinished()==false&&this.car[j].checkFinished()==false) {
						this.car[j].changeSpeed();
						this.car[j].collide();
						System.out.println(this.car[j]+" has been damaged.");
					}
				}
			}
		}
		
	}
	
	/**
	 * run the tick
	 */
	public void run() {
		int count = 1;
		while (finishLine.finished()==false) {
			System.out.println("Tick "+count);
			tick();
			count ++;
		}
		int result = calculateScore(count-1);
		System.out.println("You score is " + result);
	}
	
	/**
	 * after all the race cars finish 1000 units, calculate the score the user get.
	 * @param ticks
	 * @return
	 */
	public int calculateScore(int ticks) {
		int score = 0;
		score = 1000-20*ticks+150*this.num;
		return score;
	}
	
	/**
	 * Needed for part B
	 * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method. 
	 * @return logger with this track's events 
	 */
	/*
	public TrackLoggerA getLogger() {
		return logger;
	}
	*/
}
