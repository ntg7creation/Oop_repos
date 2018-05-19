package PresentationL;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import LogicL.Direction;
import LogicL.logic_Board;
import StorageL.image_Loader;

public class gui_Game_Window extends Custom_Frame implements KeyListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean win = false;

	private Timer timer;
	private final int delay = 1000;
	
	private int move_num;
	private int board_size;
	private int time_past;
	private JLabel time;
	private JLabel num_of_moves;
	private JButton[] buttons;
	private JButton playAgine;
	private JButton exit;
	private logic_Board logic;
	private image_Loader images;
	private Game_Menu menu;

	public gui_Game_Window(int size, logic_Board logic, image_Loader images, Game_Menu menu) {
		super(700, 700, size, size + 1);
		board_size = size;
		this.logic = logic;
		this.images = images;
		time_past = 0;
		this.menu = menu;
		creat_Buttons();
		creat_Labels();

		timer = new Timer(delay, this);
		timer.start();
		this.setFocusable(true);

		fix_Board();
		pack();

	}

	private void creat_Buttons() {
		buttons = new JButton[board_size * board_size];
		int button_num = 0;
		for (button_num = 1; button_num < board_size * board_size; button_num++) {
			BufferedImage tempbuttonIcon = image_Loader.resize(images.get_Image(board_size, button_num), locationsX[1],
					locationsY[1]);
			buttons[button_num] = new JButton(new ImageIcon(tempbuttonIcon));
			buttons[button_num].setName(Integer.toString(button_num));
			// Creat_Button_at(temp, "", x, y);
			setComponentSize(buttons[button_num]);
			Panel.add(buttons[button_num]);
			int name = button_num;
			buttons[button_num].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					action_Button_Click(name);
				}
			});
			buttons[button_num].setFocusable(false);
			buttons[button_num].setBorderPainted(false);
		}
		BufferedImage tempbuttonIcon = image_Loader.resize(images.get_Image(board_size, button_num), locationsX[1],
				locationsY[1]);
		buttons[0] = new JButton(new ImageIcon(tempbuttonIcon));
		buttons[0].setVisible(false);
		buttons[0].setBorderPainted(false);
		setComponentSize(buttons[0]);
		Panel.add(buttons[0]);

		JButton goback = new JButton();
		Creat_Button_at(goback, "click to go back", 0, board_size);
		goback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Undo();

			}
		});
		goback.setFocusable(false);
	}

	private void creat_Labels() {
		num_of_moves = new JLabel();
		Creat_Label_at(num_of_moves, "you have done 0 moves", 1, board_size);
		time = new JLabel();
		Creat_Label_at(time, "you have played for 0 sec", 2, board_size);
	}

	private void action_Button_Click(int name) {
		if (win)
			return;
		Boolean test = logic.movePiece(name);
		System.out.println("you just click button num:" + name + "   " + test);

		if (test) {
			move_num++;
			num_of_moves.setText("you have done " + move_num + " moves");
		}
		fix_Board();

	}

	// set the buttons to match the logic board
	private void fix_Board() {
		int[][] board = logic.getBoard();
		for (int y = 0; y < board.length; y++)
			for (int x = 0; x < board[y].length; x++) {
				int button_num = board[y][x];
				set_Component_Postion(buttons[button_num], locationsX[x], locationsY[y]);
			}
		if (logic.isSolved()) {
			win = true;
			buttons[0].setVisible(true);
			new WinnigFrame(this, menu, time_past, move_num);
//			JOptionPane.showMessageDialog(null,
//					"You Win\n your time was:" + time_past + "\n number of moves: " + move_num, "",
//					JOptionPane.INFORMATION_MESSAGE);
//			exit.setVisible(true);
//			playAgine.setVisible(true);
		}
	}

	@Override
	public void set_Component_Postion(Component com, int X, int Y) {
		com.setLocation(X, Y);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (win)
			return;
		int keyCode = e.getKeyCode();
		Direction direc = null;

		switch (keyCode) {
		case KeyEvent.VK_UP:
			direc = Direction.Up;
			break;
		case KeyEvent.VK_DOWN:
			direc = Direction.Down;
			break;
		case KeyEvent.VK_LEFT:
			direc = Direction.Left;
			break;
		case KeyEvent.VK_RIGHT:
			direc = Direction.Right;
			break;
		}
		// prin(logic.getBoard());
		if (logic.movePiece(direc)) {
			move_num++;
			num_of_moves.setText("you have done " + move_num + " moves");

		}
		fix_Board();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
			Undo();

	}

	private void Undo() {
		if (win)
			return;
		logic.undo();
		fix_Board();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (win)
			timer.stop();
		else {
			time_past++;
			time.setText("you have played for " + time_past + " sec");
		}
	}

}
