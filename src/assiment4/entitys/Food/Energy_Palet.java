package assiment4.entitys.Food;

import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public class Energy_Palet extends Food {

	private final String[] imagesPath = {foodPath + "EnergyPills.png"};

	public Energy_Palet() {
		if (!loadSprite(imagesPath)) {
			System.out.println("Error while loading energy pills sprite");
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
