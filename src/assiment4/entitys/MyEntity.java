package assiment4.entitys;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import assiment4.logic.Moving_Direction;
import assiment4.logic.Timer_Listener;

public abstract class MyEntity implements Timer_Listener {

	final protected int TPS = 25;
	protected int X;
	protected int Y;
	protected int offsetX;
	protected int offsetY;
	protected Image[] sprites;
	private int spriteIdx;
	protected Moving_Direction direc = null;

	public MyEntity() {
		spriteIdx = 0;
	}

	public void set_start(int x, int y) {
		X = x;
		Y = y;
	}

	public void draw(Graphics g) {
		g.drawImage(getCurrentSprite(), X, Y, null);
	}

	public int get_X() {
		return X;
	}

	public int get_Y() {
		return Y;
	}

	public int getOffsetX() {
		return offsetX;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	public int getOffsetY() {
		return offsetY;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
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
}