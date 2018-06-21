package assiment4.logic;

import assiment4.Storage.csv_Reader;
import assiment4.entitys.Pacmans.Pacman;

public class Logic implements Logic_Listener {

	private Board board1;
	private Board board2;
	private Board board3;
	private Board board4;
	private Board board5;
	private Board currentBoard;
	final private String path1 = "res\\Boards\\0.csv";
	final private String path2 = "res\\Boards\\1.csv";
	final private String path3 = "res\\Boards\\2.csv";
	final private String path4 = "";
	final private String path5 = "";

	private int level = 1;
	private int score = 0;
	private int lifes = 3;

	private Pacman[] pacmans;

	public Logic() {
		int[][] b1 = csv_Reader.Load_Board(System.getProperty("user.dir") + "\\" + path1);
		int[][] b2 = csv_Reader.Load_Board(System.getProperty("user.dir") + "\\" + path2);
		int[][] b3 = csv_Reader.Load_Board(System.getProperty("user.dir") + "\\" + path3);
		int[][] b4 = csv_Reader.Load_Board(System.getProperty("user.dir") + "\\" + path4);
		int[][] b5 = csv_Reader.Load_Board(System.getProperty("user.dir") + "\\" + path5);
		if (b1 != null)
			board1 = new Board(b1, this);
		if (b2 != null)
			board2 = new Board(b2, this);
		if (b3 != null)
			board3 = new Board(b3, this);
		if (b4 != null)
			board4 = new Board(b4, this);
		if (b5 != null)
			board5 = new Board(b5, this);
		currentBoard = board1;
	}

	public Board get_Board(int board_number) {
		switch (board_number) {
		case 1:
			return board1;
		case 2:
			return board2;
		case 3:
			return board3;
		case 4:
			return board4;
		case 5:
			return board5;
		}
		return null;
	}

	public Board get_Current_Board() {
		return currentBoard;
	}

	@Override
	public void Death() {
		lifes--;

	}

	public int get_lifes() {
		return lifes;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score + currentBoard.get_score();
	}

	@Override
	public void mapEnd(int score) {
		this.score += score;
		level++;
		next_Level();
	}

	private void next_Level() {
		myTimer.getInstance().Clear();
		switch (level) {
		case 1:
			currentBoard = board1;
			break;
		case 2:
			currentBoard = board2;
			break;
		case 4:
			currentBoard = board1;
			break;
		case 3:
			Game_End();
			break;
		}
		currentBoard.start(myTimer.getInstance());
	}

	private void Game_End() {

	}
}
