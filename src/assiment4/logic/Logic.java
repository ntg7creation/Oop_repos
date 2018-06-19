package assiment4.logic;

import assiment4.entitys.Pac_mans.Pac_Man;

public class Logic {

	private Board board1;
	private Board board2;
	private Board board3;
	private Board board4;
	private Board board5;
	private Board currentBoard;

	private int level;
	private int score;
	private int lives;

	public Logic() {
		lives = 3;
		level = 1;
		int[][] temp = { { 1, 2 }, { 4, 8 } };
		board1 = new Board(temp);
		board2 = new Board(temp);
		board3 = new Board(temp);
		board4 = new Board(temp);
		board5 = new Board(temp);
		currentBoard = board1;
	}

	public void setCurrentBoard(int number) {
		switch (number) {
		case 1:
			currentBoard = board1;
			break;
		case 2:
			currentBoard = board2;
			break;
		case 3:
			currentBoard = board3;
			break;
		case 4:
			currentBoard = board4;
			break;
		case 5:
			currentBoard = board5;
			break;
		default:
			currentBoard = board1;
			break;
		}
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
