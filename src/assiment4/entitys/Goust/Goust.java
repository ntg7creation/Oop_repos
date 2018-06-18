package assiment4.entitys.Goust;

import java.util.Stack;

import assiment4.entitys.MyEntity;
import assiment4.logic.Board;
import assiment4.logic.Moving_Direction;
import assiment4.logic.Visitor;

public abstract class Goust extends MyEntity implements Visitor {

	protected Moving_Direction direc = null;

	protected Stack<Moving_Direction> path;

	static public Stack<Moving_Direction> DSF_to(int X, int Y, Board board) {
		return null;
	}

	protected void move() {
		if (offsetX == 0 & offsetY == 0) {
			if (!path.isEmpty())
				direc = path.pop();
			else
			{
				//get more path
			}
		}
		if (direc == null) {
		}

		switch (direc) {
		case Right:
			offsetX++;
			break;
		case Left:
			offsetX--;
			break;
		case Up:
			offsetY--;
			break;
		case Down:
			offsetY++;
			break;
		}

		switch (offsetX) {
		case 13:
			offsetX = -12;
			X++;
			break;
		case -13:
			offsetX = 12;
			X--;
			break;
		}

		switch (offsetY) {
		case 13:
			offsetY = -12;
			Y++;
			break;
		case -13:
			offsetY = 12;
			Y--;
			break;
		}
	}

}
