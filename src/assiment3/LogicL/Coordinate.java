package assiment3.LogicL;

/*
* a coordinate of a piece location in board
* */

public class Coordinate {
    private int x;
    private int y;
    private static int boardSize;

    public static void setBoardSize(int boardSize) {
        Coordinate.boardSize = boardSize;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Check if given index is in range of the board
    private boolean inRange(int i) {
        return  i >= 0 & i < Coordinate.boardSize;
    }

    public boolean isValid() {
        return inRange(this.x) & inRange(this.y);
    }

    public Direction getDirectionTo(Coordinate coord) {
        int dx = coord.getX() - this.x;
        int dy = coord.getY() - this.y;

        return Direction.getDirection(dx, dy);
    }

    public Coordinate getDestination(Direction dir) {
        int destX = this.x + dir.getDx();
        int destY = this.y + dir.getDy();
        Coordinate destCoord =  new Coordinate(destX, destY);

        if (!destCoord.isValid()) {
            return null;
        }

        return destCoord;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }
}
