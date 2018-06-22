package assiment4.entitys.Food;

import assiment4.Storage.ImageLoader;

public class Strawberry extends Food {

	//test
	public Strawberry() {
		sprites = ImageLoader.getInstance().getStrawberry();
		if (sprites == null) {
			System.out.println("Error while loading strawberry sprite");
		}
		
		points = 300;
		
	}

}
