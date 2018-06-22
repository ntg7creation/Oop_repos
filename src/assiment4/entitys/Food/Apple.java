package assiment4.entitys.Food;

import assiment4.Storage.ImageLoader;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Apple extends Food {

	public Apple() {
		sprites = ImageLoader.getInstance().getApple();
		if (sprites == null) {
			System.out.println("Error while loading apple sprite");
		}
	}

}
