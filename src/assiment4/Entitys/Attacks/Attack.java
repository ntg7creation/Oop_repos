package assiment4.Entitys.Attacks;

import assiment4.Entitys.MyEntity;
import assiment4.Logic.Moving_Direction;
import assiment4.Logic.Visitor;

public abstract class Attack extends MyEntity implements Visitor {

	protected Moving_Direction direc = null;

	protected void move() {

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
