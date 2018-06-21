package assiment4.entitys.Ghosts;

import assiment4.Storage.ImageLoader;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Ghost_Green extends Ghost {

	private final int id = 8;

	public Ghost_Green() {
		sprites = ImageLoader.getInstance().getGreenGhost();
		if (sprites == null) {
			System.out.println("Error while loading ghost_green sprite");
		}
	}

	@Override
	public void action() {
		if (dealyTime >= 0)
			move();
		else
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
