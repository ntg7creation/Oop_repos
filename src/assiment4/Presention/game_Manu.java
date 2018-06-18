package assiment4.Presention;

import java.awt.Graphics;
import java.awt.Image;

import assiment4.Logic.Board;
import assiment4.Logic.Timer_Listener;

public class game_Manu extends Custom_Frame implements Timer_Listener {

	//private Image Board;
	private Board gameBoard;
	final private int window_offset = 30;
	
	public game_Manu() {
		super(800, 800, 1, 1);
		int[][] tempcsv = new int[][] {
			{1,1,1,1,1,1,1,1,1,1,1,1},
			{1,2,2,2,2,2,1,2,2,2,2,1},
			{1,2,2,2,2,16,2,2,2,2,2,1},
			{1,2,4,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,8,2,2,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,2,1,2,2,1},
			{1,2,2,2,2,2,2,1,2,2,2,1},
			{1,2,32,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,1},
			{1,1,1,1,1,1,1,1,1,1,1,1},
		};
		gameBoard= new Board(tempcsv); // will change with csv
		repaint();

	}

	public void paint(Graphics g) {
		// super.paint(g);
		Image offIm = gameBoard.get_Board_image();
		g.drawImage(offIm, 0, window_offset, null);
	}

	public static void main(String[] arg) {
		game_Manu game = new game_Manu();
	}

	@Override
	public void action() {
		repaint();
	}
}
