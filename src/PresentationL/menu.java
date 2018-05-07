package PresentationL;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class menu extends JFrame {
	JPanel Panel;
	int _width;
	int _height;

	public menu() {
		super("Menu");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		setIntSize();
		// creat_Panel();
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
		setLayout(null);
	}

	private void creat_Panel() {
		Panel = new JPanel();
		Panel.setBackground(Color.BLUE);
		this.add(Panel);

	}

	private void addButtons() {
		// button start
		JButton Start = new JButton("Click to Start");

		Start.resize(_width / 8, _height / 16);
		setButtonPostion(Start, _width / 2, _height * 3 / 4);
		// Start.setBounds(this.WIDTH / 2 - Start.WIDTH / 2, this.HEIGHT * 3 / 4, 300,
		// 300);
		this.add(Start);

	}

	private void setButtonPostion(JButton button, int X, int Y) {

		button.setLocation(X - button.getWidth()/2, Y - button.getHeight()/2 );

	}

	public static void main(String[] args) {

		new menu();

	}

}
