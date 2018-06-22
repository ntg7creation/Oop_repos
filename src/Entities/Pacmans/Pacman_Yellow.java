package Entities.Pacmans;

import Storage.ImageLoader;
import Logic.Visitor;

public class Pacman_Yellow extends Pacman {



	public Pacman_Yellow() {
		sprites = ImageLoader.getInstance().getYellowPacman();
		if (sprites == null) {
			System.out.println("Error while loading yellow_pacman sprite");
		}
	}
	


	@Override
	public void accept(Visitor V) {
		V.Visit(this);
	}



	



}
