package assiment4.Presention;

import java.awt.Graphics;
import java.awt.Image;

import assiment4.logic.Board;
import assiment4.logic.Timer_Listener;

public class game_Manu extends Custom_Frame implements Timer_Listener {

	//private Image Board;
	private Board gameBoard;

	public game_Manu() {
		super(800, 800, 1, 1);
		gameBoard= new Board(new int[5][] ); // will change with csv
		repaint();

	}

	public void paint(Graphics g) {
		// super.paint(g);
		Image offIm = gameBoard.get_Board_image();
		g.drawImage(offIm, 0, 0, null);
	}

	public static void main(String[] arg) {
		game_Manu game = new game_Manu();
	}

	@Override
	public int get_TPS() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void action() {
		repaint();
	}
}
