package Entities.Food;

import Storage.ImageLoader;

public class Apple extends Food {

	public Apple() {
		sprites = ImageLoader.getInstance().getApple();
		if (sprites == null) {
			System.out.println("Error while loading apple sprite");
		}
		points = 200;
	}

}
