package Entities.Attacks;

import Entities.MyEntity;
import Entities.Pacmans.Pacman_Blue;
import Entities.Pacmans.Pacman_Red;
import Entities.Pacmans.Pacman_Yellow;
import Logic.Moving_Direction;
import Logic.Visitor;

public abstract class Attack extends MyEntity implements Visitor {

	@Override
	public void Visit(Pacman_Blue p) {
		board.Death();
	}

	@Override
	public void Visit(Pacman_Yellow p) {
		board.Death();
	}

	@Override
	public void Visit(Pacman_Red p) {
		board.Death();
	}

	public void setDirction(Moving_Direction d) {
		direc = d;
	}

	public void move() {

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

}
