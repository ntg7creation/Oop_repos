package Entities.Ghosts;

import Storage.ImageLoader;
import Entities.Attacks.Fire_Ball;
import Entities.Pacmans.Pacman_Blue;
import Entities.Pacmans.Pacman_Red;
import Entities.Pacmans.Pacman_Yellow;

public class Ghost_Red extends Ghost {

	Fire_Ball fire;
	private final int id = 32;
	// temp

	public Ghost_Red() {
		sprites = ImageLoader.getInstance().getRedGhost();
		if (sprites == null) {
			System.out.println("Error while loading ghost_red sprite");
		}
		fire = null;
		startdealyTime -= (5 * 25);
	}
	
	public Fire_Ball get_fire()
	{
		return fire;
	}
	
	@Override
	public void action() {
		if (dealyTime >= 0) {
			move();
			if(fire != null)
			{
				fire.move();
				fire.move();
				fire.move();
				fire.move();
				fire.move();
			}
			if (++count_Ticks % (5 * 25) == 0) {
				fire = new Fire_Ball();
				fire.set_start(X, Y);
				fire.setDirction(direc);
				fire.add_Board_Listener(board);
				
			}
		} else {
			dealyTime++;
		}

	}
	

	@Override
	public void Visit(Pacman_Blue p) {
		board.Death();
	}

	@Override
	public void Visit(Pacman_Yellow p) {
		board.Death();
	}

	@Override
	public void Visit(Pacman_Red p) {
		board.Death();
	}

	@Override
	public int get_id() {
		// TODO Auto-generated method stub
		return id;
	}

}
