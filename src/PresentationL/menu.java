package PresentationL;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class menu extends JFrame {
	JPanel Panel;
	int _width;
	int _height;
	int[] locationsX;
	int[] locationsY;

	public menu() {
		super("Menu");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		setIntSize();
		creat_Panel();
		addButtons();

		setResizable(false);
		setVisible(true);
		pack();

	}

	private void setIntSize() {

		// get the screen size as a java dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// get 2/3 of the height, and 2/3 of the width
		_height = screenSize.height * 2 / 3;
		_width = screenSize.width * 2 / 3;

		// set the jframe height and width
		this.setPreferredSize(new Dimension(_width, _height));

		Point startPostion = new Point();
		startPostion.x = _width / 4;
		startPostion.y = _height / 4;
		this.setLocation(startPostion);
		// setLayout(null);
		locationsX = new int[8];
		locationsY = new int[16];

		for (int x = 0; x < locationsX.length; x++)
			locationsX[x] = _width * x / locationsX.length;
		for (int y = 0; y < locationsY.length; y++)
			locationsY[y] = _height * y / locationsY.length;

	}

	private void creat_Panel() {
		Panel = new JPanel();
		Panel.setBackground(Color.BLUE);
		this.add(Panel);
		Panel.setLayout(null);
		Panel.setVisible(true);

	}

	private void addButtons() {

		TextField textbox = new TextField("hi", 5);
		setComponentSize(textbox);
		// textbox.setSize(_width / 8, _height / 16);
		textbox.setBackground(Color.WHITE);
		textbox.setText("size of board here");
		setComponentPostion(textbox, locationsX[7], locationsY[9]);
		Panel.add(textbox);
		
		JButton Start = new JButton("Click to Start");
		Creat_Button_at(Start, "Click to Start", 4, 12);
		JButton Catpic = new JButton();
		Creat_Button_at(Catpic, "Cat pic", 2, 4);
		JButton hackpic = new JButton();
		Creat_Button_at(hackpic, "hack pic", 2, 6);
		JButton flowerpic = new JButton();
		Creat_Button_at(flowerpic, "flower pic", 2, 8);
		
		Start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("test");
				
				
			}
		});
		Catpic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("test2");
				
			}
		});
		

	}

	private void Creat_Button_at(JButton button, String Buttontxt, int X, int Y) {
		button.setText(Buttontxt);
		setComponentSize(button);
		setComponentPostion(button, locationsX[X], locationsY[Y]);
		Panel.add(button);
	}

	private void setComponentPostion(java.awt.Component com, int X, int Y) {
		com.setLocation(X - com.getWidth() / 2, Y - com.getHeight() / 2);
	}

	private void setComponentSize(java.awt.Component com) {
		com.setSize(locationsX[1], locationsY[1]);
	}

	public static void main(String[] args) {

		new menu();

	}

	

}
