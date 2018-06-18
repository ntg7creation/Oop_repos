package assiment4.entitys.Pac_mans;

import assiment4.logic.Visitor;

public class Pac_Man_Red extends Pac_Man  {

	private final String path = "res/Pacman/Red/";
	private final String[] imagesPath = {path + "1.png", path + "2.png"};

	public Pac_Man_Red() {
		if (!loadSprite(imagesPath)) {
			throw new IllegalArgumentException("Error while loading pacman-red sprite");
		}
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor V) {
		// TODO Auto-generated method stub
		
	}

}
