import java.awt.*;
import javax.swing.*;

public class GameBoard extends JFrame{
	
	Container contentPane;
	public GameBoard() {
		setTitle("MANCALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		
		ImageIcon board = new ImageIcon("src/GameBoard/ngb.jpg");
		JLabel imageLabel = new JLabel(board);// 게임보드
		
		JButton[] ball = new JButton[13];// 구멍들
		for (int i = 0; i < 13; i++) {
			if (i == 6)
				continue;
			ball[i] = new JButton();
		}//공들이 있는 항아리들 선언
		
		contentPane.setLayout(null);
		ball[0].setBounds(380, 338, 90, 40);
		contentPane.add(ball[0]);
		ball[1].setBounds(590, 338, 90, 40);
		contentPane.add(ball[1]);
		ball[2].setBounds(798, 338, 90, 40);
		contentPane.add(ball[2]);
		ball[3].setBounds(1020, 338, 90, 40);
		contentPane.add(ball[3]);
		ball[4].setBounds(1230, 338, 90, 40);
		contentPane.add(ball[4]);
		ball[5].setBounds(1441, 338, 90, 40);
		contentPane.add(ball[5]);
		ball[7].setBounds(385, 813, 90, 40);
		contentPane.add(ball[7]);
		ball[8].setBounds(595, 813, 90, 40);
		contentPane.add(ball[8]);
		ball[9].setBounds(794, 813, 90, 40);
		contentPane.add(ball[9]);
		ball[10].setBounds(1025, 813, 90, 40);
		contentPane.add(ball[10]);
		ball[11].setBounds(1235, 813, 90, 40);
		contentPane.add(ball[11]);
		ball[12].setBounds(1452, 813, 90, 40);
		contentPane.add(ball[12]);
		imageLabel.setBounds(0, 200, 1910, 800);
		contentPane.add(imageLabel);

//		add(contentPane);
		
		
		setSize(1900,900);
		setVisible(true);
	}
	
	

}
