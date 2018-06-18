package assiment4.Entitys.Attacks;

import assiment4.Entitys.Pacmans.Pacman_Blue;
import assiment4.Entitys.Pacmans.Pacman_Red;
import assiment4.Entitys.Pacmans.Pacman_Yellow;

public class Water_Splash extends Attack {

	private final String[] imagesPath = {attacksPath + "WaterSplash.png"};

	public Water_Splash() {
		if (!loadSprite(imagesPath)) {
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

}
