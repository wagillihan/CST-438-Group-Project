package dw;
/**
 * Subscriber interface
 */
public interface Subscriber {
	/**
	 * method to update the subscriber, used by publisher
	 */
	public void receive();
}