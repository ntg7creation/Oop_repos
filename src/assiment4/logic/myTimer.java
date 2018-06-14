package assiment4.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.Timer;

public class myTimer implements ActionListener {

	private Timer timer;
	private final int delay = 1000;
	private LinkedList<Timer_Listener> listeners;

	public myTimer() {
		listeners = new LinkedList<Timer_Listener>();
		timer = new Timer(delay, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Timer_Listener timer_Listener : listeners) {
			timer_Listener.action();
		}
	}

	public void addTimerListener(Timer_Listener listener) {
		listeners.add(listener);
	}
}
