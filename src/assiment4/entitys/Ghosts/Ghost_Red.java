package assiment4.entitys.Ghosts;

import assiment4.Storage.ImageLoader;
import assiment4.entitys.Attacks.Fire_Ball;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Ghost_Red extends Ghost {


	private final int id = 32;


	public Ghost_Red() {
		sprites = ImageLoader.getInstance().getRedGhost();
		if (sprites == null) {
			System.out.println("Error while loading ghost_red sprite");
		}
	}

	@Override
	public void action() {
		if (dealyTime >= 0) {
			move();
			move();
			move();
		} else {
			dealyTime++;
		}
		
	}

	@Override
	public void Visit(Pacman_Blue p) {
		board.Death();
	}

	@Override
	public void Visit(Pacman_Yellow p) {
		board.Death();
	}

	@Override
	public void Visit(Pacman_Red p) {
		board.Death();
	}

	@Override
	public int get_id() {
		// TODO Auto-generated method stub
		return id;
	}

}
