package Entities.Food;

import Storage.ImageLoader;

public class Strawberry extends Food {


	public Strawberry() {
		sprites = ImageLoader.getInstance().getStrawberry();
		if (sprites == null) {
			System.out.println("Error while loading strawberry sprite");
		}
		
		points = 300;
		
	}

}
