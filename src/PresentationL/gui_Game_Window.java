package PresentationL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import LogicL.logic_Board;
import StorageL.image_Loader;

public class gui_Game_Window extends Costom_Frame implements ActionListener {
	
	private JButton[] buttons;
	private logic_Board logic;
	private image_Loader images;
	
	public gui_Game_Window(int size, logic_Board logic ,image_Loader images ) {
		super(600,600,size,size+2);
		this.logic = logic;
		this.images = images;
	}

	public void creat_buttons() {
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void action_button_click() {
		
	}

}
