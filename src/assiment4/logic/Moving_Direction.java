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

	public Boolean can_Move(int[][] b, int x, int y) {
		if (x < 1 || y < 1 || y > b.length - 1 || x > b[y].length - 1)
			return false;
		switch (this) {
		case Right:
			return (b[y][x + 1] & 1) != 1;
		case Left:

			break;
		case Up:

			break;
		case Down:

			break;
		}

		return true;
	}
}
