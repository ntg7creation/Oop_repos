package assiment4.logic;

import assiment4.entitys.MyEntity;

public interface Board_action_Listener {

	public Boolean is_wall(int x, int y);

	public void I_just_Moved(MyEntity entity);
}
