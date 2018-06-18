package assiment4.logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import assiment4.entitys.Food.Yello_Palet;

public class Board {

	private Image final_Board;
	// this will be made 1 time and not change
	private Image board_walls;
	// this will change each time we eat a Yello_Palet
	private Image board_yello_Palets;

	private int yello_Palets_Count;

	private int[][] board;
	// its is better to keep the yello palets in here cus they are static and we
	// have a lot of them
	private Yello_Palet[][] yello_Palets;

	public Board(int[][] csv) {
		final_Board = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		board_walls = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		board_yello_Palets = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		draw_my_self();
	}

	private void draw_my_self() {
		Graphics offGr = final_Board.getGraphics();
		offGr.fillRect(0, 0, 800, 800);

		offGr = board_walls.getGraphics();
		//offGr.fillRect(0, 0, 800, 800);
		offGr.setColor(Color.blue);
		offGr.fillRect(200, 80, 200 + 200, 80 + 200);

		offGr = board_yello_Palets.getGraphics();
		//offGr.fillRect(0, 0, 800, 800);
		offGr.setColor(Color.green);
		offGr.fillRect(80, 200, 80 + 200, 200 + 200);
		
		offGr = final_Board.getGraphics();
		offGr.drawImage(board_walls, 0, 0, null);
		offGr.drawImage(board_yello_Palets, 0, 0, null);

	}

	public int items_at(int x, int y) {
		return 0;
	}

	// return 10 if there is a palet at x y else return 0
	public int eat_Palert_at(int x, int y) {
		return 0;
	}

	public Boolean is_wall_at() {
		return false;
	}

	public Image get_Board_image() {
		return final_Board;
	}

}
