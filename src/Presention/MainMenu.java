package Presention;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import Logic.Logic;

public class MainMenu extends JFrame {

	final private int window_offset = 30;
	Logic logic;

	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(500, 500));
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setSize(500, 500);

		logic = new Logic();
		BufferedImage img;
		ImageIcon icon;

		JButton scoringBoard = new JButton("Score Board");
		scoringBoard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Score_Board();
			}
		});
		scoringBoard.setLocation(175, 70);
		scoringBoard.setVisible(true);
		scoringBoard.setSize(150, 30);
		// ---------------------------------------------------
		JButton board1 = new JButton();
		board1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start_at_board(1);
			}
		});
		board1.setLocation(25, 200);
		board1.setVisible(true);
		board1.setSize(150, 150);
		img = logic.get_Board(1).get_Board_image();
		icon = new ImageIcon(resize(img, 150, 150));
		board1.setIcon(icon);
		// ---------------------------------------------------
		JButton board2 = new JButton();
		board2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start_at_board(2);
			}
		});
		board2.setLocation(175, 200);
		board2.setVisible(true);
		board2.setSize(150, 150);
		img = logic.get_Board(2).get_Board_image();
		icon = new ImageIcon(resize(img, 150, 150));
		board2.setIcon(icon);
		// ---------------------------------------------------
		JButton board3 = new JButton();
		board3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start_at_board(3);
			}
		});
		board3.setLocation(325, 200);
		board3.setVisible(true);
		board3.setSize(150, 150);
		img = logic.get_Board(3).get_Board_image();
		icon = new ImageIcon(resize(img, 150, 150));
		board3.setIcon(icon);
		//-------------------------------------------

		panel.add(board3);
		panel.add(board2);
		panel.add(board1);
		panel.add(scoringBoard);
		panel.setVisible(true);

		pack();
		this.add(panel);
		this.setVisible(true);
		repaint();
	}

	public void start_at_board(int num) {
		logic.set_Current_Board(num);
		new game_Manu(logic);
		this.dispose();
	}

	public static void main(String[] arg) {
		MainMenu m = new MainMenu();
		// game_Manu game = new game_Manu(new Logic());
	}

	public BufferedImage resize(BufferedImage Im, int x, int y) {
		BufferedImage offIm = Im;

		// creates output image
		BufferedImage outputImage = new BufferedImage(x, y, offIm.getType());
		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(offIm, 0, 0, x, y, null);
		g2d.dispose();
		return outputImage;
	}
}
