package assiment4.entitys.Goust;

import assiment4.entitys.Pac_mans.Pac_Man_Blue;
import assiment4.entitys.Pac_mans.Pac_Man_Red;
import assiment4.entitys.Pac_mans.Pac_Man_Yellow;
import assiment4.logic.Moving_Direction;

public class Goust_Yellow extends Goust {

	private int timecount;

	@Override
	public void action() {
		timecount++;
		//time to move the number 20 need to change
		//currently the Goust will move 1 picxle every 20 clock ticks
		if (timecount == 20)
			move();

	}

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

}
