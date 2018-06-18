package assiment4.Entitys.Ghosts;

import assiment4.Entitys.Pacmans.Pacman_Blue;
import assiment4.Entitys.Pacmans.Pacman_Red;
import assiment4.Entitys.Pacmans.Pacman_Yellow;

public class Ghost_Yellow extends Ghost {

	private int timecount;

	public Ghost_Yellow() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void action() {
		timecount++;
		//time to move the number 20 need to change
		//currently the Ghosts will move 1 picxle every 20 clock ticks
		if (timecount == 20)
			move();

	}

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

}
