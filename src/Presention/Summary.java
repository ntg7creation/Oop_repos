package Presention;

import Storage.ResourceReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Summary extends JFrame {
    private SpringLayout layout;

    public Summary(int[] eatenFood, int score) {
        super("Summary");

        String s = (String)JOptionPane.showInputDialog(
                this,
                "Please enter your name to enter the scoreboard",
                "Username Dialog",
                JOptionPane.QUESTION_MESSAGE,
                null,null, "");

        if ((s != null) && (s.length() > 0)) {
            ResourceReader.addPlayer(score, s);
        }

        layout=new SpringLayout();
        setLayout(layout);

        setSize(800,800);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setupScreen(eatenFood, score);





    }

    private void setupScreen(int[] eatenFood, int score) {
        ImageIcon image = new ImageIcon("res/Images/Game/Summary.jpg");
        getContentPane().setBackground(Color.WHITE);

        JLabel imageLabel=new JLabel(image);
        getContentPane().add(imageLabel);
//        imageLabel.setLocation(200,120);
        layout.putConstraint(SpringLayout.WEST,imageLabel,80,SpringLayout.WEST,getContentPane());

        JLabel scoreLabel=new JLabel("You've earned the score of "+score);
        scoreLabel.setForeground(Color.BLUE);
        scoreLabel.setFont(new Font("Ariel", Font.ITALIC, 18));
        layout.putConstraint(SpringLayout.WEST,scoreLabel,225,SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,scoreLabel,400,SpringLayout.NORTH,getContentPane());

        String food = String.format("%d apples - %d strawberries - %d pineapples", eatenFood[0], eatenFood[1], eatenFood[2]);
        JLabel foodLabel=new JLabel("You have collected "+food);
        foodLabel.setForeground(Color.BLUE);
        foodLabel.setFont(new Font("Ariel", Font.ITALIC, 18));
        layout.putConstraint(SpringLayout.WEST,foodLabel,110,SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,foodLabel,450,SpringLayout.NORTH,getContentPane());

        JButton scoreBoard =new JButton("Score Board");
        scoreBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Score_Board();
                dispose();
            }
        });

        layout.putConstraint(SpringLayout.WEST,scoreBoard,350,SpringLayout.WEST,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,scoreBoard,650,SpringLayout.NORTH,getContentPane());



        getContentPane().add(scoreLabel);
        getContentPane().add(foodLabel);
        getContentPane().add(scoreBoard);

    }
}

