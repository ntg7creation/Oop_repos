package assiment4.Entitys.Food;

import assiment4.Entitys.Pacmans.Pacman_Blue;
import assiment4.Entitys.Pacmans.Pacman_Red;
import assiment4.Entitys.Pacmans.Pacman_Yellow;

public class Yello_Palet extends Food {

	private final String[] imagesPath = {foodPath + "NormalPill.png"};

	public Yello_Palet() {
		if (!loadSprite(imagesPath)) {
			System.out.println("Error while loading normal pills sprite");
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
