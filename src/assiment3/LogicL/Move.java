package assiment3.LogicL;

/*
* determinate a move in board
* */
public class Move {
    private Coordinate coord;
    private Direction direction;

    public Move(int x, int y, Direction direction) {
        this.coord = new Coordinate(x, y);
        this.direction = direction;
    }

    public Move(Coordinate coord, Direction direction) {
        this.coord = coord;
        this.direction = direction;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public boolean isValid() {
        return coord.isValid() & coord.getDestination(this.direction).isValid();
    }

    public Move getOppositeMove() {
        if (!isValid()) {
            return null;
        }

        return new Move(coord.getDestination(this.direction), this.direction.getOpposite());
    }

    public Coordinate getDestination() {
        return coord.getDestination(this.direction);
    }
}
