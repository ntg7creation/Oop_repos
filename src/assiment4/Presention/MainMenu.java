package assiment4.Presention;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {



    public MainMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500,500));
        Panel panel = new Panel();
        panel.setSize(500, 500);


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

        pack();
        this.add(panel);
        this.setVisible(true);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon start = new ImageIcon("res/Images/Game/StartScreen.png");
        start.paintIcon(this, g,100,100);
    }
}
