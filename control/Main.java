package control;

import objects.Message;
import objects.Schedule;
import objects.Store;

/**
 * This is a text-based version of Intelligent Queues.
 * 
 * @author Kelvin Lin
 * @version 1.0
 */
public class Main {
	
	//Symbolic Parameters
	private static final int NUMBER_OF_LANES = 10;
	private static final int NUMBER_OF_MINUTES_OPENED = 100;
	
	//Scheduling Variables
	private static double[] scheduleValues;
	private static int[] timeShoppingValues;
	private static Schedule schedule;
	
	/**
	 * The main method
	 * 
	 * This method initializes all of the required variables, and it contains the
	 * simulation logic for the application.
	 * 
	 * @param args	Command line arguments
	 */
	public static void main(String[] args){
		
		//Initialize the schedule
		scheduleValues = new double[NUMBER_OF_MINUTES_OPENED];
		timeShoppingValues = new int[NUMBER_OF_MINUTES_OPENED];
		for(int i = 0; i < NUMBER_OF_MINUTES_OPENED; i++){
			scheduleValues[i] = 1;
			if(i < NUMBER_OF_MINUTES_OPENED/2){
				timeShoppingValues[i] = i;
			} else{
				timeShoppingValues[i] = NUMBER_OF_MINUTES_OPENED - i + 1;
			}
		}
		schedule = new Schedule(scheduleValues, timeShoppingValues);
		
		//Initialize the store
		Store store = new Store(NUMBER_OF_LANES, NUMBER_OF_MINUTES_OPENED, schedule);
		
		//While the simulation is not complete, get messages from the store
		//and output to the console
		while(store.getIsOpen() || !store.isStoreEmpty()){
			Message messages = store.tick();
			for(String message : messages.getMessages()){
				System.out.println(message);
			}
		}
		
		//Notify the user that the simulation has finished
		System.out.println("Simulation finished.");
		
	}

}
