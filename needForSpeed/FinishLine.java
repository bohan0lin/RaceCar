//Bohan Lin
//PA#04A
//03/05/2020

package needForSpeed;

public class FinishLine {
	private RaceCar[] car;
	private int num;
	
	public FinishLine() {
		this.car = new RaceCar[10];
		this.num = 0;
	}
	
	/**
	 * get the cars that users input into this finish line class in order to change every race car's field to make them finished the race
	 * also going through the array and see if every car has finished
	 * @param raceCars
	 */
	public void setCarForFinish(RaceCar[] raceCars) {
		for (int i = 0; i < raceCars.length; i++) {
				car[i] = raceCars[i];
		}
		this.num = raceCars.length;
	}
	
	/**
	 * change the field of the car to be finished
	 * @param car
	 */
	public void enterFinishLine(RaceCar car) { 
		car.finishRace();
	}
	
	/**
	 * go through the array, if all cars have finished the race, return that the whole game has been finished
	 * @return
	 */
	public boolean finished() {
		
		for ( int i = 0; i <this.num; i++) {
			if (this.car[i]!=null) {
				if (this.car[i].checkFinished()==false) {
					return false;
				}
			}
		}
		return true;
	}
}

