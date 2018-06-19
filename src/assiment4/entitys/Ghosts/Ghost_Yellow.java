package assiment4.entitys.Ghosts;

import assiment4.entitys.Pacmans.Pacman;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Ghost_Yellow extends Ghost {

	private final int id = 16;
	private final String[] imagesPath = {ghostPath + "GhostYellow.png"};

	public Ghost_Yellow() {
		if (!loadSprite(imagesPath)) {
			System.out.println("Error while loading ghost_yellow sprite");
		}
	}
	
	@Override
	public void action() {

			move();
			move();
			move();

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

	@Override
	public void Visit(Pacman p) {
		// TODO Auto-generated method stub
		
	}

}
