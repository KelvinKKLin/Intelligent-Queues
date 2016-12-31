package objects;

import java.util.ArrayList;

/**
 * This class models a message packet used for inter-object
 * communication.
 * 
 * A message contains an ArrayList of Strings which denote 
 * messages to be sent to a recipient.
 * 
 * @author Kelvin Lin
 */
public class Message {

	ArrayList<String> messages = new ArrayList<String>(); //An ArrayList of messages
	
	/**
	 * This method adds a message to the Message object.
	 * 
	 * @param message The message to add
	 */
	public void addMessage(String message){
		this.messages.add(message);
	}
	
	/**
	 * This method returns all of the messages in the Message object.
	 * 
	 * @return The messages in the Message object
	 */
	public ArrayList<String> getMessages(){
		return this.messages;
	}
	
}
