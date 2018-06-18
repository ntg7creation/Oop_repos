package assiment4.Logic;

import assiment4.Entitys.Pacmans.Pacman_Blue;
import assiment4.Entitys.Pacmans.Pacman_Red;
import assiment4.Entitys.Pacmans.Pacman_Yellow;

public interface Visitor {

	 public void Visit(Pacman_Blue p);
	 public void Visit(Pacman_Yellow p);
	 public void Visit(Pacman_Red p);
}
