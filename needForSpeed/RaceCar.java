//Bohan Lin
//PA#04A
//03/05/2020

package needForSpeed;

public class RaceCar {
	
	private int speed;
	private int currentSpeed;
	private int strength;
	private int position;
	private int lap;
	private boolean isCollide;
	private int timeInPS=-1; // the remaining ticks that the car needs to be in the pit stop
	private boolean finished;
	
	/**
	 * with the user inputs, set the object car
	 * @param speed
	 * @param strength
	 */
	public RaceCar(int speed, int strength) {
		if (speed <=55 && speed >=30) {
			this.speed = speed;
		} else if(speed >55){
			this.speed = 55;
		} else {
			this.speed = 30;
		}
		this.currentSpeed = this.speed;
		if (strength >=2 && strength <=4) {
			this.strength = strength;
		} else if(strength >4) {
			this.strength = 4;
		} else {
			this.strength = 2;
		}
		this.lap = 0;
		this.position = 0;
		this.finished = false;
	}
	
	/**
	 * create a default RaceCar object
	 */
	public RaceCar() {
		this.speed = 40;
		this.currentSpeed = 40;
		this.strength = 3;
		this.lap = 0;
		this.position = 0;
		this.finished = false;
	}
	
	/**
	 * the following are some setters and getters
	 * @return
	 */
	
	public int getSpeed() {
		return this.currentSpeed;
	}
	
	public void changeSpeed() {
		this.currentSpeed = this.speed-this.strength*5;
	}
	
	public void stop() {
		this.currentSpeed = 0;
	}
	
	public void recover () {
		this.currentSpeed = this.speed;
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public int getLocation() {
		return this.position;
	}
	
	public void setLocation(int newPosition) {
		this.position = newPosition;
	}
	
	public int getLap() {
		return this.lap;
	}
	
	public void setLap(int newLap) {
		this.lap = newLap;
	}
	
	public boolean checkCollide() {
		return this.isCollide;
	}
	
	public void collide() {
		this.isCollide=true;
	}
	
	public void repaired() {
		this.isCollide=false;
	}
	
	public int getTime() {
		return this.timeInPS;
	}
	
	public void setTime(int time) {
		this.timeInPS = time;
	}
	
	public boolean checkFinished() {
		return this.finished;
	}
	
	public void finishRace() {
		this.finished = true;
		//this.position=-1;
		//this.currentSpeed=0;
	}
	

	/**
	 * create the toString method of this RaceCar object
	 */
	public String toString() {
		return "RaceCar" + speed + "/" + strength;
	}
}
