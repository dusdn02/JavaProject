import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NameInput extends JDialog {
	JLabel first_player;
	JLabel second_player;
	JTextField first_playerName;
	JTextField second_playerName;
	JButton okButton = new JButton("OK");
	String fn, sn;

	NameInput() {
		first_player = new JLabel("첫 번째로 할 플레이어의 닉네임을 적어주세요");
		first_player.setBounds(20, 20, 100, 20);
		first_playerName = new JTextField();
		first_playerName.setBounds(20, 40, 100, 20);

		second_player = new JLabel("두 번째로 할 플레이어의 닉네임을 적어주세요");
		second_player.setBounds(20, 60, 100, 20);
		second_playerName = new JTextField();
		second_playerName.setBounds(20, 80, 100, 20);

		add(first_player);
		add(first_playerName);
		add(second_player);
		add(second_playerName);
		setSize(200, 100);

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fn=first_playerName.getText();
				sn=second_playerName.getText();
				setVisible(false);

			}
		});
	}

}
