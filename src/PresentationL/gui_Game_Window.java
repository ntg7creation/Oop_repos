package PresentationL;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import LogicL.Direction;
import LogicL.logic_Board;
import StorageL.image_Loader;

public class gui_Game_Window extends Costom_Frame implements KeyListener {

	private int[][] preboard;
	private int[][] nowboard;
	private JButton[] buttons;
	private logic_Board logic;
	private image_Loader images;
	private int board_size;

	public gui_Game_Window(int size, logic_Board logic, image_Loader images) {
		super(600, 600, size, size + 1);
		board_size = size;
		this.logic = logic;
		this.images = images;
		creat_Buttons();

		this.setFocusable(true);


		fix_Board();
		pack();

	}

	public void creat_Buttons() {
		buttons = new JButton[board_size * board_size];
		JButton temp = null;
		for (int y = 0; y < board_size; y++)
			for (int x = 0; x < board_size; x++) {
				int button_num = x + y * board_size;

				BufferedImage tempbuttonIcon = image_Loader.resize(images.get_Images(board_size, button_num + 1),
						locationsX[1], locationsY[1]);
				temp = new JButton(new ImageIcon(tempbuttonIcon));
				buttons[button_num] = temp;
				temp.setName(Integer.toString(button_num));
				Creat_Button_at(temp, "", x, y);
				temp.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						action_Button_Click(button_num);
					}
				});
				temp.setFocusable(false);
			}
		buttons[buttons.length - 1].setVisible(false);
		
		JButton goback = new JButton();
		Creat_Button_at(goback, "click to go back", 0, board_size);
		goback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				logic.undo();
				fix_Board();
				
			}
		});
		goback.setFocusable(false);
	}

	public void action_Button_Click(int name) {
		System.out.println("you just click button num:" + name);
		logic.movePiece(name);
		fix_Board();

	}

	public void fix_Board() {
		int[][] board = logic.getBoard();
		for (int y = 0; y < board.length; y++)
			for (int x = 0; x < board[y].length; x++) {
				int button_num = board[y][x];
				set_Component_Postion(buttons[button_num], locationsX[x], locationsY[y]);
			}
	}

	@Override
	public void set_Component_Postion(Component com, int X, int Y) {
		com.setLocation(X, Y);
	}

	@Override
	public void keyReleased(KeyEvent e) {
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
		//prin(logic.getBoard());
		logic.movePiece(direc);
		//prin(logic.getBoard());
		fix_Board();
	}

	public void prin(int[][] array)
	{
		for (int[] is : array) {
			for (int i : is) {
				System.out.print(i+",");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		int keyCode = e.getKeyCode();
		System.out.println("test");

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

}
