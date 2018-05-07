package test_and_samples;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Hello {
	
	public static void main(String args[]){
		JFrame frame = new JFrame("Title Bar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton click = new JButton("This is a button");
		Container cp = frame.getContentPane();
		cp.add(click);

		frame.pack();
		frame.setVisible(true);

	}
}