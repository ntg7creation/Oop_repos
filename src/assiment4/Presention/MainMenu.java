package assiment4.Presention;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Manu extends JFrame {



    public main_Manu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        panel.setSize(500, 500);
        ImageIcon start = new ImageIcon("res/Images/Game/StartScreen.png");
        start.paintIcon(panel, panel.getGraphics(),100,100);

        JButton scoringBoard = new JButton("Score Board");
        scoringBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Score_Board();
                dispose();
            }
        });

        scoringBoard.setLocation(400, 400);
        scoringBoard.setVisible(true);

        panel.add(scoringBoard);
        panel.setVisible(true);
        this.add(panel);
    }
}
