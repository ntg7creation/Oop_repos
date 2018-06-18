package assiment4.entitys;

import java.awt.Graphics;
import java.awt.Image;

import assiment4.logic.Timer_Listener;

public abstract class MyEntity implements Timer_Listener {

	final protected int TPS = 25;
	protected int X;
	protected int Y;
	protected int offsetX;
	protected int offsetY;
	private Image[] sprites;


	@Override
	public int get_TPS() {
		return TPS;
	}

	public void draw(Graphics g) {

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
}
