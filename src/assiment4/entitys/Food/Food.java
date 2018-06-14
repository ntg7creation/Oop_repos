package assiment4.entitys.Food;

import assiment4.entitys.MyEntity;
import assiment4.entitys.Pac_mans.Pac_Man;
import assiment4.entitys.Pac_mans.Pac_Man_Blue;
import assiment4.entitys.Pac_mans.Pac_Man_Red;
import assiment4.entitys.Pac_mans.Pac_Man_Yellow;
import assiment4.logic.Visitor;

public abstract class Food extends MyEntity implements Visitor {

	private int score;
	
	public int eat_me;
	
	@Override
	public void Visit(Pac_Man_Blue p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Visit(Pac_Man_Yellow p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Visit(Pac_Man_Red p) {
		// TODO Auto-generated method stub
		
	}
	
	private void Visit(Pac_Man p) {
		
	}
	
}
