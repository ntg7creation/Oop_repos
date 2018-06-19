package assiment4.logic;

// This class define what is a direction and dx and dy
public enum Moving_Direction {
	Right, Left, Up, Down;

	private Moving_Direction opposite;

	static {
		Right.opposite = Left;
		Left.opposite = Right;
		Up.opposite = Down;
		Down.opposite = Up;
	}

	public Moving_Direction getOpposite() {
		return opposite;
	}

	public Boolean can_Move(int Board[][], int x, int y) {
		if (y > Board.length - 1 || x > Board[y].length - 1 | x < 1 | y < 1)
			return false;
		switch (this) {
		case Right:
			return (Board[y][x + 1] & 1) != 1;
		case Left:
			return (Board[y][x - 1] & 1) != 1;
		case Down:
			return (Board[y + 1][x] & 1) != 1;
		case Up:
			return (Board[y - 1][x] & 1) != 1;

		}
		return false;
	}
}
