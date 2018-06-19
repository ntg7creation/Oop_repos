package assiment4.entitys.Ghosts;

import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;
 
public class Ghost_Green extends Ghost {

	private final String[] imagesPath = {ghostPath + "GhostGreen.png"};

	public Ghost_Green() {
		if (!loadSprite(imagesPath)) {
			System.out.println("Error while loading ghost_green sprite");
		}
	}
	
	@Override
	public void action() {
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
