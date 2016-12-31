package objects;

/**
 * This class models a schedule in Intelligent Queues.
 * 
 * A schedule shows the likelihood of a customer entering a store at
 * every possible time frame while the store is open. It is denoted with
 * a double array with numbers between 0 and 1 (exclusive), with an 
 * element for every possible time step. It is assumed that all values
 * are 0 outside those time steps.
 * 
 * @author Kelvin Lin
 */
public class Schedule {

	private double[] amountOfCustomers;	//The likelihood of a customer entering the store
	private int[] timeSpentShopping;
	
	/**
	 * The Schedule constructor
	 * 
	 * @param amountOfCustomers
	 *            A double array denoting the likelihood of a customer entering
	 *            a store at any given point in time.
	 * @param timeSpentShopping
	 * 			  A double array denoting the time spent shopping for a customer
	 *            entering at the indexed time.
	 */
	public Schedule(double[] amountOfCustomers, int[] timeSpentShopping){
		this.amountOfCustomers = amountOfCustomers;
		this.timeSpentShopping = timeSpentShopping;
	}
	
	/**
	 * This method returns the likelihood of a customer entering a store at a
	 * given point in time. 
	 * 
	 * If the time is outside the bounds of the schedule, then it will return 0.0.
	 * 
	 * @param time	The time to retrieve the likelihood at
	 * @return	The likelihood of a customer entering the store
	 */
	public double getAmountOfCustomersAt(int time){
		if(time < this.amountOfCustomers.length){
			return this.amountOfCustomers[time];
		} else{
			return 0.0;
		}
	}
	
	/**
	 * This method returns the schedule as a double array.
	 * 
	 * @return	The schedule as a double array
	 */
	public double[] getAmountOfCustomers(){
		return this.amountOfCustomers;
	}
	
	/**
	 * This method returns the amount of time a customer entering at
	 * time t spends shopping.
	 * 
	 * @param time	The time to retrieve the time spent shopping at
	 * @return	The time the customer spent shopping
	 */
	public int getTimeCustomerSpentShopping(int time){
		return this.timeSpentShopping[time];
	}
	
	/**
	 * This method returns the timeSpentShopping schedule.
	 * 
	 * @return	The time spent shopping schedule
	 */
	public int[] getTimeSpentShopping(){
		return this.timeSpentShopping;
	}
	
}
