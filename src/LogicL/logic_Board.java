package LogicL;

import java.util.Random;
import java.util.Stack;

public class logic_Board {
	private int[][] board;
	private int boardSize;
	private Stack<Move> history;

	public logic_Board(int boardSize, int[][] map) {
		this.boardSize = boardSize;
		this.board = map;
		Coordinate.setBoardSize(boardSize);
		this.history = new Stack<>();
	}

	public int[][] getBoard() {
		return board;
	}

	// Move a piece located at (x,y) in a given direction
	private boolean movePiece(Move move) {
		// Invalid input
		if (!move.isValid()) {
			return false;
		}

		// New location is occupied
		Coordinate destCoord = move.getDestination();
		if (this.board[destCoord.getY()][destCoord.getX()] != 0) {
			return false;
		}

		// Move piece
		this.board[destCoord.getY()][destCoord.getX()] = this.board[move.getCoord().getY()][move.getCoord().getX()];
		this.board[move.getCoord().getY()][move.getCoord().getX()] = 0;
		this.history.push(move);
		return true;
	}

	public boolean movePiece(int numberOfPiece) {
		Coordinate coord = findCoordByIndex(numberOfPiece);
		Coordinate emptyCoord = findCoordByIndex(0);
		Direction dir = coord.getDirectionTo(emptyCoord);

		if (dir == null) { // Cant move to empty space
			return false;
		}

		Move move = new Move(coord, dir);
		return movePiece(move);
	}

	// Move to empty space
	public boolean movePiece(Direction dir) {
		// Locate empty space
		if (dir == null)
			return false;
		Coordinate emptyCoord = findCoordByIndex(0);
		Coordinate coord = emptyCoord.getDestination(dir.getOpposite());

		if (coord == null) {
			return false;
		}

		return movePiece(new Move(coord, dir));
	}

	private Coordinate findCoordByIndex(int index) {
		int x = -1, y = -1;
		boolean found = false;
		for (int i = 0; i < this.boardSize & !found; i++) {
			for (int j = 0; j < this.boardSize & !found; j++) {
				if (this.board[i][j] == index) {
					y = i;
					x = j;
					found = true;
				}
			}
		}

		return new Coordinate(x, y);
	}

	public boolean undo() {
		if (this.history.isEmpty()) {
			return false;
		}

		Move undoMove = this.history.pop();
		boolean undone = movePiece(undoMove.getOppositeMove());
		if (undone) {
			this.history.pop();
		}

		return undone;
	}

	// Check if board is solved
	public boolean isSolved() {
		// Empty spot not in place
		if (this.board[boardSize - 1][boardSize - 1] != 0) {
			return false;
		}

		for (int i = 1; i < this.boardSize * this.boardSize; i++) {
			int x = (i - 1) % this.boardSize;
			int y = (i - 1) / this.boardSize;
			if (this.board[y][x] != i) {
				return false;
			}
		}

		return true;
	}

	public void Random_Board() {
		Random r = new Random();
		print(board);
		for (int i = 0; i < 50000; i++) {
			int move = r.nextInt(4);
			switch (move) {
			case 0:
				movePiece(Direction.Up);
				break;
			case 1:
				movePiece(Direction.Down);
				break;
			case 2:
				movePiece(Direction.Left);
				break;
			case 3:
				movePiece(Direction.Right);
				break;
			}
		}
		this.history = new Stack<>();
		print(board);
	}
	
	public static void print(int[][] board)
	{
		System.out.println();
		System.out.println();
		for (int[] is : board) {
			for (int i : is) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}

}
