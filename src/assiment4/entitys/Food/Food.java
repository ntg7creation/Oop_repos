package assiment4.entitys.Food;

import assiment4.entitys.MyEntity;
import assiment4.entitys.Pacmans.Pacman;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;
import assiment4.logic.Visitor;

public abstract class Food extends MyEntity implements Visitor {


	private int score;
	
	public int eat_me;
	
	@Override
	public void Visit(Pacman_Blue p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Visit(Pacman_Yellow p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Visit(Pacman_Red p) {
		// TODO Auto-generated method stub
		
	}
	
	private void Visit(Pacman p) {
		
	}
	
}
