package test_and_samples;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Jumper extends JFrame implements ActionListener {
	
	
	public Jumper() {
		super("Jumper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("Catch me!");
		btn.addActionListener(this); // source.addXListener(listener)
		Container cp = getContentPane();
		cp.add(btn);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Random rand = new Random();
		int x = rand.nextInt(300);
		int y = rand.nextInt(300);
		setLocation(x, y);
	}
}