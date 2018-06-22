package Logic;

import Entities.Pacmans.Pacman_Blue;
import Entities.Pacmans.Pacman_Red;
import Entities.Pacmans.Pacman_Yellow;

public interface Visitor {

	// public void Visit(Pacman p);
	 public void Visit(Pacman_Blue p);
	 public void Visit(Pacman_Yellow p);
	 public void Visit(Pacman_Red p);
}
