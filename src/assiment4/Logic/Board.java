package assiment4.Logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import assiment4.Entitys.Food.Food;
import assiment4.Entitys.Food.Yello_Palet;
import assiment4.Entitys.Ghosts.Ghost_Green;
import assiment4.Entitys.Ghosts.Ghost_Red;
import assiment4.Entitys.Ghosts.Ghost_Yellow;
import assiment4.Entitys.Pacmans.Pacman;
import assiment4.Entitys.Pacmans.Pacman_Yellow;

//this shold not implements timer Listener but its easyer to do it like this
public class Board implements Timer_Listener {

	final private int block_size = 25;

	private Image final_Board;
	// this will be made 1 time and not change
	private Image board_walls;
	// this will change each time we eat a Yello_Palet
	private Image board_yello_Palets;
	// this will change each time pacman moves
	private Image board_entity;

	private int yello_Palets_Count;

	private Pacman pacMan;
	private Ghost_Green Inky;
	private Ghost_Red Blinky;
	private Ghost_Yellow Clyde;
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
					pacMan = new Pacman_Yellow();
					pacMan.set_start(x, y);
					break;
				case 8:
					Inky = new Ghost_Green();
					Inky.set_start(x, y);
					break;
				case 16:
					Clyde = new Ghost_Yellow();
					Clyde.set_start(x, y);
					break;
				case 32:
					Blinky = new Ghost_Red();
					Blinky.set_start(x, y);
					break;
				case 512:

					break;

				}
			}
		}

		draw_yello_Plaets();
		draw_entitys();
		final_Board = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		draw_my_self();
	}

	private void draw_my_self() {

		Graphics offGr = final_Board.getGraphics();
		offGr.setColor(Color.WHITE);
		offGr.fillRect(0, 0, 800, 800);

		offGr = final_Board.getGraphics();
		offGr.drawImage(board_walls, 0, 0, null);
		offGr.drawImage(board_yello_Palets, 0, 0, null);
		offGr.drawImage(board_entity, 0, 0, null);

	}

	private void draw_entitys() {
		board_entity = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		Graphics offGr = board_entity.getGraphics();

		if (pacMan != null) {
			offGr.setColor(Color.yellow);
			// pacMan.draw(offGr);
			offGr.fillRect(pacMan.get_X() * block_size, pacMan.get_Y() * block_size, block_size, block_size);
		}
		if (Blinky != null) {
			offGr.setColor(Color.RED);
			offGr.fillRect(Blinky.get_X() * block_size, Blinky.get_Y() * block_size, block_size, block_size);
		}
		if (Inky != null) {
			offGr.setColor(Color.green);
			offGr.fillRect(Inky.get_X() * block_size, Inky.get_Y() * block_size, block_size, block_size);
		}
		if (Clyde != null) {
			offGr.setColor(Color.ORANGE);
			offGr.fillRect(Clyde.get_X() * block_size, Clyde.get_Y() * block_size, block_size, block_size);
		}

	}

	private void draw_yello_Plaets() {
		board_yello_Palets = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		Graphics offGr = board_yello_Palets.getGraphics();
		offGr.setColor(Color.yellow);
		for (int y = 0; y < yello_Palets.length; y++)
			for (int x = 0; x < yello_Palets[y].length; x++)
				if (yello_Palets[y][x] != null)
					offGr.fillOval(x * block_size + 6, y * block_size + 6, 12, 12);
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

	public void start(myTimer timer) {
		timer.addTimerListener(pacMan);
		timer.addTimerListener(Blinky);
		timer.addTimerListener(Clyde);
		timer.addTimerListener(Inky);
		for (Yello_Palet[] array : yello_Palets) {
			for (Yello_Palet yello_Palet : array) {
				timer.addTimerListener(yello_Palet);
			}
		}
		timer.start();

	}

	public Boolean is_wall_at(int x, int y) {
		return (board[y][x] & 1) == 1;
	}

	public Image get_Board_image() {
		return final_Board;
	}

	@Override
	public void action() {
		draw_yello_Plaets();
		draw_entitys();
		draw_my_self();

	}

}
