package assiment4.logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import assiment4.entitys.Food.Food;
import assiment4.entitys.Food.Yello_Palet;
import assiment4.entitys.Goust.Goust_Green;
import assiment4.entitys.Goust.Goust_Red;
import assiment4.entitys.Goust.Goust_Yellow;
import assiment4.entitys.Pac_mans.Pac_Man;
import assiment4.entitys.Pac_mans.Pac_Man_Yellow;

public class Board {

	final private int block_size = 25;

	private Image final_Board;
	// this will be made 1 time and not change
	private Image board_walls;
	// this will change each time we eat a Yello_Palet
	private Image board_yello_Palets;
	private int yello_Palets_Count;

	private Pac_Man pacMan;
	private Goust_Green Inky;
	private Goust_Red Blinky;
	private Goust_Yellow Clyde;
	private Food[] food;

	private int[][] board;

	// its is better to keep the yello palets in here cus they are static and we
	// have a lot of them
	private Yello_Palet[][] yello_Palets;

	public Board(int[][] csv) {

		board = csv;

		yello_Palets = new Yello_Palet[32][];
		for (int y = 0; y < yello_Palets.length; y++) {
			yello_Palets[y] = new Yello_Palet[32];
		}

		board_walls = new BufferedImage(block_size * 32, block_size * 32, BufferedImage.TYPE_INT_ARGB);
		Graphics offGr;

		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				switch (board[y][x]) {
				case 0:

					break;
				case 1:
					offGr = board_walls.getGraphics();
					offGr.setColor(Color.blue);
					offGr.fillRect(x * block_size, y * block_size, block_size, block_size);
					break;
				case 2:
					yello_Palets[y][x] = new Yello_Palet();
					yello_Palets[y][x].set_start(x, y);
					break;
				case 4:
					pacMan = new Pac_Man_Yellow();
					pacMan.set_start(x, y);
					break;
				case 8:
					Inky = new Goust_Green();
					Inky.set_start(x, y);
					break;
				case 16:
					Clyde = new Goust_Yellow();
					Clyde.set_start(x, y);
					break;
				case 32:
					Blinky = new Goust_Red();
					Blinky.set_start(x, y);
					break;
				case 512:

					break;

				}
			}
		}
		
		board_yello_Palets = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		draw_yello_Plaets();
		
		final_Board = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		draw_my_self();
	}

	private void draw_my_self() {
		Graphics offGr = final_Board.getGraphics();
		offGr.fillRect(0, 0, 800, 800);

		offGr = final_Board.getGraphics();
		offGr.drawImage(board_walls, 0, 0, null);
		offGr.drawImage(board_yello_Palets, 0, 0, null);

	}

	public int items_at(int x, int y) {
		return 0;
	}

	// return 10 if there is a palet at x y else return 0
	public int eat_Palert_at(int x, int y) {
		if (yello_Palets[y][x] != null) {
			yello_Palets[y][x] = null;
			draw_yello_Plaets();
			return 10;
		}

		return 0;
	}

	private void draw_yello_Plaets() {
		Graphics offGr = board_yello_Palets.getGraphics();
		// offGr.fillRect(0, 0, 800, 800);
		offGr.setColor(Color.yellow);
		for(int y =0;y<yello_Palets.length;y++)
			for(int x = 0; x<yello_Palets[y].length;x++)
				if(yello_Palets[y][x]!=null)
					offGr.fillOval(x * block_size+ 6, y * block_size + 6, 12, 12);
	}

	public Boolean is_wall_at() {
		return false;
	}

	public Image get_Board_image() {
		return final_Board;
	}

}
