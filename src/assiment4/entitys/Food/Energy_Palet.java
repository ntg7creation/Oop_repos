package assiment4.entitys.Food;

import assiment4.Storage.ImageLoader;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Energy_Palet extends Food {

	public Energy_Palet() {
		sprites = ImageLoader.getInstance().getEnergyPalet();
		if (sprites == null) {
			System.out.println("Error while loading energy-palet sprite");
		}
		id = 2048;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

}
