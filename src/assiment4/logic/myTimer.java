package assiment4.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class myTimer implements ActionListener {

	private Timer timer;
	private final int delay = 1000;
	private Timer_Listener[] listeners;
	
	public myTimer()
	{
		timer = new Timer(delay,this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Timer_Listener timer_Listener : listeners) {
			timer_Listener.action();
		}	
	}
	
}
