import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Way extends JDialog{
	JButton okButton;
	ImageIcon backw;
	
	Way(Main m){
		okButton = new JButton("OK");
		okButton.setFont(m.f);
		
		backw = new ImageIcon("src/images/WayIcon.jpg");
		JLabel back = new JLabel(backw);
		
		setLayout(null);
		back.setSize(900, 559);
		add(back);
		okButton.setBounds(400, 510, 80, 40);
		back.add(okButton);
		setSize(920,610);
		setLocation(450,250);
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		System.out.println("Menu ¿Ï·á");
	}

}