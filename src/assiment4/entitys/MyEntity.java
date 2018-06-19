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
	protected final String path = "res/Images/";
	private final int pixelOfCell = 25;
	final protected int TPS = 25;
	protected int count_Ticks;
	protected int X;
	protected int Y;
	protected int offsetX;
	protected int offsetY;
	private Image[] sprites;
	private int spriteIdx;
	protected Board_action_Listener board;

	public MyEntity() {
		spriteIdx = 0;
	}

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
		// getCurrentSprite().paintIcon(com, g, X, Y);
	}

	public int get_X() {
		return X;
	}

	public int get_Y() {
		return Y;
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

	protected boolean loadSprite(String[] imagesPath) {

		try {
			this.sprites = new Image[imagesPath.length];

			for (int i = 0; i < imagesPath.length; i++) {
				BufferedImage src = ImageIO.read(new File(imagesPath[i]));

				this.sprites[i] = resize(src, pixelOfCell, pixelOfCell);
			}

			return true;
		} catch (IOException e) {
			return false;
		}

	}

	private Image resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}

	public void set_start(int x, int y) {
		X = x;
		Y = y;
	}

	protected void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	protected void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

}