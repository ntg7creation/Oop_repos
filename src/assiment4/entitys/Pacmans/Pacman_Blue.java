package assiment4.entitys.Pacmans;

import assiment4.Storage.ImageLoader;
import assiment4.logic.Visitor;

public class Pacman_Blue extends Pacman {

	public Pacman_Blue() {
		sprites = ImageLoader.getInstance().getBluePacman();
		if (sprites == null) {
			System.out.println("Error while loading blue_pacman sprite");
		}
	}

	@Override
	public void accept(Visitor V) {
		V.Visit(this);
	}



}
