//Bohan Lin
//PA#04A
//03/05/2020

package needForSpeed;

public class PitStop {
	
	private RaceCar[] car;
	private int num;
	
	public PitStop() {
		this.car = new RaceCar[10];
		this.num = 0; // use this number field to record how many race cars in total are in the race track
	}
	
	/**
	 * get the cars that users input into this pit stop class in order to change every race car's field to make them stop or repaired
	 * @param raceCars
	 */
	public void setCarForPS(RaceCar[] raceCars) {
		for (int i = 0; i < raceCars.length; i++) {
				car[i] = raceCars[i];
		}
		this.num = raceCars.length;
	}
	
	/**
	 * making a car into the pit stop by making it stop at the position 75 and can only come out after 2 ticks
	 * @param car
	 */
	public void enterPitStop(RaceCar car) { 
		car.setTime(2);
		car.stop();
		car.repaired();
	}
	
	/**
	 * in the pit stop, the tick method that runs to compute the times the cars remaining in the pti stop
	 */
	public void tick() {
		for (int i =0; i <num; i++) {
			this.car[i].setTime(this.car[i].getTime()-1);
		}
	}
	
	/**
	 * the car get out of the pit stop and get their original speed
	 * @param car
	 */
	public void exitPitStop(RaceCar car) {
		car.recover();
		car.repaired();
	}
}
