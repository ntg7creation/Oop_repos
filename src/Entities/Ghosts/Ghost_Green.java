package Entities.Ghosts;

import Storage.ImageLoader;
import Entities.Pacmans.Pacman_Blue;
import Entities.Pacmans.Pacman_Red;
import Entities.Pacmans.Pacman_Yellow;

public class Ghost_Green extends Ghost {

	private final int id = 8;

	public Ghost_Green() {
		sprites = ImageLoader.getInstance().getGreenGhost();
		if (sprites == null) {
			System.out.println("Error while loading ghost_green sprite");
		}
		startdealyTime -=10;
		}
	

	@Override
	public void action() {
		if (dealyTime >= 0) {
			move();
			move();
			move();
		} else
			dealyTime++;

	}

	@Override
	public void Visit(Pacman_Blue p) {
		reSet();
		dealyTime = -25 * 5;
	}

	@Override
	public void Visit(Pacman_Yellow p) {
		board.Death();
	}

	@Override
	public void Visit(Pacman_Red p) {
		reSet();
		dealyTime = Integer.MIN_VALUE;
		this.sprites[0] = null;

	}

	@Override
	public int get_id() {
		return id;
	}

}
