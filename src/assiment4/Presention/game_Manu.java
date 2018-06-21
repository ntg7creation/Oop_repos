package assiment4.Presention;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;

import assiment4.logic.Board;
import assiment4.logic.Logic;
import assiment4.logic.Timer_Listener;
import assiment4.logic.myTimer;

public class game_Manu extends Custom_Frame implements Timer_Listener, KeyListener {

	// private Image Board;
	private Logic logic;
	private int score = 0;
	private JLabel Jscore;
	// private Board gameBoard;
	final private int window_offset = 30;
	private Boolean first_paint = true;

	public game_Manu() {
		super(800, 700, 8, 6);

		repaint();
		myTimer T = myTimer.getInstance();
		T.addTimerListenerImportent(this);
		this.setFocusable(true);
		logic = new Logic();
		Board temp = logic.get_Current_Board();
		T.set_speed(1);
		if (temp != null)
			temp.start(T);

		pack();
		this.setFocusable(true);
		this.requestFocusInWindow();
		addKeyListener(this);
		creat_buttons();
	}

	public void paint(Graphics g) {
		if (first_paint) {
			super.paint(g);
			first_paint = false;
		}
		if (logic.get_Current_Board() == null) {
			System.out.println();
		}

		BufferedImage offIm = logic.get_Current_Board().get_Board_image();

		// creates output image
		BufferedImage outputImage = new BufferedImage(700, 700, offIm.getType());
		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(offIm, 0, 0, 700, 700, null);
		g2d.dispose();

		g.drawImage(outputImage, 0, window_offset, null);
	}

	public static void main(String[] arg) {
		game_Manu game = new game_Manu();
	}

	@Override
	public void action() {
		score = logic.getScore();
		repaint();
	}

	private void creat_buttons() {
		JButton speed1 = new JButton();
		Creat_Button_at(speed1, "X1", 7, 0);
		speed1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// System.out.println("test 1");
				myTimer.getInstance().set_speed(1);
			}
		});
		speed1.setFocusable(false);
		speed1.setVisible(true);

		JButton speed2 = new JButton();
		Creat_Button_at(speed2, "X2", 7, 1);
		speed2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myTimer.getInstance().set_speed(2);
			}
		});
		speed2.setFocusable(false);
		speed2.setVisible(true);

		JButton speed3 = new JButton();
		Creat_Button_at(speed3, "X3", 7, 2);
		speed3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myTimer.getInstance().set_speed(3);
			}
		});
		speed3.setFocusable(false);
		speed3.setVisible(true);
		//
		// Jscore = new JLabel();
		// Creat_Label_at(Jscore, "your score\n" + score, 7, 3);
		// Jscore.setFocusable(false);
		// Jscore.setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		logic.get_Current_Board().user_input(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void set_Component_Postion(Component com, int X, int Y) {
		// com.setLocation(X - com.getWidth() / 2, Y - com.getHeight() / 2);
		com.setLocation(X - 5, Y);

	}
}
