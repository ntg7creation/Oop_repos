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
	
	public Boolean can_Move()
	{
		return true;
	}
}
