package assiment4.logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import assiment4.entitys.MyEntity;
import assiment4.entitys.Food.Energy_Palet;
import assiment4.entitys.Food.Food;
import assiment4.entitys.Food.Yello_Palet;
import assiment4.entitys.Ghosts.Ghost_Green;
import assiment4.entitys.Ghosts.Ghost_Red;
import assiment4.entitys.Ghosts.Ghost_Yellow;
import assiment4.entitys.Pacmans.Pacman;
import assiment4.entitys.Pacmans.Pacman_Yellow;

//this shold not implements timer Listener but its easyer to do it like this
public class Board implements Timer_Listener, Board_action_Listener {

	final private int block_size = 25;

	private BufferedImage final_Board;
	// this will be made 1 time and not change
	private Image board_walls;
	// this will change each time we eat a Yello_Palet
	private Image board_yello_Palets;
	// this will change each time pacman moves
	private Image board_entity;

	private int yello_Palets_Count = 0;

	private Pacman pacMan;
	private Ghost_Green Inky;
	private Ghost_Red Blinky;
	private Ghost_Yellow Clyde;
	private int score = 0;
	private Logic_Listener logic;
	private int[][] board;
	private int tick_count = 0;
	// its is better to keep the yello palets in here cus they are static and we
	// have a lot of them
	private Food[][] Food;

