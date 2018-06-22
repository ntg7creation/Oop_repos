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

import assiment4.logic.Board;
import assiment4.logic.Logic;
import assiment4.logic.Timer_Listener;
import assiment4.logic.myTimer;

public class game_Manu extends Custom_Frame implements Timer_Listener, KeyListener {

	// private Image Board;
	private Logic logic;
	private int score = 0;
	private int lifes = 0;
	private JButton speed1;
	private JButton speed2;
	private JButton speed3;
	private JButton Jscore;
	private JButton Jlife;
	private JButton Jtime;
	private int tclick = 0;
	// private Board gameBoard;
	final private int window_offset = 30;

	public game_Manu(Logic logi) {
		super(800, 700, 8, 6);
		this.logic = logi;
		creat_buttons();
		// repaint();
		myTimer T = myTimer.getInstance();
		T.addTimerListenerImportent(this);
		this.setFocusable(true);

		Board temp = logic.get_Current_Board();
		T.set_speed(1);
		if (temp != null)
			temp.start();

		pack();
		this.setFocusable(true);
		this.requestFocusInWindow();
		addKeyListener(this);

	}

	public void paint(Graphics g) {

		// super.paint(g);
		/// ------------------ ignore this fixs a bug that the button dont show up at
		// start
		speed1.setText("X" + tclick);
		speed2.setText("X" + tclick);
		speed3.setText("X" + tclick);
		speed1.setText("X1");
		speed2.setText("X2");
		speed3.setText("X3");
		/// -----------------
		Jscore.setText("score " + score);
		Jlife.setText("lifes " + lifes);
		Jtime.setText("time:" + myTimer.getInstance().getTime_Pass());

		BufferedImage offIm = logic.get_Current_Board().get_Board_image();

		// creates output image
		BufferedImage outputImage = new BufferedImage(700, 700, offIm.getType());
		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(offIm, 0, 0, 700, 700, null);
		g2d.dispose();

		g.drawImage(outputImage, 0, window_offset, null);
	}

	@Override
	public void action() {
		score = logic.getScore();
		lifes = logic.get_lifes();
		if (lifes <= 0) {
			myTimer.getInstance().stop();
			Score_Board next_window = new Score_Board();
			next_window.add_high_score(score);
			this.dispose();
		}
		// System.out.println(score);
		repaint();
	}

	private void creat_buttons() {
		speed1 = new JButton();

		speed1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// System.out.println("test 1");
				myTimer.getInstance().set_speed(1);
			}
		});
		Creat_Button_at(speed1, "X1", 7, 0);
		// speed1.setFocusable(false);
		// speed1.setVisible(true);

		speed2 = new JButton();
		Creat_Button_at(speed2, "X2", 7, 1);
		speed2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myTimer.getInstance().set_speed(2);
			}
		});
		// speed2.setFocusable(false);
		// speed2.setVisible(true);

		speed3 = new JButton();
		Creat_Button_at(speed3, "X3", 7, 2);
		speed3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myTimer.getInstance().set_speed(3);
			}
		});
		// speed3.setFocusable(false);
		// speed3.setVisible(true);

		Jscore = new JButton();
		// Jscore = new JButton();
		Creat_Button_at(Jscore, "score  " + score, 7, 3);

		Jlife = new JButton();
		// Jscore = new JButton();
		Creat_Button_at(Jlife, "life  " + lifes, 7, 4);

		Jtime = new JButton();
		// Jscore = new JButton();
		Creat_Button_at(Jtime, "time :" + myTimer.getInstance().getTime_Pass(), 7, 5);

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
