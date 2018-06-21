package assiment4.entitys.Attacks;

import assiment4.entitys.Pacmans.Pacman;
import assiment4.Storage.ImageLoader;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Fire_Ball extends Attack {

	protected final int id = 64;


	public Fire_Ball() {
		sprites = ImageLoader.getInstance().getFireBall();
		if (sprites == null) {
			System.out.println("Error while loading fireball sprite");
		}

	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	

	@Override
	public int get_id() {
		// TODO Auto-generated method stub
		return id;
	}



}
