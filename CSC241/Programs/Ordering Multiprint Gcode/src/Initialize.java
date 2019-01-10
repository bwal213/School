import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 */

/**
 * @author Ben Walker
 *
 */
public class Initialize extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("Define file");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel testLabel = new JLabel("This is a test");
		testLabel.setHorizontalAlignment(JLabel.CENTER);
		
		frame.getContentPane().add(testLabel, BorderLayout.CENTER);
		
		frame.pack();
		
		frame.setSize(840, 600);
		
		frame.setVisible(true);
		
		Panel pnl = new Panel();          // Panel is a container
		Button btn = new Button("Press"); // Button is a component
		pnl.add(btn);                     // The Panel container adds a Button component

	}

}
