package dw;
//imports
import javax.swing.*;
import java.awt.*;
/**
 * App Class
 */
public class App {
	/**
	 * Method Main
	 * @param args of type String[]
	 */
    public static void main(String[] args) {
        // Class instances
    	Data data = new Data();
        ViewCount countView = new ViewCount("Character Count", data);
        ViewPalindrome palindromeView = new ViewPalindrome("Palindrome?", data);
        // subscribe to Publisher
        data.subscribe(countView);
        data.subscribe(palindromeView);
        // instantiate App
        JFrame window = new JFrame();
        window.setSize(300, 200);
        JPanel panel = new JPanel();
        panel.setLayout( new BorderLayout());
        panel.add(new View("Text", data), BorderLayout.CENTER);
        panel.add(countView, BorderLayout.NORTH) ;
        panel.add(palindromeView, BorderLayout.SOUTH);
        window.add(panel);
        window.setVisible(true);
    }
}