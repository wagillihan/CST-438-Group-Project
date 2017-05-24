package dw;
/**
 * Publisher Interface
 */
public interface Publisher {
	/**
	 * method to subscribe subscriber
	 * @param subscriber of type Subscriber
	 */
	public void subscribe(Subscriber subscriber);
	/**
	 * method to unsubscribe subscriber
	 * @param subscriber of type Subscriber
	 */
	public void unsubscribe(Subscriber subscriber);	
}