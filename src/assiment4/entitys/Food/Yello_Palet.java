package assiment4.entitys.Food;

import assiment4.entitys.Pac_mans.Pac_Man_Blue;
import assiment4.entitys.Pac_mans.Pac_Man_Red;
import assiment4.entitys.Pac_mans.Pac_Man_Yellow;

public class Yello_Palet extends Food {

	private final String path = "res/Pickups/";
	private final String[] imagesPath = {path + "NormalPill.png"};

	public Yello_Palet() {
		if (!loadSprite(imagesPath)) {
			throw new IllegalArgumentException("Error while loading normal pills sprite");
		}
	}

	
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Visit(Pac_Man_Blue p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Visit(Pac_Man_Yellow p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Visit(Pac_Man_Red p) {
		// TODO Auto-generated method stub
		
	}

}
