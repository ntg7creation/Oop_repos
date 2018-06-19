package assiment4.entitys.Ghosts;

import assiment4.Storage.ImageLoader;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Ghost_Yellow extends Ghost {


	public Ghost_Yellow() {
		sprites = ImageLoader.getInstance().getYellowGhost();
		if (sprites == null) {
			System.out.println("Error while loading ghost_yellow sprite");
		}
	}

	private int timecount;

	
	@Override
	public void action() {
		timecount++;
		//time to move the number 20 need to change
		//currently the Ghosts will move 1 picxle every 20 clock ticks
		if (timecount == 20)
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
