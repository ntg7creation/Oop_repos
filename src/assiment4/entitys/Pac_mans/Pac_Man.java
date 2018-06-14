package assiment4.entitys.Pac_mans;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import assiment4.entitys.MyEntity;
import assiment4.logic.Moving_Direction;
import assiment4.logic.Visited;

public abstract class Pac_Man extends MyEntity implements Visited, KeyListener {

	Moving_Direction direc = Moving_Direction.Left;
	
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

	
}
