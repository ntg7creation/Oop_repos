package PresentationL;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import LogicL.logic_Board;
import StorageL.Boards;
import StorageL.image_Loader;

public class Game_Menu extends Costom_Frame {

	private JSpinner Size_Spinner;
	private int currentSize;
	private image_Loader my_images[];
	private Boards my_Boards;
	private JLabel boradSize;
	private int currentImage = 0;
	private Game_Menu me;

	public Game_Menu() {

		super(Toolkit.getDefaultToolkit().getScreenSize().width * 2 / 3,
				Toolkit.getDefaultToolkit().getScreenSize().height * 2 / 3, 8, 16);
		this.setTitle("Game Menu");
		my_images = new image_Loader[3];
		my_images[0] = new image_Loader("cat"); // cat images
		my_images[1] = new image_Loader("cyber"); // cyber images
		my_images[2] = new image_Loader("sushi"); // sushi images
		my_Boards = new Boards();
		me = this;
		currentSize = 3; // Defult

		addButtons();
		addLabels();
		creat_Spinner();

		setResizable(false);
		setVisible(true);
		pack();

	}

	public void creat_Spinner() {
		Size_Spinner = new JSpinner(new SpinnerNumberModel(3, 3, 5, 1));
		setComponentSize(Size_Spinner);

		set_Component_Postion(Size_Spinner, locationsX[6], locationsY[5]);
		// Size_Spinner.setVisible(true);
		Panel.add(Size_Spinner);
		Size_Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				currentSize = (int) Size_Spinner.getValue();
				updateLabel();
			}
		});

	}

	private void addButtons() {

		JButton Start = new JButton();
		Creat_Button_at(Start, "Click to Start", 4, 12);
		JButton Randompic = new JButton();
		Creat_Button_at(Randompic, "Random pic", 2, 2);
		JButton Catpic = new JButton();
		Creat_Button_at(Catpic, "Cat pic", 2, 4);
		JButton cyberpic = new JButton();
		Creat_Button_at(cyberpic, "Cyber pic", 2, 6);
		JButton sushipic = new JButton();
		Creat_Button_at(sushipic, "Sushi pic", 2, 8);

		Start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Starting game");
				int[][] board = my_Boards.get_Random_Board_of_Size(currentSize);
				if (board == null)
					JOptionPane.showMessageDialog(null, "no Board of size " + currentSize, "",
							JOptionPane.INFORMATION_MESSAGE);
				else {
					logic_Board logic = new logic_Board(currentSize, board);
					gui_Game_Window game = new gui_Game_Window(currentSize, logic, my_images[currentImage], me);
					game.addKeyListener(game);
					me.setVisible(false);
				}
			}
		});

		Randompic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Random r = new Random();
				change_image(r.nextInt(3));
			}
		});

		Catpic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				change_image(0);
			}
		});
		cyberpic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				change_image(1);

			}
		});
		sushipic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				change_image(2);

			}
		});
		//
		// JButton Size3 = new JButton();
		// Creat_Button_at(Size3, "3x3", 6, 4);
		// JButton Size4 = new JButton();
		// Creat_Button_at(Size4, "4x4", 6, 6);
		// JButton Size5 = new JButton();
		// Creat_Button_at(Size5, "5x5", 6, 8);
		//
		// Size3.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent arg0) {
		// change_size(3);
		// }
		// });
		// Size4.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent arg0) {
		// change_size(4);
		//
		// }
		// });
		// Size5.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent arg0) {
		// change_size(5);
		//
		// }
		// });

	}

	public void change_size(int size) {
		currentSize = size;
		updateLabel();
	}

	public void change_image(int image) {
		currentImage = image;
		Panel.changeImage(my_images[currentImage].get_Images(0, 0));
	}

	private void addLabels() {
		boradSize = new JLabel();
		Creat_Label_at(boradSize, "pleas chose board size", 6, 2);
		updateLabel();
	}

	private void updateLabel() {
		boradSize.setText("the current board size : " + currentSize + "x" + currentSize);
	}

	public static void main(String[] args) {
		System.out.println("test");
		new Game_Menu();

	}

}
