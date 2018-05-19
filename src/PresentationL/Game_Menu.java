package PresentationL;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import LogicL.logic_Board;
import StorageL.Boards;
import StorageL.image_Loader;

public class Game_Menu extends Custom_Frame {

	/**
	 *  Responsible for game menu, choosing image and board size
	 */
	private static final long serialVersionUID = 1L;
	private int currentSize;
	private int currentImage = 0;
	private image_Loader my_images[];
	private Boards my_Boards;
	private JLabel boardSize;
	private JSpinner Size_Spinner;
	private Game_Menu me;

	public Game_Menu() {

		super(Toolkit.getDefaultToolkit().getScreenSize().width * 2 / 3,
				Toolkit.getDefaultToolkit().getScreenSize().height * 2 / 3, 8, 16);
		this.setTitle("Game Menu");
		my_images = new image_Loader[4];
		my_images[0] = new image_Loader("cat", false); // cat images
		my_images[1] = new image_Loader("cyber", false); // cyber images
		my_images[2] = new image_Loader("sushi", false); // sushi images
		my_Boards = new Boards();
		me = this;
		currentSize = 3; // Default

		addButtons();
		addLabels();
		creat_Spinner();
		Boolean load = true;
		for (image_Loader im : my_images)
			if (im != null && !im.isLoaded())
				load = false;
		if (!load)
			JOptionPane.showMessageDialog(null, "fail to load 1 or more images", "", JOptionPane.INFORMATION_MESSAGE);

		setResizable(false);
		setVisible(true);
		pack();

	}

	public void creat_Spinner() {
		Size_Spinner = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
		setComponentSize(Size_Spinner);

		set_Component_Postion(Size_Spinner, locationsX[6], locationsY[4]);
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
		JButton costoppic = new JButton();
		Creat_Button_at(costoppic, "upload pic", 6, 8);

		Start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Starting game");
				int[][] board = my_Boards.get_Random_Board_of_Size(currentSize);
				logic_Board logic;
				if (board == null) {
					// JOptionPane.showMessageDialog(null, "no Board of size " + currentSize, "",
					// JOptionPane.INFORMATION_MESSAGE);
					board = new int[currentSize][];
					for (int i = 0; i < currentSize; i++) {
						board[i] = new int[currentSize];
						for (int j = 0; j < currentSize; j++) {
							board[i][j] = i + j * currentSize + 1;
						}
					}
					board[currentSize - 1][currentSize - 1] = 0;
					logic = new logic_Board(currentSize, board);
					logic.Random_Board();
				} else {
					logic = new logic_Board(currentSize, board);
				}
				if (currentImage == 3 | currentSize > 5 | currentSize < 3)
				{
					my_images[currentImage].splitImage(currentSize);
				}
				gui_Game_Window game = new gui_Game_Window(currentSize, logic, my_images[currentImage], me);
				game.addKeyListener(game);
				me.setVisible(false);
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
		costoppic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPEG Images", "jpg", "jpeg");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(me);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					String path = chooser.getSelectedFile().getPath();
					my_images[3] = new image_Loader(path, true);
					if (my_images[3].isLoaded())
						change_image(3);
					else
						JOptionPane.showMessageDialog(null, "fail to load custom image", "",
								JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

	}

	private void change_image(int image) {
		currentImage = image;
		Panel.changeImage(my_images[currentImage].get_Image(0, 0));
	}

	private void addLabels() {
		boardSize = new JLabel();
		Creat_Label_at(boardSize, "pleas chose board size", 6, 2);
		updateLabel();
	}

	private void updateLabel() {
		boardSize.setText("the current board size : " + currentSize + "x" + currentSize);
	}

}
