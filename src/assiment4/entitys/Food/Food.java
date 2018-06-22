package assiment4.entitys.Food;

import java.util.Random;

import assiment4.entitys.MyEntity;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;
import assiment4.logic.Visitor;

public abstract class Food extends MyEntity implements Visitor {

	protected int id = 256;
	protected int points = 0;
	public int eat_me;
	private Boolean has_place = false;

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

		if (!has_place && count_Ticks++%(5 * 25) ==  0) {
			Random r = new Random();
			int x = r.nextInt(31);
			int y = r.nextInt(31);
			Boolean b = board.is_of_type(x, y, 1 + 2 + 4 + 256 + 512 + 2048);// + 2 + 4 + 256 + 512+2048);

			if (!b) {
				has_place = true;
				X = x;
				Y = y;
				board.add_Food(this);
			}

		}
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
