package assiment4.logic;

// This class define what is a direction and dx and dy
public enum Moving_Direction {
	Right(0), Left(2), Up(3), Down(1);

	private Moving_Direction opposite;
	private int spriteidx;
	static {
		Right.opposite = Left;
		Left.opposite = Right;
		Up.opposite = Down;
		Down.opposite = Up;
	}

	Moving_Direction(int index) {
		spriteidx = index;
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

	public int getSpriteindex() {
		return spriteidx;
	}
}
