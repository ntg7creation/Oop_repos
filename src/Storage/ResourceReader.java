package Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import javafx.util.Pair;

public class ResourceReader {
    static final String scorePath = "res/ScoreBoard.txt";
    static final String uniDeli = "&#&#&&@#";

	private static Comparator<Pair<Integer,String>> comparator = new Comparator<Pair<Integer, String>>() {
        @Override
        public int compare(Pair<Integer, String> o1, Pair<Integer, String> o2) {
            return o2.getKey() - o1.getKey();
        }
    };


    public static List<Pair<Integer, String>> readScoreboard() {
        File scoreFile = new File(scorePath);
        try
        {
            List<Pair<Integer, String>> playerList = new LinkedList<Pair<Integer, String>>();
            Scanner inputStream = new Scanner(scoreFile);
            while (inputStream.hasNext()) {
                String line = inputStream.nextLine();
                String[] values = line.split(uniDeli);
                Pair<Integer,String> player = new Pair<>((Integer.parseInt(values[0])), values[1]);
                playerList.add(player);
            }
            playerList.sort(comparator);
            return playerList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fail to load file");
            return null;
        }
    }

    public static boolean addPlayer(int score, String player) {
        try {
            String newPlayer = String.format("%d%s%s\n", score, uniDeli, player);
            Files.write(Paths.get(scorePath), newPlayer.getBytes(), StandardOpenOption.APPEND);
            return true;
        }catch (IOException e) {
            return false;
        }
    }

    public static int[][] Load_Board(String path) {
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
