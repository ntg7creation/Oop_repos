package assiment4.Entitys.Food;

import assiment4.Entitys.MyEntity;
import assiment4.Entitys.Pacmans.Pacman;
import assiment4.Entitys.Pacmans.Pacman_Blue;
import assiment4.Entitys.Pacmans.Pacman_Red;
import assiment4.Entitys.Pacmans.Pacman_Yellow;
import assiment4.Logic.Visitor;

public abstract class Food extends MyEntity implements Visitor {

	protected final String foodPath = path + "Food/";
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
