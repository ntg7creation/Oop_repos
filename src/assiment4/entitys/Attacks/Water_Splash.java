package assiment4.entitys.Attacks;

import assiment4.Storage.ImageLoader;
import assiment4.entitys.Pacmans.Pacman;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Water_Splash extends Attack {

	protected final int id = 128;

	public Water_Splash() {
		sprites = ImageLoader.getInstance().getWaterSplash();
		if (sprites == null) {
			System.out.println("Error while loading water-splash sprite");
		}
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
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
		return id;
	}

	@Override
	public void Visit(Pacman p) {
		// TODO Auto-generated method stub
		
	}

}
