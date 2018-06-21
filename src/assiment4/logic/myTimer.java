package assiment4.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.Timer;

import assiment4.Presention.game_Manu;

public class myTimer implements ActionListener {

	private Timer timer;
	private final int delay = 40; // 1000 = 1 sec
	private LinkedList<Timer_Listener> listeners;
	private LinkedList<Timer_Listener> Importent_listeners;
	private int tickCount = 0;
	private int secCount = 0;

	private static myTimer instance = null;

	public static myTimer getInstance() {
		if (instance == null) {
			instance = new myTimer();
		}
		return instance;
	}

	private myTimer() {
		listeners = new LinkedList<Timer_Listener>();
		Importent_listeners = new LinkedList<Timer_Listener>();
		timer = new Timer(delay, this);
	}

	public void set_speed(int speed) {
		timer.setDelay(delay / speed);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		tickCount++;
		if (tickCount >= 25) {
			tickCount = 0;
			secCount++;
		}
		for (Timer_Listener timer_Listener : listeners) {
			timer_Listener.action();
		}
		for (Timer_Listener timer_Listener : Importent_listeners) {
			timer_Listener.action();
		}
	}

	public void addTimerListener(Timer_Listener listener) {
		if (listener != null)
			listeners.add(listener);

	}

	public void start() {
		timer.start();
	}

	public void Clear() {

		listeners = new LinkedList<Timer_Listener>();
	}

	public void addTimerListenerImportent(Timer_Listener listener) {
		if (listener != null)
			Importent_listeners.add(listener);

	}
}
