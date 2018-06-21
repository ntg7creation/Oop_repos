package assiment4.entitys.Attacks;

import assiment4.entitys.MyEntity;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;
import assiment4.logic.Visitor;

public abstract class Attack extends MyEntity implements Visitor {

	@Override
	public void Visit(Pacman_Blue p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Visit(Pacman_Yellow p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Visit(Pacman_Red p) {
		// TODO Auto-generated method stub

	}


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
