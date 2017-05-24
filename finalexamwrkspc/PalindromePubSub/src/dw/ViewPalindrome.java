package dw;
// import
import javax.swing.*;
/**
 * ViewPalindrome Class extends JPanel implements Subscriber 
 */
public class ViewPalindrome extends JPanel implements Subscriber {
	// private members
	private static final long serialVersionUID = 1L;
	private JTextField textfield = new JTextField("", 10);
	private Data model;
	/**
	 * Constructor for ViewPalindrome Class
	 * @param label of type String
	 * @param model of type Data
	 */
    public ViewPalindrome (String label, Data model) {
        add( new JLabel(label));
        textfield.setText( Palindrome.isPalindrome(model.getText() ) ? "yes" : "no" );
        textfield.setEditable(false); 
        this.model = model;
        add(textfield);
    }
    /**
     * Method receive of Subscriber
     */
	@Override
	public void receive() {
		textfield.setText( Palindrome.isPalindrome(model.getText() ) ? "yes" : "no" );
	}
}