package assiment4.entitys.Pacmans;

import assiment4.Storage.ImageLoader;
import assiment4.logic.Visitor;

public class Pacman_Yellow extends Pacman {



	public Pacman_Yellow() {
		sprites = ImageLoader.getInstance().getYellowPacman();
		if (sprites == null) {
			System.out.println("Error while loading yellow_pacman sprite");
		}
	}
	


	@Override
	public void accept(Visitor V) {
		// TODO Auto-generated method stub
		
	}




}
