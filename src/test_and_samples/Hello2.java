package test_and_samples;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Hello2 extends JFrame{

	public Hello2(){
        super("Title Bar"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton click = new JButton("This is a button");
        Container cp = getContentPane();
        cp.add(click);
        pack();
        setVisible(true);
    }  

    public static void main(String args[]){
        Hello2 frame = new Hello2();
    }

}