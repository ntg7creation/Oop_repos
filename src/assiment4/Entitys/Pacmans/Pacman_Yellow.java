package assiment4.Entitys.Pacmans;

import assiment4.Logic.Visitor;

public class Pacman_Yellow extends Pacman {

	private final String yellowPath = "Yellow/";
	private final String[] imagesPath = {yellowPath + "1.png", yellowPath + "2.png"};

	public Pacman_Yellow() {
		if (!loadSprite(imagesPath)) {
			System.out.println("Error while loading pacman-yellow sprite");
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
