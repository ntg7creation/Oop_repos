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

	public int came_From(int x, int y) {
		switch (this.opposite) {
		case Right:
			return x + 1;
		case Left:
			return x - 1;
		case Down:
			return y + 1;
		case Up:
			return y - 1;
		}
		return 0;
	}

	public Moving_Direction getOpposite() {
		return opposite;
	}
}
