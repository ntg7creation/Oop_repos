package Logic;

import Entities.MyEntity;
import Entities.Food.Food;

public interface Board_action_Listener {

	public Boolean is_of_type(int x, int y, int type);

	public void I_just_Moved(MyEntity entity);

	public void eat_food_at(Food food);

	public void Death();

	public void add_Food(Food food);

	}
