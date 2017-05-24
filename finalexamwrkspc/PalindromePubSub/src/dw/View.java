package dw;
// imports
import javax.swing.*;
import javax.swing.event.*;
/**
 * View Class extends JPanel
 */
public class View extends JPanel {
	// private members
	private static final long serialVersionUID = 1L;
	private JTextField textfield = new JTextField("", 10);
    private Data  data;
    /**
     * Constructor for View Class
     * @param label of type String
     * @param model of type Data
     */
    public View(String label, Data model) {
        data = model;
        add( new JLabel(label));
        textfield.setText(data.getText());
        add(textfield);
        //Listener for textField
        textfield.getDocument().addDocumentListener( new DocumentListener() {
			public void changedUpdate(DocumentEvent ev) {   				
			}
			public void removeUpdate(DocumentEvent ev){
			    data.setText( textfield.getText());
			}
			public void insertUpdate(DocumentEvent ev){
			    data.setText( textfield.getText());
			}
        });
    }
}
