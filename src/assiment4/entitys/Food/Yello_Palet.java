package assiment4.entitys.Food;

import assiment4.entitys.Pacmans.Pacman;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Yello_Palet extends Food {

	private final String[] imagesPath = {foodPath + "NormalPill.png"};

	public Yello_Palet() {
		if (!loadSprite(imagesPath)) {
			System.out.println("Error while loading normal pills sprite");
		}
	}

	
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}



}
