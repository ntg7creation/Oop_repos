package assiment4.entitys.Pacmans;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import assiment4.entitys.MyEntity;
import assiment4.logic.Moving_Direction;
import assiment4.logic.Visited;

public abstract class Pacman extends MyEntity implements Visited, KeyListener {

    private int spriteIdx;
	protected final int id = 4;

	public Pacman() {
	    spriteIdx = 0;
    }

	@Override
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();

		switch (keyCode) {
		case KeyEvent.VK_UP:
			direc = Moving_Direction.Up;
			break;
		case KeyEvent.VK_DOWN:
			direc = Moving_Direction.Down;
			break;
		case KeyEvent.VK_LEFT:
			direc = Moving_Direction.Left;
			break;
		case KeyEvent.VK_RIGHT:
			direc = Moving_Direction.Right;
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
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

            Image cur = sprites[spriteDirIdx + spriteIdx];
			spriteIdx = (spriteIdx + 1) % 2;
            return cur;
        }
	}
}
