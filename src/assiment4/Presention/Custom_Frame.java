package assiment4.Presention;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import assiment3.PresentationL.Image_Panel;

public class Custom_Frame extends JFrame {
	/**
	 * A frame with built in grid
	 */
	private static final long serialVersionUID = 1L;
	protected Image_Panel Panel;
	private int _width;
	private int _height;
	private int Xblocks = 2;
	private int Yblocks = 2;
	protected int[] locationsX;
	protected int[] locationsY;

	/**
	 *
	 * Contractor
	 * 
	 * @param width
	 *            of the window
	 * @param height
	 *            of the window
	 */
	public Custom_Frame(int width, int height, int Xblocks, int Yblocks) {
		super();

		this.Xblocks = Xblocks;
		this.Yblocks = Yblocks;
		_width = width;
		_height = height;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// getContentPane().setLayout(new BoxLayout(getContentPane(),
		// BoxLayout.Y_AXIS));

		setIntSize();
		creat_Panel();

		setResizable(false);
		setVisible(true);
		pack();

	}

	/**
	 *
	 * Initializing window
	 */
	private void setIntSize() {

		this.setPreferredSize(new Dimension(_width, _height + 35));

		Point startPostion = new Point();
		startPostion.x = _width / 4;
		startPostion.y = _height / 14;
		this.setLocation(startPostion);
		// setLayout(null); no need cus we are using a panel
		locationsX = new int[Xblocks];
		locationsY = new int[Yblocks];

		for (int x = 0; x < locationsX.length; x++)
			locationsX[x] = (_width * x) / locationsX.length;
		for (int y = 0; y < locationsY.length; y++)
			locationsY[y] = (_height * y) / locationsY.length;

	}

	/**
	 *
	 * Adding main Panel
	 */
	private void creat_Panel() {
		Panel = new Image_Panel(_width, _height);
		Panel.setBackground(Color.WHITE);
		this.add(Panel);
		Panel.setLayout(null);
		Panel.setVisible(true);

	}

	/**
	 * Creates a Button at the spot x y
	 */
	public void Creat_Button_at(JButton button, String Buttontxt, int X, int Y) {
		if (X >= Xblocks)
			X = 0;
		if (Y >= Yblocks)
			Y = 0;

		button.setText(Buttontxt);
		setComponentSize(button);
		set_Component_Postion(button, locationsX[X], locationsY[Y]);
		button.setFocusable(false);
		Panel.add(button);
	}

	/**
	 * Creates a Label at the position
	 */
	public void Creat_Label_at(JLabel label, String Labetxt, int X, int Y) {
		if (X >= Xblocks)
			X = 0;
		if (Y >= Yblocks)
			Y = 0;
		label.setText(Labetxt);
		int lgth = Labetxt.length() * 10;
		label.setBounds(1, 1, lgth, 20);
		label.setForeground(Color.black);
		label.setOpaque(true);
		label.setBackground(Color.white);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		// label.setBorder(BorderFactory.createLineBorder(Color.black));
		set_Component_Postion(label, locationsX[X], locationsY[Y]);
		Panel.add(label);
	}

	/**
	 * sets the Component position to at x y and center it
	 */
	public void set_Component_Postion(Component com, int X, int Y) {
		com.setLocation(X - com.getWidth() / 2, Y - com.getHeight() / 2);
		// com.setLocation(X, Y );

	}

	/**
	 * sets the Size to be 1 slot
	 */
	public void setComponentSize(Component com) {
		com.setSize(locationsX[1], locationsY[1]);
	}

}
