package assiment4.Storage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assiment3.StorageL.ResourceLoader;

public class csv_Reader {

	static public int[][] Load_Board(String path) {
		File file = new File(path);
		Scanner inputStream = null;
		List<int[]> lines = new ArrayList<>();
		int[] templine;
		int[][] board = new int[32][];

		try {
			inputStream = new Scanner(file);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fail to load file");
			return null;
		}

		try {
			while (inputStream.hasNext()) {
				String line = inputStream.nextLine();
				String[] values = line.split(",");
				templine = new int[values.length];
				for (int i = 0; i < templine.length; i++) {
					templine[i] = Integer.parseInt(values[i]);
				}
				lines.add(templine);
			}

			inputStream.close();
		} catch (Exception e) {
			System.out.println("rong input in csv");
			throw e;
		}
		int row = 0;
		for (int[] line : lines) {
			board[row] = line;
			row++;
		}

		return board;
	}

}
