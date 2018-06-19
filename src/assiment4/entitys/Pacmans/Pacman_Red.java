package assiment4.entitys.Pacmans;

import assiment4.Storage.ImageLoader;
import assiment4.logic.Visitor;

public class Pacman_Red extends Pacman {

	public Pacman_Red() {
		sprites = ImageLoader.getInstance().getRedPacman();
		if (sprites == null) {
			System.out.println("Error while loading red_pacman sprite");
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
