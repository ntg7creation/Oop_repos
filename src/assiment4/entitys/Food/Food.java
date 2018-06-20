package assiment4.entitys.Food;

import assiment4.entitys.MyEntity;
import assiment4.entitys.Pacmans.Pacman;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;
import assiment4.logic.Visitor;

public abstract class Food extends MyEntity implements Visitor {

	protected final int id = 256;
	protected int points = 0;
	public int eat_me;

	@Override
	public void Visit(Pacman_Blue p) {
		board.eat_food_at(X, Y, points);
	}

	@Override
	public void Visit(Pacman_Yellow p) {
		System.out.println(X + "  " + Y);
		board.eat_food_at(X, Y, points);
	}

	@Override
	public void Visit(Pacman_Red p) {
		board.eat_food_at(X, Y, points);
	}

	//
	// @Override
	// public void Visit(Pacman p) {
	// }

	@Override
	public int get_id() {
		// TODO Auto-generated method stub
		return id;
	}
}
