package assiment4.entitys.Pacmans;

import assiment4.logic.Visitor;

public class Pacman_Blue extends Pacman {

    private final String bluePath = "Blue/";
    private final String[] imagesPath = {bluePath + "1.png", bluePath + "2.png"};

	public Pacman_Blue(int[][] board) {
		super(board);
	    if (!loadSprite(imagesPath)) {
	        System.out.println("Error while loading pacman-blue sprite");
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
