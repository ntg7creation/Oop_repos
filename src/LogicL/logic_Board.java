package LogicL;

import java.util.Vector;

public class logic_Board {
    private PuzzlePiece[][] board;
    private int boardSize;

    public logic_Board(int boardSize, int[][] map, Vector<PuzzlePiece> pieces) {
        this.boardSize = boardSize;
        this.board = new PuzzlePiece[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int index = map[i][j];
                if (index != 0) {
                    for (PuzzlePiece piece : pieces) {
                        if (piece.getIndex() == index) {
                            this.board[i][j] = piece;
                            break;
                        }
                    }
                }
            }
        }
    }

    public PuzzlePiece[][] getBoard() {
        return board;
    }

    // Move a piece located at (x,y) in a given direction
    public boolean movePiece(int x, int y, Direction dir) {
        // Invalid input
        if (!inRange(x) | !inRange(y)) {
            return false;
        }
        
        int newX = x + dir.getDx();
        int newY = y + dir.getDy();
        
        // Invalid direction
        if (!inRange(newX) | !inRange(newY)) {
            return false;
        }
        
        // New location is occupied
        if (this.board[newX][newY] != null) {
            return false;
        }
        
        // Move piece
        this.board[newX][newY] = this.board[x][y];
        this.board[x][y] = null;
        return true;
    }

    // Move to open space
    public boolean moveToOpen(Direction dir) {
        // Locate open space
        int openX = -1, openY = -1;
        boolean found = false;
        for (int i = 0; i < this.boardSize & !found; i++) {
            for (int j = 0; j < this.boardSize & !found; j++) {
                if (this.board[i][j] == null) {
                    openX = i;
                    openY = j;
                }
            }
        }

        int xToMove = openX + dir.getOpposite().getDx();
        int yToMove = openY + dir.getOpposite().getDy();
        return movePiece(xToMove, yToMove,dir);
    }
    
    // Check if board is solved
    public boolean isSolved() {
        // Empty spot not in place
        if (this.board[boardSize-1][boardSize-1] != null) {
            return false;
        }

        for (int i = 1; i < this.boardSize*this.boardSize; i++) {
            int x = (i - 1) % this.boardSize;
            int y = (i - 1) / this.boardSize;
            if (this.board[x][y].getIndex() != i) {
                return false;
            }
        }

        return true;
    }
    
    // Check if given index is in range of the board
    private boolean inRange(int i) {
        if (i < 0 | i >= boardSize) {
            return false;
        }
        
        return true;
    }
}
