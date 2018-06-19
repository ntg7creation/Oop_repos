package assiment4;

import assiment4.logic.Moving_Direction;

public class tester {

	public static void main(String[] arg) {
		Moving_Direction dirc;

		int[][] tempcsv = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1 },
				{ 1, 2, 2, 2, 2, 16, 2, 2, 2, 2, 2, 1 }, { 1, 2, 4, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
				{ 1, 2, 2, 2, 2, 2, 2, 8, 2, 2, 2, 1 }, { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
				{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 }, { 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1 },
				{ 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1 }, { 1, 2, 32, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
				{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };
		dirc = Moving_Direction.Up;
		System.out.println(tempcsv[1][6]);
	}

}
