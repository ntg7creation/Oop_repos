package assiment4.entitys;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import assiment4.logic.Board_action_Listener;
import assiment4.logic.Moving_Direction;
import assiment4.logic.Timer_Listener;

public abstract class MyEntity implements Timer_Listener {

	
	protected Moving_Direction direc = null;
	final protected int TPS = 25;
	protected int count_Ticks;
	protected int X;
	protected int Y;
	protected int preX;
	protected int preY;
	protected int offsetX;
	protected int offsetY;
	protected Image[] sprites;
	private int spriteIdx;
	protected Board_action_Listener board;

	public MyEntity() {
		spriteIdx = 0;
	}

	public abstract int get_id();
	
	public void add_Board_Listener(Board_action_Listener board) {
		this.board = board;
	}

	protected Boolean can_Move(int x, int y, Moving_Direction dirc) {
		switch (dirc) {
		case Right:
			return !board.is_wall(x + 1, y);

		case Left:
			return !board.is_wall(x - 1, y);

		case Up:

			return !board.is_wall(x, y - 1);
		case Down:

			return !board.is_wall(x, y + 1);
		}
		return false;
	}

	public void draw(Graphics g) {
		g.drawImage(sprites[spriteIdx], X * pixelOfCell + offsetX, Y * pixelOfCell + offsetY, null);
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

	private Image getCurrentSprite() {
		if (sprites == null) {
			return null;
		} else {
			Image cur = sprites[spriteIdx];
			spriteIdx = (spriteIdx + 1) % sprites.length;
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
		X = x;
		Y = y;
		preX = X;
		preY = Y;
	}

//	protected void setOffsetX(int offsetX) {
//		this.offsetX = offsetX;
//	}

//	protected void setOffsetY(int offsetY) {
//		this.offsetY = offsetY;
//	}

}