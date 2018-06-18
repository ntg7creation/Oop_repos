package assiment4.entitys.Pac_mans;

import java.awt.event.KeyEvent;

import assiment4.logic.Visitor;

public class Pac_Man_Yellow extends Pac_Man {

	private final String path = "res/Pacman/Yellow/";
	private final String[] imagesPath = {path + "1.png", path + "2.png"};

	public Pac_Man_Yellow() {
		if (!loadSprite(imagesPath)) {
			throw new IllegalArgumentException("Error while loading pacman-yellow sprite");
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
