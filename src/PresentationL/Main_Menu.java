package PresentationL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Menu extends Custom_Frame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main_Menu() {
        super(500,500,4,10);

        JLabel title = new JLabel("Sliding Puzzle");
        Font font = new Font("Ariel", Font.BOLD, 50);
        title.setFont(font);
        title.setBounds(85,100,500,100);
        title.setForeground(Color.blue);
        Panel.add(title);

        JButton startBtn = new JButton();
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Game_Menu();
                dispose();
            }
        });
        Creat_Button_at(startBtn, "Start", 1,7);
        startBtn.setVisible(true);

        JButton exitBtn = new JButton();
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        Creat_Button_at(exitBtn, "Exit", 3,7);
        exitBtn.setVisible(true);
    }
	

    public static void main(String[] args) {
        new Main_Menu();
    }

}
