package Entities.Pacmans;

import Storage.ImageLoader;
import Logic.Visitor;

public class Pacman_Red extends Pacman {

	public Pacman_Red() {
		sprites = ImageLoader.getInstance().getRedPacman();
		if (sprites == null) {
			System.out.println("Error while loading red_pacman sprite");
		}
	}

	
	@Override
	public void accept(Visitor V) {
		V.Visit(this);
	}



}
