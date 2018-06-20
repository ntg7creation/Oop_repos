package assiment4.logic;

import assiment4.Storage.csv_Reader;
import assiment4.entitys.Pacmans.Pacman;

public class Logic {

	private Board board1;
	private Board board2;
	private Board board3;
	private Board board4;
	private Board board5;
	private Board currentBoard;
	final private String path1 = "res\\Boards\\0.csv";
	final private String path2 = "";
	final private String path3 = "";
	final private String path4 = "";
	final private String path5 = "";

	private int level;
	private int score;
	private int lifes;

	private Pacman[] pacmans;

	public Logic() {
		int[][] b1 = csv_Reader.Load_Board(System.getProperty("user.dir") +"\\"+ path1);
		board1 = new Board(b1);
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

}
