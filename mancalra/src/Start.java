import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Start extends JPanel{
	private JButton Start_b;
	private JButton Way_b;
	
	Start(test t){
		Start_b = new JButton("게임 시작");
		Start_b.setBounds(100, 100, 100, 50);

		add(Start_b);
		Start_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) t.cards.getLayout();
				cardLayout.show(t.cards, "mode");
//				Firstchange("게임 시작");
			}
		});

		Way_b = new JButton("게임 방법");
		Way_b.setBounds(100, 300, 100, 50);

		add(Way_b);
		Way_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		CardLayout cardLayout = (CardLayout) t.cards.getLayout();
				cardLayout.show(t.cards, "menu");
//				Firstchange("게임 방법");
			}
		});
	}
}
