package assiment4.entitys.Food;

import assiment4.Storage.ImageLoader;
import assiment4.entitys.Pacmans.Pacman;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Yello_Palet extends Food {

	public Yello_Palet() {
		sprites = ImageLoader.getInstance().getYellowPalet();
		if (sprites == null) {
			System.out.println("Error while loading yellow-palet sprite");
		}
		points = 10;
	}

	
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
	}

	@Override
	public String toString()
	{
		return "Yello";
	}

}
