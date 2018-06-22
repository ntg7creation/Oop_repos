package assiment4.Presention;

import assiment4.Storage.ResourceReader;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Score_Board extends JFrame {
	public Score_Board() {
		Vector<String> printableList = new Vector<>();
		List<Pair<Integer, String>> list = ResourceReader.readScoreboard();
		int i = 1;
		Iterator<Pair<Integer, String>> iterator = list.iterator();
		while (iterator.hasNext() && i < 11) {
			Pair<Integer, String> pair = iterator.next();
			String player = String.format("%d. Player: %s , Score: %d", i, pair.getValue(), pair.getKey());
			printableList.add(player);
			i++;
		}

		JList<String> playerJList = new JList<>();
		playerJList.setListData(printableList);

		playerJList.setLocation(100, 100);
		playerJList.setFont(new Font("Ariel", Font.ITALIC, 36));
		playerJList.setForeground(Color.BLUE);
		playerJList.setBackground(Color.black);

		getContentPane().add(playerJList);
		getContentPane().setBackground(Color.black);

		pack();
		setMinimumSize(new Dimension(500, 500));
		setVisible(true);
	}

}
