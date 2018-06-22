package Entities;

import java.awt.Graphics;
import java.awt.Image;

import Logic.Board_action_Listener;
import Logic.Moving_Direction;
import Logic.Timer_Listener;

public abstract class MyEntity implements Timer_Listener {

	private final int pixelOfCell = 25;
	protected Moving_Direction direc = null;
	final protected int TPS = 25;
	protected int dealyTime = 0;
	protected int startdealyTime = 0;
	protected int count_Ticks = 0;
	protected int X;
	protected int Y;
	protected int preX;
	protected int preY;
	protected int startX;
	protected int startY;
	protected int offsetX;
	protected int offsetY;
	protected Image[] sprites;
	protected Board_action_Listener board;

	public MyEntity() {

	}

	public abstract int get_id();

	public void add_Board_Listener(Board_action_Listener board) {
		this.board = board;
	}

	protected Boolean can_Move(int x, int y, Moving_Direction dirc) {
		switch (dirc) {
		case Right:
			return !board.is_of_type(x + 1, y, 1);

		case Left:
			return !board.is_of_type(x - 1, y, 1);

		case Up:

			return !board.is_of_type(x, y - 1, 1);
		case Down:

			return !board.is_of_type(x, y + 1, 1);
		}
		return false;
	}

	public void draw(Graphics g) {
		g.drawImage(getCurrentSprite(), X * pixelOfCell + offsetX, Y * pixelOfCell + offsetY, null);
	}

	public int get_X() {
		return X;
	}

	public int get_Y() {
		return Y;
	}

	public int get_preX() {
		return preX;
	}

	public int get_preY() {
		return preY;
	}

	protected Image getCurrentSprite() {
		if (sprites == null) {
			return null;
		} else {
			int spriteDirIdx = 0;
			if (direc != null) {
				spriteDirIdx = direc.getSpriteindex();
			}

			Image cur = sprites[spriteDirIdx % sprites.length];
			// spriteIdx = (spriteIdx + 1) % sprites.length;
			return cur;
		}
	}

	protected int getOffsetX() {
		return offsetX;
	}

	protected int getOffsetY() {
		return offsetY;
	}

	public void set_start(int x, int y) {
		dealyTime += startdealyTime -1 * 25;
		X = x;
		Y = y;
		preX = X;
		preY = Y;
		startX = X;
		startY = Y;
	}

	public void reSet() {
		dealyTime =startdealyTime -1 * 25;
		preX = X;
		preY = Y;
		X = startX;
		Y = startY;
		offsetX = 0;
		offsetY = 0;
	}

}