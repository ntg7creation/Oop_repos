package assiment4.logic;

import assiment4.entitys.Pacmans.Pacman;
import assiment4.entitys.Pacmans.Pacman_Blue;
import assiment4.entitys.Pacmans.Pacman_Red;
import assiment4.entitys.Pacmans.Pacman_Yellow;

public interface Visitor {

	 public void Visit(Pacman p);
	 public void Visit(Pacman_Blue p);
	 public void Visit(Pacman_Yellow p);
	 public void Visit(Pacman_Red p);
}
