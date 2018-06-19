package assiment4.entitys.Ghosts;

import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Ghost_Yellow extends Ghost {

	private final String[] imagesPath = {ghostPath + "GhostYellow.png"};

	public Ghost_Yellow(int[][] board) {
		super(board);
		if (!loadSprite(imagesPath)) {
			System.out.println("Error while loading ghost_yellow sprite");
		}
	}

	private int timecount;

	
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

}
