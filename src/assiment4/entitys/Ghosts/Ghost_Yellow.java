package assiment4.entitys.Ghosts;

import assiment4.Storage.ImageLoader;
import assiment4.entitys.Pacmans.Pacman;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Ghost_Yellow extends Ghost {

	private final int id = 16;
	private int ticks = 0;

	public Ghost_Yellow() {
		sprites = ImageLoader.getInstance().getYellowGhost();
		if (sprites == null) {
			System.out.println("Error while loading ghost_yellow sprite");
		}
	}

	@Override
	public void action() {

		move();
		if (ticks++ % 2 == 0)
		{
			move();
		}
	}

	@Override
	public void Visit(Pacman_Blue p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Visit(Pacman_Yellow p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Visit(Pacman_Red p) {
		// TODO Auto-generated method stub

	}

	@Override
	public int get_id() {
		// TODO Auto-generated method stub
		return 16;
	}

	
}
