package PresentationL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import LogicL.logic_Board;
import StorageL.image_Loader;

public class gui_Game_Window extends Costom_Frame implements ActionListener {

	private JButton[] buttons;
	private logic_Board logic;
	private image_Loader images;
	private int board_size;

	public gui_Game_Window(int size, logic_Board logic, image_Loader images) {
		super(600, 600, size, size + 1);
		board_size = size;
		this.logic = logic;
		this.images = images;
		creat_buttons();
	}

	public void creat_buttons() {
		buttons = new JButton[board_size * board_size - 1];
		for (int y = 0; y < board_size; y++)
			for (int x = 0; x < board_size; x++) {
				int button_num = x + y * board_size;
				if (button_num != board_size * board_size) {
					buttons[button_num] = new JButton(Integer.toString(button_num));
				//	Creat_Button_at(buttons[button_num], Integer.toString(button_num), x, y);
				}
			}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setComponentPostion(java.awt.Component com, int X, int Y) {
		// com.setLocation(X - com.getWidth() / 2, Y - com.getHeight() / 2);
		com.setLocation(X, Y);

	}

	public void action_button_click() {

	}

}
