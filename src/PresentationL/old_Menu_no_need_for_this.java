package PresentationL;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import StorageL.image_Loader;

public class old_Menu_no_need_for_this extends JFrame {
	Image_Panel Panel;
	private int _width;
	private int _height;
	private int Xblocks = 8;
	private int Yblocks = 16;
	private int currentSize;
	private int[] locationsX;
	private int[] locationsY;
	private image_Loader my_images;
	JLabel boradSize;

	public old_Menu_no_need_for_this() {
		//super("Menu");
		this.setTitle("menu");
		my_images = new image_Loader();
		currentSize = 3; // Default
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		setIntSize();
		creat_Panel();
		addButtons();
		addLabbels();

		setResizable(false);
		setVisible(true);
		pack();

	}

	private void setIntSize() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		_height = screenSize.height * 2 / 3;
		_width = screenSize.width * 2 / 3;

		this.setPreferredSize(new Dimension(_width, _height));

		Point startPostion = new Point();
		startPostion.x = _width / 4;
		startPostion.y = _height / 4;
		this.setLocation(startPostion);
		// setLayout(null); no need cus we are using a panel
		locationsX = new int[Xblocks];
		locationsY = new int[Yblocks];

		for (int x = 0; x < locationsX.length; x++)
			locationsX[x] = _width * x / locationsX.length;
		for (int y = 0; y < locationsY.length; y++)
			locationsY[y] = _height * y / locationsY.length;

	}

	private void creat_Panel() {
		Panel = new Image_Panel(_width, _height);
		Panel.setBackground(Color.BLUE);
		this.add(Panel);
		Panel.setLayout(null);
		Panel.setVisible(true);

	}

	private void addButtons() {

		JButton Start = new JButton("Click to Start");
		Creat_Button_at(Start, "Click to Start", 4, 12);
		JButton Catpic = new JButton();
		Creat_Button_at(Catpic, "Cat pic", 2, 4);
		JButton cyberpic = new JButton();
		Creat_Button_at(cyberpic, "Cyber pic", 2, 6);
		JButton sushipic = new JButton();
		Creat_Button_at(sushipic, "Sushi pic", 2, 8);

		Start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("test");

			}
		});

		Catpic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Panel.changeImage(my_images.get_Cat(0, 0));
			}
		});
		cyberpic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Panel.changeImage(my_images.get_cyber(0, 0));

			}
		});
		sushipic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Panel.changeImage(my_images.get_sushi(0, 0));

			}
		});

		JButton Size3 = new JButton();
		Creat_Button_at(Size3, "3x3", 6, 4);
		JButton Size4 = new JButton();
		Creat_Button_at(Size4, "4x4", 6, 6);
		JButton Size5 = new JButton();
		Creat_Button_at(Size5, "5x5", 6, 8);

		Size3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentSize = 3;
				updateLabel();
			}
		});
		Size4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentSize = 4;
				updateLabel();

			}
		});
		Size5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentSize = 5;
				updateLabel();

			}
		});

	}

	private void addLabbels() {
		String size = Integer.toString(currentSize);
		boradSize = new JLabel();
		Creat_Label_at(boradSize, "pleas chose board size", 6, 2);

	}

	private void updateLabel() {
		boradSize.setText("the current board size : " + currentSize + "x" + currentSize);
	}

	private void Creat_Button_at(JButton button, String Buttontxt, int X, int Y) {
		if (X >= Xblocks)
			X = 0;
		if (Y >= Yblocks)
			Y = 0;

		button.setText(Buttontxt);
		setComponentSize(button);
		setComponentPostion(button, locationsX[X], locationsY[Y]);
		Panel.add(button);
	}

	private void Creat_Label_at(JLabel label, String Labetxt, int X, int Y) {
		if (X >= Xblocks)
			X = 0;
		if (Y >= Yblocks)
			Y = 0;
		label.setText(Labetxt);
		int lgth = Labetxt.length() * 10;
		label.setBounds(1, 1, lgth, 20);
		label.setForeground(Color.black);
		label.setOpaque(true);
		label.setBackground(Color.red);
		label.setHorizontalAlignment(label.CENTER);
		//label.setBorder(BorderFactory.createLineBorder(Color.black));
		setComponentPostion(label, locationsX[X], locationsY[Y]);
		Panel.add(label);
	}
	

	private void setComponentPostion(java.awt.Component com, int X, int Y) {
		com.setLocation(X - com.getWidth() / 2, Y - com.getHeight() / 2);
	}

	private void setComponentSize(java.awt.Component com) {
		com.setSize(locationsX[1], locationsY[1]);
	}

	public static void main(String[] args) {

		new old_Menu_no_need_for_this();

	}

}
