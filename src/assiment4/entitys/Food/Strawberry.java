package assiment4.entitys.Food;

import assiment4.entitys.Pacmans.Pacman;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Strawberry extends Food{

	private final String[] imagesPath = {foodPath + "Strawberry.png"};

	public Strawberry() {
		if (!loadSprite(imagesPath)) {
			System.out.println("Error while loading strawberry sprite");
		}
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}



}
