package assiment4.entitys;

import java.awt.Graphics;
import java.awt.Image;

import assiment4.logic.Timer_Listener;

public abstract class MyEntity implements Timer_Listener {

	private int X;
	private int Y;
	private int offsetX;
	private int offsetY;
	private Image[] sprites;
	
	public void draw(Graphics g)
	{
		
	}
	
	public int get_X()
	{
		return X;
	}
	
	public int get_Y()
	{
		return Y;
	}
	
}
