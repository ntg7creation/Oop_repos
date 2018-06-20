package assiment4.entitys.Pacmans;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import assiment4.entitys.MyEntity;
import assiment4.logic.Moving_Direction;
import assiment4.logic.Visited;
import assiment4.logic.Visitor;

public abstract class Pacman extends MyEntity implements Visited {

	private int spriteIdx;
	Moving_Direction next_direc;
	protected final int id = 4;

	public Pacman() {
		spriteIdx = 0;
		direc = Moving_Direction.Right;
		next_direc = direc;
	}

	public void change_direction(Moving_Direction the_way) {
		next_direc = the_way;
	}

	@Override
	public void action() {
		move();
		move();
		move();
		move();

	}

	protected void move() {


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
		}
		if (offsetX == 0 & offsetY == 0) {
			direc = next_direc;
		}

		switch (offsetX) {
		case 13:
			offsetX = -12;
			X++;
			board.I_just_Moved(this);
			break;
		case -13:
			offsetX = 12;
			X--;
			board.I_just_Moved(this);
			break;
		}

		switch (offsetY) {
		case 13:
			offsetY = -12;
			Y++;
			board.I_just_Moved(this);
			break;
		case -13:
			offsetY = 12;
			Y--;
			board.I_just_Moved(this);
			break;
		}

	}

	@Override
	public int get_id() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	protected Image getCurrentSprite() {
		if (sprites == null) {
			return null;
		} else {
			int spriteDirIdx = 0;
			if (direc != null) {
				spriteDirIdx = direc.getSpriteindex();
			}

			Image cur = sprites[(spriteDirIdx * 2) + spriteIdx];
			spriteIdx = (spriteIdx + 1) % 2;
			return cur;
		}
	}
	
	

	public abstract void accept(Visitor entity);
}
