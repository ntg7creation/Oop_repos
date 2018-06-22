package Entities.Ghosts;

import Storage.ImageLoader;
import Entities.Attacks.Water_Splash;
import Entities.Pacmans.Pacman_Blue;
import Entities.Pacmans.Pacman_Red;
import Entities.Pacmans.Pacman_Yellow;

public class Ghost_Yellow extends Ghost {

	private Water_Splash water;
	private final int id = 16;
	private int ticks = 0;

	public Ghost_Yellow() {
		sprites = ImageLoader.getInstance().getYellowGhost();
		if (sprites == null) {
			System.out.println("Error while loading ghost_yellow sprite");
		}
		startdealyTime -= 50;
		water = null;
	}

	@Override
	public void action() {

		if (dealyTime >= 0) {
			move();
			if (ticks++ % 2 == 0) {
				move();
			}
			if (water != null) {
				if (!board.is_of_type(water.get_X(), water.get_Y(), 1)) {
					water.move();
					water.move();
					water.move();
					water.move();
				}
			}
			if (++count_Ticks % (5 * 25) == 0) {
				water = new Water_Splash();
				water.set_start(X, Y);
				water.setDirction(direc);
				water.add_Board_Listener(board);

			}
		} else
			dealyTime++;
	}

	@Override
	public void Visit(Pacman_Blue p) {
		p.set_delay(3);
	}

	@Override
	public void Visit(Pacman_Yellow p) {
		board.Death();
	}

	@Override
	public void Visit(Pacman_Red p) {
		dealyTime = -5 * 25;
	}

	@Override
	public int get_id() {
		// TODO Auto-generated method stub
		return id;
	}

	public Water_Splash get_water() {
		// TODO Auto-generated method stub
		return water;
	}

}