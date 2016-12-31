package objects;

/**
 * This class models a shopper in Intelligent Queues.
 * 
 * A shopper is an actor who shops for a certain amount of time
 * before getting into a queue. Once in the queue, they remain in the queue until
 * they have finished purchasing their goods.
 * 
 * @author Kelvin Lin
 */
public class Shopper {
	
	private int id;							//The ID of the Shopper
	private int intendedTimeSpentShopping;  //The time the Shopper intends to shop
	private int lane;						//The lane that the Shopper is queued in
	private int timeSpentShopping = 0;		//The time the Shopper spent shopping
	private int timeSpentInLane = 0;		//The time the Shopper spent in the lane
	private boolean finished = false;		//Whether the Shopper has finished shopping
	
	/**
	 * The Shopper constructor
	 * 
	 * @param id							The Shopper's ID; -1 if invalid
	 * @param intendedTimeSpentShopping		The time that the Shopper intends to spend shopping
	 */
	public Shopper(int id, int intendedTimeSpentShopping){
		this.id = id;
		this.intendedTimeSpentShopping = intendedTimeSpentShopping;
		this.timeSpentShopping = 0;
		this.timeSpentInLane = 0;
	}
	
	/**
	 * This method is used to increment the time the Shopper spent shopping at each time step.
	 */
	public void incrementTimeSpentShopping(){
		this.timeSpentShopping++;
	}
	
	/**
	 * This method is used to increment the time the Shopper spent waiting in a queue at each time step.
	 */
	public void incrementTimeSpentInLane(){
		this.timeSpentInLane++;
	}
	
	/**
	 * This method is used in order to determine whether the Shopper is ready to queue.
	 * It does this by checking if the time the user spent shopping is greater than or 
	 * equal to the time that the Shopper intended to shop.
	 * 
	 * @return <code>True</code> if the Shopper is ready to queue, <code>false</code> otherwise.
	 */
	public boolean isReadyToQueue(){
		return this.timeSpentShopping >= this.intendedTimeSpentShopping;
	}
	
	/**
	 * This method queues the Shopper into a lane.
	 * 
	 * It asserts that the Shopper is ready to queue, and this was done because assert
	 * statements are automatically disabled in Java. It will not affect the end
	 * user performance.
	 * 
	 * @param lane	The lane the Shopper queued in
	 */
	public void queue(int lane){
		assert(isReadyToQueue());
		this.lane = lane;
	}
	
	/**
	 * This method sets the <code>finished</code> state variable to true to indicate that
	 * the Shopper has finished shopping.
	 */
	public void finishShopping(){
		this.finished = true;
	}
	
	/**
	 * The ID getter
	 * 
	 * @return	The Shopper's ID
	 */
	public int getID(){
		return this.id;
	}
	
	/**
	 * The intendedTimeSpentShopping getter
	 * 
	 * @return	The Shopper's intended time spent shopping
	 */
	public int getIntendedTimeSpentShopping(){
		return this.intendedTimeSpentShopping;
	}
	
	/**
	 * The timeSpentShopping getter
	 * 
	 * @return	The time that the Shopper spent shopping
	 */
	public int getTimeSpentShopping(){
		return this.timeSpentShopping;
	}
	
	/**
	 * The lane getter
	 * 
	 * @return	The lane that the Shopper is queued in, <code>0</code> if the Shopper is not in a queue
	 */
	public int getLane(){
		return this.lane;
	}
	
	/**
	 * The timeSpentInLane getter
	 * 
	 * @return	The time that the Shopper spent queued in a lane
	 */
	public int getTimeSpentInLane(){
		return this.timeSpentInLane;
	}
	
	/**
	 * The finished getter
	 * 
	 * @return	<code>true</code> if the Shopper has finished shopping, <code>false</code> otherwise
	 */
	public boolean getFinished(){
		return this.finished;
	}
	
	/**
	 * Updates the Shopper object
	 * @param nextAvailableLane	The next available lane at the store
	 * @return <code>true</code> if the Shopper queued, <code>false</code> otherwise
	 */
	public boolean tick(int nextAvailableLane){
		this.incrementTimeSpentShopping();
		if(this.isReadyToQueue()){
			this.queue(nextAvailableLane);
			return true;
		}
		return false;
	}
	
}
