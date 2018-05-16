package test_and_samples;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Hello2 extends JFrame implements KeyListener{

	public Hello2(){
        super("Title Bar"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton click = new JButton("This is a button");
        Container cp = getContentPane();
        cp.add(click);
        addKeyListener(this);
        pack();
        setVisible(true);
    }  

    public static void main(String args[]){
        Hello2 frame = new Hello2();
        frame.addKeyListener(frame);
        frame.setFocusable(true);
    }

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("test");
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		System.out.println("test");
		

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println("test");
		

	}

}