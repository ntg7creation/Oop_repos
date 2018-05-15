package LogicL;

import java.util.Stack;

public class logic_Board {
    private int[][] board;
    private int boardSize;
    private Stack<Move> history;

    public logic_Board(int boardSize, int[][] map) {
        this.boardSize = boardSize;
        this.board = map;
        Move.setBoardSize(boardSize);
        this.history = new Stack<>();
    }

    public int[][] getBoard() {
        return board;
    }

    // Move a piece located at (x,y) in a given direction
    public boolean movePiece(Move move) {
        // Invalid input
        if (!move.isValid()) {
            return false;
        }

        // New location is occupied
        if (this.board[move.destX()][move.destY()] != 0) {
            return false;
        }
        
        // Move piece
        this.board[move.destX()][move.destY()] = this.board[move.getX()][move.getY()];
        this.board[move.getX()][move.getY()] = 0;
        this.history.push(move);
        return true;
    }

    // Move to open space
    public boolean moveToOpen(Direction dir) {
        // Locate open space
        int openX = -1, openY = -1;
        boolean found = false;
        for (int i = 0; i < this.boardSize & !found; i++) {
            for (int j = 0; j < this.boardSize & !found; j++) {
                if (this.board[i][j] == 0) {
                    openX = i;
                    openY = j;
                }
            }
        }

        int xToMove = openX + dir.getOpposite().getDx();
        int yToMove = openY + dir.getOpposite().getDy();
        return movePiece(new Move(xToMove, yToMove,dir));
    }

    public boolean undo(){
        if (this.history.isEmpty()) {
            return false;
        }

        Move undoMove = this.history.pop();
        return movePiece(undoMove.oppositeMove());
    }
    
    // Check if board is solved
    public boolean isSolved() {
        // Empty spot not in place
        if (this.board[boardSize-1][boardSize-1] != 0) {
            return false;
        }

        for (int i = 1; i < this.boardSize*this.boardSize; i++) {
            int x = (i - 1) % this.boardSize;
            int y = (i - 1) / this.boardSize;
            if (this.board[x][y] != i) {
                return false;
            }
        }

        return true;
    }
}
