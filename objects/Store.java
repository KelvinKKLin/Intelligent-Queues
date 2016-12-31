package objects;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class models a store in Intelligent Queues.
 * 
 * A store is where all of the events occur. Shoppers enter the store at
 * a rate determined by the schedule. Then, shoppers will queue in a lane
 * at the store, where they will check out and then exit the store.
 * 
 * @author Kelvin Lin
 */
public class Store {

	private int numberOfLanes;					  //The number of lanes at the store
	private Lane[] lanes;						  //An array containing the lanes at a store 
	private int numberOfMinutesOpened;			  //The number of ticks at the store
	private int time;							  //The current time
	private ArrayList<Shopper> customers; 		  //The shoppers at the store
	private Schedule schedule;					  //The customer schedule
	private Random random;						  //A random number generator
	private boolean isOpen;						  //Whether the store is open
	
	/**
	 * The Store constructor
	 * 
	 * @param numberOfLanes	The number of lanes in the store
	 * @param numberOfMinutesOpened	The number of minutes the store is open for
	 * @param schedule	The customer schedule
	 */
	public Store(int numberOfLanes, int numberOfMinutesOpened, Schedule schedule){
		
		//Populate the lanes
		this.numberOfLanes = numberOfLanes;
		this.lanes = new Lane[this.numberOfLanes];
		for(int i = 0; i < this.numberOfLanes; i++){
			this.lanes[i] = new Lane(i);
		}
		
		//Initialize the other variables
		this.numberOfMinutesOpened = numberOfMinutesOpened;
		this.schedule = schedule;
		this.time = 0;
		this.customers = new ArrayList<Shopper>();
		this.random = new Random();
		this.isOpen = true;
	}
	
	/**
	 * This method updates the store.
	 * 
	 * It first determines if a new customer has entered the store. It does so by
	 * randomly generating a number, and comparing it against the store schedule.
	 * 
	 * It then updates every person shopping in the store. If the person is ready
	 * to queue, then the person is queued into a lane.
	 * 
	 * It then updates every lane in the store.
	 * 
	 * Finally, it updates the time, and determines whether the store is opened.
	 * 
	 * @return A Message object containing the status of the update
	 */
	public Message tick(){
		Message message = new Message();
		message.addMessage("Current Time: " + this.time + "\t Is Store Open: " + this.isOpen);

		//Get number of new customers
		if(this.isOpen && random.nextDouble() < schedule.getAmountOfCustomersAt(time)){
			int timeSpentShopping = schedule.getTimeCustomerSpentShopping(time);
			this.customers.add(new Shopper(time, timeSpentShopping));
			message.addMessage("Shopper ID: " + time + " entered the store.");
		}
		
		/*
		 * For every shopper in the store, update their status.
		 * If they queued, then add them to a lane and remove
		 * them from the ArrayList of customers.
		 */
		for(int i = 0; i < this.customers.size(); i++){
			Shopper shopper = this.customers.get(i);
			boolean queued = shopper.tick(this.getNextAvailableLane());
			if(queued){
				this.lanes[shopper.getLane()].addShopper(shopper);
				message.addMessage("Shopper ID: " + shopper.getID() + " queued in lane " + shopper.getLane() + ".");
				this.customers.remove(shopper);
			}
		}
		
		//Move each lane in the store, and set that person to finish
		for(Lane lane : this.lanes){
			message = lane.tick(message);
		}
		
		this.time++;
		this.isOpen = this.time < this.numberOfMinutesOpened;
		
		message.addMessage("\n");
		return message;
	}
	
	/**
	 * This method returns the value of isOpen.
	 * 
	 * @return The value of isOpen
	 */
	public boolean getIsOpen(){
		return this.isOpen;
	}
	
	/**
	 * This method returns the collection of lanes in the store.
	 * 
	 * @return The collection of lanes in the store
	 */
	public Lane[] getLanes(){
		return this.lanes;
	}
	
	/**
	 * This method returns whether there are customers still shopping
	 * in the store.
	 * 
	 * @return <code>true</code> if customers is empty, <code>false</code> otherwise.
	 */
	public boolean isCustomersEmpty(){
		return this.customers.isEmpty();
	}
	
	/**
	 * This method returns whether all of the lanes are empty.
	 * 
	 * @return <code>true</code> if all of the lanes are empty, <code>false</code> otherwise.
	 */
	public boolean areLanesEmpty(){
		boolean lanesAreEmpty = true;
		for(Lane lane : this.lanes){
			lanesAreEmpty = lanesAreEmpty && lane.isLaneEmpty();
		}
		return lanesAreEmpty;
	}
	
	/**
	 * This method returns whether the store is empty.
	 * 
	 * The store is considered to be empty when there are no customers
	 * shopping, and there are no customers waiting in a line.
	 * 
	 * @return	<code>true</code> if the store is empty, <code>false</code> otherwise.
	 */
	public boolean isStoreEmpty(){
		return this.isCustomersEmpty() && this.areLanesEmpty();
	}
	
	/**
	 * This method returns the next available lane.
	 * 
	 * It does so by iterating through each lane, and
	 * finding the lane with the fewest number of people queued.
	 * 
	 * The algorithm for determining the next available lane is
	 * subject to change.
	 * 
	 * @return The ID of the next available lane
	 */
	private int getNextAvailableLane(){
		int minID = this.lanes[0].getID();
		for(Lane lane : this.lanes){
			if(lane.getSize() < this.lanes[minID].getSize()){
				minID = lane.getID();
			}
		}
		return minID;
	}
	
}
