package assiment4.entitys.Food;

import assiment4.Storage.ImageLoader;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Strawberry extends Food{


	public Strawberry() {
		sprites = ImageLoader.getInstance().getStrawberry();
		if (sprites == null) {
			System.out.println("Error while loading strawberry sprite");
		}
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Visit(Pacman_Blue p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Visit(Pacman_Yellow p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Visit(Pacman_Red p) {
		// TODO Auto-generated method stub
		
	}

}
