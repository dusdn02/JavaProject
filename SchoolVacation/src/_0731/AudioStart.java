package _0731;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class AudioStart extends JFrame{
	private Clip clip = null;
	private AudioInputStream audioStream = null;
	private JLabel msgLabel = new JLabel("오디오 파일");
	private JButton sbtn = new JButton("연주");
	private JButton ebtn = new JButton("종료");
	
	public AudioStart() {
		super("오디오 파일을 연주/종료 제어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		msgLabel.setFont(new Font("Gothic",Font.PLAIN,15));
		msgLabel.setHorizontalAlignment(JLabel.CENTER);
		sbtn.setHorizontalAlignment(JButton.CENTER);
		ebtn.setHorizontalAlignment(JButton.RIGHT);
		c.add(msgLabel);
		c.add(sbtn);
		c.add(ebtn);
		
		setSize(450,150);
		setVisible(true);
		
		sbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clip !=null && clip.isActive())
					clip.close();
				
			}
		});
	}
	public static void main(String[] args) {
		new AudioStart();
	}
}
