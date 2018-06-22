package assiment4.entitys.Food;

import assiment4.Storage.ImageLoader;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Pineapple extends Food {

	public Pineapple() {
		sprites = ImageLoader.getInstance().getPineapple();
		if (sprites == null) {
			System.out.println("Error while loading pineapple sprite");
		}
		points = 100;
	}




}
