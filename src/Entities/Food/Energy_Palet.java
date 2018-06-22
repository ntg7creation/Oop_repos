package Entities.Food;

import Storage.ImageLoader;

public class Energy_Palet extends Food {

	public Energy_Palet() {
		sprites = ImageLoader.getInstance().getEnergyPalet();
		if (sprites == null) {
			System.out.println("Error while loading energy-palet sprite");
		}
		id = 2048;
		points = 50;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

}
