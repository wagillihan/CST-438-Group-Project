package dw;
// imports
import java.util.List;
import java.util.ArrayList;
/**
 * Data Class implements Publisher interface
 */
public class Data implements Publisher {
	// private Members
	private List<Subscriber> subscribers;
    private String data ="";
    /**
     * Default Constructor
     */
    public Data() {
    	this.subscribers = new ArrayList<>();
    }
    /**
     * Getter getText
     * @return String member data
     */
    public String getText() { 
    	return data;
    }
    /**
     * Setter setText
     * @param String str
     */
    public void setText( String str) { 
        if (!data.equals(str)) {
            this.data = str;
            for (Subscriber subscriber : subscribers) {
            	subscriber.receive();
            }
        }
    }
    /**
     * Method getCountAsString
     * @return String representation of data length
     */
    public String getCountAsString() { 
    	return Integer.toString(data.length()); 
    }
    /**
     * Override Method subscribe of Subscriber
     */
	@Override
	public void subscribe(Subscriber subscriber) {
		if (!subscribers.contains(subscriber)){
			subscribers.add(subscriber);
		}	
	}
	/**
     * Override Method unsubscribe of Subscriber
     */
	@Override
	public void unsubscribe(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}
}