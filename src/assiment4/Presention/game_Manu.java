package assiment4.Presention;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import assiment4.logic.Board;
import assiment4.logic.Logic;
import assiment4.logic.Timer_Listener;
import assiment4.logic.myTimer;

public class game_Manu extends Custom_Frame implements Timer_Listener, KeyListener {

	// private Image Board;
	private Logic logic;
	// private Board gameBoard;
	final private int window_offset = 30;

	public game_Manu() {
		super(800, 700, 1, 1);

		repaint();
		myTimer T = myTimer.getInstance();
		T.addTimerListener(this);
		this.setFocusable(true);
		logic = new Logic();
		Board temp = logic.get_Current_Board();
		T.set_speed(20);
		if (temp != null)
			temp.start(T);

		pack();
		this.setFocusable(true);
		this.requestFocusInWindow();
		addKeyListener(this);
	}

	public void paint(Graphics g) {
		// super.paint(g);

		if(logic.get_Current_Board() == null)
		{
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
		repaint();
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
}
