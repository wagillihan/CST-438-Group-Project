package dw;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;
public class Weather  {
    JLabel centerText;
    final ExecutorService service = Executors.newFixedThreadPool(1);;   // for background threads 

    public Weather( ) {
        JPanel outer, top, center;
        JTextField cityField;

        JFrame window = new JFrame();
        window.setSize(800, 800);

        top = new JPanel();
        top.add( new Label("Enter City"));
        cityField = new JTextField("",25);
        top.add( cityField);
        cityField.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
                    //DEBUG System.out.println("ActionEvent "+cityField.getText());
                   cityField.setEnabled(false);
                   service.submit( new FetchTask( cityField, centerText) );
                }
            });
        outer = new JPanel();
        window.add( outer );
        outer.setLayout(new BorderLayout());

        outer.add(top, BorderLayout.NORTH);

        center = new JPanel();
        outer.add(center, BorderLayout.CENTER);
        centerText = new JLabel("Waiting .... " , Label.LEFT);
        center.add(centerText);

        window.addWindowListener( new WeatherWindowClosing() );
        window.setVisible(true);

    }

    public  class WeatherWindowClosing extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent we) {
            //DEBUG System.out.println("Window Closing");
            service.shutdownNow();
        }
    }

    public static void main(String[] args) {
        new Weather();
    }
}