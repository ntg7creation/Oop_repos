package PresentationL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* The winning frame
*
* */
public class WinnigFrame extends Custom_Frame {

    public WinnigFrame(gui_Game_Window boardGame, Game_Menu menu, int numMoves, int timePassed) {
        super(500,500,4,10);

        JLabel moves = new JLabel();
        String movesTxt = String.format("You have finished in %d moves", numMoves);
        Creat_Label_at(moves, movesTxt, 1, 2);

        JLabel time = new JLabel();
        String timeTxt = String.format("Time played: %d sec", timePassed);
        Creat_Label_at(time, timeTxt, 1, 3);

        JButton exit = new JButton();
        Creat_Button_at(exit, "Exit to main menu", 1, 8);
        exit.setVisible(true);
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                boardGame.dispose();
                menu.dispose();
                new Main_Menu();
            }
        });

        JButton playAgain = new JButton();
        Creat_Button_at(playAgain, "Play again", 1, 6);
        playAgain.setVisible(true);
        playAgain.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                boardGame.dispose();
                menu.setVisible(true);
            }
        });
    }
}
