package assiment4.entitys.Ghosts;

import java.util.Random;
import java.util.Stack;

import assiment4.entitys.MyEntity;
import assiment4.logic.Board;
import assiment4.logic.Moving_Direction;
import assiment4.logic.Visitor;

public abstract class Ghost extends MyEntity implements Visitor {

	protected Stack<Moving_Direction> path;
	
	
	static public Stack<Moving_Direction> DSF_to(int X, int Y, Board board) {
		return null;
	}

	protected void move() {
		// direc = Moving_Direction.Right;
		// this works really well beacus it knows for 100% that it can move if we are
		// not at offset 0 0
		if (direc != null && (!(offsetX == 0 & offsetY == 0) || can_Move(X, Y, direc))) {

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
		} else {
			direc = get_random_move(direc);
		}

		switch (offsetX) {
		case 13:
			offsetX = -12;
			preX = X;
			preY = Y;
			X++;
			board.I_just_Moved(this);
			break;
		case -13:
			offsetX = 12;
			preX = X;
			preY = Y;
			X--;
			board.I_just_Moved(this);
			break;
		}

		switch (offsetY) {
		case 13:
			offsetY = -12;
			preX = X;
			preY = Y;
			Y++;
			board.I_just_Moved(this);
			break;
		case -13:
			offsetY = 12;
			preX = X;
			preY = Y;
			Y--;
			board.I_just_Moved(this);
			break;
		}

	}

	private Moving_Direction get_random_move(Moving_Direction direc) {
		Random r = new Random();
		Moving_Direction output = null;

		if (direc == Moving_Direction.Up || direc == Moving_Direction.Down) {
			switch (r.nextInt(2)) {
			case 0:
				output = Moving_Direction.Right;
				break;
			case 1:
				output = Moving_Direction.Left;
				break;
			}
		} else {
			switch (r.nextInt(2)) {
			case 0:
				output = Moving_Direction.Up;
				break;
			case 1:
				output = Moving_Direction.Down;
				break;
			}
		}

		return output;
	}
}
// test
