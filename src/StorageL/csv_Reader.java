package StorageL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class csv_Reader {

	public List<int[][]>[] read2(String path) {
		String fileName = path;
		File file = new File(fileName);
		int row = 0;
		List<int[][]>[] allBoards = new List[3];
		allBoards[0] = new ArrayList<>();// all boards that are 3x3
		allBoards[1] = new ArrayList<>();// all boards that are 4x4
		allBoards[2] = new ArrayList<>();// all boards that are 5x5
		Scanner inputStream = null;
		int[][] tempboard = null;
		int boardsize = 0;

		try {
			inputStream = new Scanner(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		try {
			while (inputStream.hasNext()) {
				String line = inputStream.nextLine();
				String[] values = line.split(",");
				if (values.length <= 1) {
					row = 0;
					if (tempboard != null)
						allBoards[boardsize - 3].add(tempboard); // we have a board so we add it to the list
					boardsize = Integer.parseInt(values[0]); // the size of the next board
					tempboard = new int[boardsize][];
				} else {
					tempboard[row] = new int[boardsize];
					for (int i = 0; i < boardsize; i++) {
						tempboard[row][i] = Integer.parseInt(values[i]); // add the line to the board
					}
					row++;
				}

			}

			inputStream.close();
		} catch(Exception e)  {
			System.out.println("rong input in csv");
		}

		
		print2(allBoards);

		return allBoards;
	}

	public void print2(List<int[][]>[] boards) {
		for (List<int[][]> list : boards) {
			for (int[][] board : list) {
				for (int[] line : board) {
					for (int i : line) {
						System.out.print(i + ",");
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		csv_Reader r = new csv_Reader();
		List<String[][]> txt = new ArrayList<>();
		r.read2("boards.csv");
		// r.print(txt);
	}
}