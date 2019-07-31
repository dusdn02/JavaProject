package thredex;

import java.awt.*;
import java.util.Calendar;

import javax.swing.*;

class DigitalClockFrame extends JFrame {
	public DigitalClockFrame() {
		setTitle("������ �ð� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new MyLabel());
		setSize(300,200);
		setVisible(true);
	}
	
	class MyLabel extends JLabel implements Runnable {
		private Thread timerThread = null;
		public MyLabel() {
			setText(makeClockText());
			setFont(new Font("TimesRoman", Font.ITALIC, 50));
			setHorizontalAlignment(JLabel.CENTER);
			timerThread = new Thread(MyLabel.this);
			timerThread.start();
		}
		@Override
		public void run() {
			while(true) {			
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {
					return;
				}
				setText(makeClockText());
			}
			
		}
	}
	
	public String makeClockText() {
		Calendar c = Calendar.getInstance(); 
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		String clockText = Integer.toString(hour);
		clockText = clockText.concat(":");
		clockText = clockText.concat(Integer.toString(min));
		clockText = clockText.concat(":");
		clockText = clockText.concat(Integer.toString(second));
		
		return clockText;
	}

	public static void main(String[] args) {
		new DigitalClockFrame();
	}
}