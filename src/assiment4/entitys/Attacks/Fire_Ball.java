package assiment4.entitys.Attacks;

import assiment4.Storage.ImageLoader;

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
		System.out.println("fire tick");
		move();
		move();
		move();
		move();
		move();
		

	}

	

	@Override
	public int get_id() {
		// TODO Auto-generated method stub
		return id;
	}



}
