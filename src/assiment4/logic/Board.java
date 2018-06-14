package assiment4.logic;

import java.awt.Graphics;

import assiment4.entitys.Food.Yello_Palet;

public class Board {

	//this will be made 1 time and not change
	private Graphics board_walls;
	//this will change each time we eat a Yello_Palet
	private Graphics board_yello_Palets;
	
	private int yello_Palets_Count;
	
	private int[][] board;
	// its is better to keep the yello palets in here cus they are static and we have a lot of them
	private Yello_Palet[][] yello_Palets;
	
	public Board(int[][] csv) {
		
	}
	
	public int items_at(int x, int y)
	{
		return 0;
	}
	
	//return 10 if there is a palet at x y else return 0
	public int eat_Palert_at(int x, int y) {
		return 0;
	}
	
	public Boolean is_wall_at()
	{
		return false;
	}
	

}
