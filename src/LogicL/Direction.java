package LogicL;

// This class define what is a direction and dx and y
public enum Direction {
    Right(1,0),
    Left(-1,0),
    Up(0,-1),
    Down(0,1);

    private int dx;
    private int dy;
    private Direction opposite;

    static {
        Right.opposite = Left;
        Left.opposite = Right;
        Up.opposite = Down;
        Down.opposite = Up;
    }

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public Direction getOpposite() {
        return opposite;
    }
}