	public Board(int[][] board, Logic_Listener logic) {
		this.logic = logic;
		this.board = board;
		Food = new Food[32][];
		for (int y = 0; y < Food.length; y++) {
			Food[y] = new Food[32];
		}

		board_walls = new BufferedImage(block_size * 32, block_size * 32, BufferedImage.TYPE_INT_ARGB);
		Graphics offGr;

		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < this.board[y].length; x++) {
				switch (this.board[y][x]) {
				case 0:

					break;
				case 1:
					offGr = board_walls.getGraphics();
					offGr.setColor(Color.blue);
					offGr.fillRect(x * block_size, y * block_size, block_size, block_size);
					break;
				case 2:
					Food[y][x] = new Yello_Palet();
					Food[y][x].add_Board_Listener(this);
					Food[y][x].set_start(x, y);
					yello_Palets_Count++;
					break;
				case 4:
					pacMan = new Pacman_Yellow();
					pacMan.add_Board_Listener(this);
					pacMan.set_start(x, y);
					break;
				case 8:
					Inky = new Ghost_Green();
					Inky.add_Board_Listener(this);
					Inky.set_start(x, y);
					break;
				case 16:
					Clyde = new Ghost_Yellow();
					Clyde.add_Board_Listener(this);
					Clyde.set_start(x, y);
					break;
				case 32:
					Blinky = new Ghost_Red();
					Blinky.add_Board_Listener(this);
					Blinky.set_start(x, y);
					break;
				case 512:
					offGr = board_walls.getGraphics();
					offGr.setColor(Color.gray);
					offGr.fillRect(x * block_size, y * block_size, block_size, block_size);
					break;
				case 2048:
					Food[y][x] = new Energy_Palet();
					Food[y][x].add_Board_Listener(this);
					Food[y][x].set_start(x, y);
					break;
				}
			}
		}
		System.out.println(yello_Palets_Count);
		draw_yello_Plaets();
		draw_entitys();
		final_Board = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		draw_my_self();
	}

	// -------------- private functions
	private void draw_my_self() {

		Graphics offGr = final_Board.getGraphics();
		offGr.setColor(Color.black);
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
			pacMan.draw(offGr);
			// offGr.setColor(Color.yellow);
			// offGr.fillRect(pacMan.get_X() * block_size, pacMan.get_Y() * block_size,
			// block_size, block_size);
		}
		if (Blinky != null) {
			Blinky.draw(offGr);
			// offGr.setColor(Color.RED);
			// offGr.fillRect(Blinky.get_X() * block_size, Blinky.get_Y() * block_size,
			// block_size, block_size);
		}
		if (Inky != null) {
			Inky.draw(offGr);
			// offGr.setColor(Color.green);
			// offGr.fillRect(Inky.get_X() * block_size, Inky.get_Y() * block_size,
			// block_size, block_size);
		}
		if (Clyde != null) {
			Clyde.draw(offGr);
			// offGr.setColor(Color.ORANGE);
			// offGr.fillRect(Clyde.get_X() * block_size, Clyde.get_Y() * block_size,
			// block_size, block_size);
		}

	}

	private void draw_yello_Plaets() {
		board_yello_Palets = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		Graphics offGr = board_yello_Palets.getGraphics();
		offGr.setColor(Color.yellow);
		if (true) {// tick_count%(9*25) <= 8 * 25) {
			for (int y = 0; y < Food.length; y++)
				for (int x = 0; x < Food[y].length; x++)
					if (Food[y][x] != null)
						Food[y][x].draw(offGr);
		}
	}

	private void entity_move(MyEntity entity) {
		board[entity.get_preY()][entity.get_preX()] -= entity.get_id();
		board[entity.get_Y()][entity.get_X()] += entity.get_id();
	}

	// ---------------------public functions
	public void start(myTimer timer) {
		timer.addTimerListener(pacMan);
		timer.addTimerListener(Blinky);
		timer.addTimerListener(Clyde);
		timer.addTimerListener(Inky);
		for (Food[] array : Food) {
			for (Food yello_Palet : array) {
				if (yello_Palet != null)
					timer.addTimerListener(yello_Palet);
			}
		}
		timer.addTimerListener(this); // this will not be here
		timer.start();

	}

	public BufferedImage get_Board_image() {
		return final_Board;
	}

	public void user_input(KeyEvent e) {
		int keyCode = e.getKeyCode();

		switch (keyCode) {
		case KeyEvent.VK_UP:
			pacMan.change_direction(Moving_Direction.Up);
			break;
		case KeyEvent.VK_DOWN:
			pacMan.change_direction(Moving_Direction.Down);
			break;
		case KeyEvent.VK_LEFT:
			pacMan.change_direction(Moving_Direction.Left);
			break;
		case KeyEvent.VK_RIGHT:
			pacMan.change_direction(Moving_Direction.Right);
			break;
		}
	}

	// -----------------------------Listener functions
	@Override
	public Boolean is_of_type(int x, int y, int type) {
		if (x < 0 || y < 0 || y >= board.length || x >= board[y].length)
			return true;
		return (board[y][x] & type) != 0;
	}

	@Override
	public void eat_food_at(Food food) {
		if (Food[food.get_Y()][food.get_preX()] != null) {
			Food[food.get_Y()][food.get_preX()] = null;
			score += food.get_points();
			board[food.get_Y()][food.get_preX()] -= food.get_id();
			if (food.get_id() == 2)
				yello_Palets_Count--;

		}
	}

	@Override
	public void action() {
		if (yello_Palets_Count > 0) {
			tick_count++;
			draw_yello_Plaets();
			draw_entitys();
			draw_my_self();
		} else {

			logic.mapEnd(score);
		}

	}

	@Override
	public void I_just_Moved(MyEntity entity) {
		entity_move(entity);

		if (entity instanceof Visitor && (board[entity.get_Y()][entity.get_X()] & pacMan.get_id()) == pacMan.get_id()) {
			pacMan.accept((Visitor) entity);
		}

		if (entity instanceof Pacman) {
			Pacman p = (Pacman) entity;
			int itemshere = board[entity.get_Y()][entity.get_X()];
			if ((itemshere & 2) == 2)
				if (Food[p.get_Y()][p.get_X()] != null) {
					pacMan.accept(Food[p.get_Y()][p.get_X()]);
				}
			if ((itemshere & 8) == 8)
				pacMan.accept(Inky);
			if ((itemshere & 16) == 16)
				pacMan.accept(Clyde);
			if ((itemshere & 32) == 32)
				pacMan.accept(Blinky);
			if ((itemshere & 256) == 256) {
				if (Food[p.get_Y()][p.get_X()] != null) {
					pacMan.accept(Food[p.get_Y()][p.get_X()]);
				}
			}
			if ((itemshere & 128) == 128 | (itemshere & 64) == 64) {

			}
			if ((itemshere & 2048) == 2048) {
				if (Food[p.get_Y()][p.get_X()] != null) {
					pacMan.accept(Food[p.get_Y()][p.get_X()]);
				}
			}
		}
	}

	@Override
	public void Death() {
		pacMan.reSet();
		Blinky.reSet();
		Clyde.reSet();
		Inky.reSet();
		logic.Death();
		entity_move(pacMan);
		entity_move(Blinky);
		entity_move(Clyde);
		entity_move(Inky);

	}
	// -----------------------------

}
