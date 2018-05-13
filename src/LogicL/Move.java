package LogicL;

public class Move {
    private int x;
    private int y;
    private Direction direction;
    private static int boardSize;

    public static void setBoardSize(int boardSize) {
        Move.boardSize = boardSize;
    }

    public Move(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int destX() {
        return this.x + this.direction.getDx();
    }

    public int getY() {
        return y;
    }

    public int destY() {
        return this.y + this.direction.getDy();
    }

    public boolean isValid() {
        // Location out of range
        if (!inRange(this.x) | !inRange(this.y)) {
            return false;
        }

        // Invalid destination
        if (!inRange(destX()) | !inRange(destY())) {
            return false;
        }

        return true;
    }

    public Move oppositeMove() {
        if (!isValid()) {
            return null;
        }

        return new Move(destX(), destY(), this.direction.getOpposite());
    }

    // Check if given index is in range of the board
    private boolean inRange(int i) {
        return  i >= 0 & i < Move.boardSize;
    }
}
