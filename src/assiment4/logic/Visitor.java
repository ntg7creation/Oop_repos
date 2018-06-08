package assiment4.logic;

import assiment4.entitys.Pac_mans.Pac_Man_Blue;
import assiment4.entitys.Pac_mans.Pac_Man_Red;
import assiment4.entitys.Pac_mans.Pac_Man_Yellow;

public interface Visitor {

	 public void Visit(Pac_Man_Blue p);
	 public void Visit(Pac_Man_Yellow p);
	 public void Visit(Pac_Man_Red p);
}
