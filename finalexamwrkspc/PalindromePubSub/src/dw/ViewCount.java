package dw;
// imports
import javax.swing.*;
/**
 * ViewCount Class extends JPanel implements Subscriber
 */
public class ViewCount extends JPanel implements Subscriber {
	// private members
	private static final long serialVersionUID = 1L;
	private JTextField textfield = new JTextField("", 10);
	private Data model;
    /**
     * Constructor for ViewCount Class
     * @param label of type String
     * @param model of type Data
     */
    public ViewCount(String label, Data model) {
        add( new JLabel(label));
        textfield.setText(model.getCountAsString());
        textfield.setEditable(false);
        this.model = model;
        add(textfield);
    }
    /**
     * Method receive of Subscriber
     */
	@Override
	public void receive() {
		textfield.setText(model.getCountAsString());
	}
}