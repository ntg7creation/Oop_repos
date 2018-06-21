package assiment4.entitys.Food;

import assiment4.entitys.MyEntity;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;
import assiment4.logic.Visitor;

public abstract class Food extends MyEntity implements Visitor {

	protected int id = 256;
	protected int points = 0;
	public int eat_me;

	@Override
	public void Visit(Pacman_Blue p) {
		board.eat_food_at(this);
	}

	@Override
	public void Visit(Pacman_Yellow p) {
		board.eat_food_at(this);
	}

	@Override
	public void Visit(Pacman_Red p) {
		board.eat_food_at(this);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	public int get_points() {
		return points;
	}

	@Override
	public int get_id() {
		// TODO Auto-generated method stub
		return id;
	}
}
