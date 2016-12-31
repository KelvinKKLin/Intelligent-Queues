package objects;

import java.util.ArrayList;

/**
 * This class models a line in Intelligent Queues.
 * 
 * A lane allows shoppers to check out of the store. It adds shoppers
 * into a queue, where it then removes one shopper every time step.
 * 
 * @author Kelvin Lin
 */
public class Lane {

	private boolean isOpen; 			//Whether the lane is open
	private ArrayList<Shopper> queue;	//The queue of customers
	private int id;						//The ID of the queue
	
	/**
	 * The Lane constructor.
	 * 
	 * @param id	The ID of the lane
	 */
	public Lane(int id){
		this.id = id;
		this.isOpen = true;
		this.queue = new ArrayList<Shopper>();
	}
	
	/**
	 * This method returns the ID of the lane.
	 * 
	 * @return The ID of the lane
	 */
	public int getID(){
		return this.id;
	}
	
	/**
	 * This method allows the user to set isOpen
	 * 
	 * @param isOpen A boolean value denoting whether the lane is open
	 */
	public void setIsOpen(boolean isOpen){
		this.isOpen = isOpen;
	}
	
	/**
	 * This method returns the value of isOpen
	 * 
	 * @return <code>true</code> if the lane is open, <code>false</code> otherwise
	 */
	public boolean getIsOpen(){
		return this.isOpen;
	}
	
	/**
	 * This method adds a shopper to the lane.
	 * 
	 * @param shopper The shopper to add
	 */
	public void addShopper(Shopper shopper){
		this.queue.add(shopper);
	}

	/**
	 * This method removes a shopper from the lane.
	 */
	public Shopper removeShopper(){
		return this.queue.remove(0);
	}
	
	/**
	 * This method returns the number of shoppers in the lane.
	 * 
	 * @return	The number of shoppers in the lane
	 */
	public int getSize(){
		return this.queue.size();
	}
	
	/**
	 * This method returns whether the lane is empty.
	 * 
	 * @return <code>true</code> if the lane is empty, <code>false</code> otherwise
	 */
	public boolean isLaneEmpty(){
		return this.queue.isEmpty();
	}
	
	/**
	 * This method updates the lane.
	 * 
	 * If the lane is not empty, then it removes 1 shopper from the lane, and it sets
	 * that person's status to finish shopping.
	 * 
	 * It returns whether a shopper has left the lane.
	 * 
	 * @param message	A reference to the Message object used for object-control communication.
	 * 
	 * @return The updated message object
	 */
	public Message tick(Message message){
		if(!this.queue.isEmpty()){
			Shopper shopper = this.removeShopper();
			shopper.finishShopping();
			message.addMessage("Shopper ID: " + shopper.getID() + " checked out of lane " + this.getID() + ".");
		} 
		return message;
	}
	
}
