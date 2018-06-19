package assiment4.entitys.Pacmans;

import assiment4.logic.Visitor;

public class Pacman_Red extends Pacman {

	private final String redPath = "Red/";
	private final String[] imagesPath = {redPath + "1.png", redPath + "2.png"};

	public Pacman_Red(int[][] board) {
		super(board);
		if (!loadSprite(imagesPath)) {
			System.out.println("Error while loading pacman-red sprite");
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
