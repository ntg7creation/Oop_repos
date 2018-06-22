package Entities.Food;

import Storage.ImageLoader;

public class Yello_Palet extends Food {

//	private int tick_counter = 0;
//	Image[] temp;

	public Yello_Palet() {

		//temp = ImageLoader.getInstance().getYellowPalet();
		sprites = ImageLoader.getInstance().getYellowPalet();
		if (sprites == null) {
			System.out.println("Error while loading yellow-palet sprite");
		}
		points = 10;
		id = 2;
	}

	@Override
	public String toString() {
		return "Yello";
	}

	@Override
	public void action() {
//		tick_counter++;
//		if (tick_counter >= 3 * 25)
//			sprites = null;
//		else
//			sprites = temp;
//		
//		tick_counter %= 80;

	}
}
