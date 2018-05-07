package PresentationL;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class menu extends JFrame {
	
	public menu() {
		super("Menu");
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		// get the screen size as a java dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// get 2/3 of the height, and 2/3 of the width
		int height = screenSize.height * 2 / 3;
		int width = screenSize.width * 2 / 3;

		// set the jframe height and width
		this.setPreferredSize(new Dimension(width, height));
		
		Point startPostion = new Point();
		startPostion.x =  screenSize.height * 1 / 6;
		startPostion.y =  screenSize.height * 1 / 6;
		this.setLocation(startPostion);

		setResizable(false);
		setVisible(true);
		pack();

	}

	 public static void main(String[] args)  {

		 new menu();
		 

	}
	
}
