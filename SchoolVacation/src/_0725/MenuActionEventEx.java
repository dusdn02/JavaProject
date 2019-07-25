package _0725;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class MenuActionEventEx extends JFrame{
	Container contentPane;
	JLabel label = new JLabel("Hello");
	
	MenuActionEventEx(){
		setTitle("Menu 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.CENTER);
		createMenu();
		setSize(400,300);
		setVisible(true);
	}
	
	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem [] menuItem = new JMenuItem[4];
		String[] itemTitle = {"Color","Font","Top","Bottom"};
		JMenu textMenu = new JMenu("Text");
		for(int i=0;i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(new MenuActionListenr());
			textMenu.add(menuItem[i]);
		}
		mb.add(textMenu);
		this.setJMenuBar(mb);
	}
	
	class MenuActionListenr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("Color"))
				label.setForeground(Color.BLUE);
			else if(cmd.equals("Font"))
				label.setFont(new Font("Ravie", Font.ITALIC, 30));
			else if(cmd.equals("Top"))
				label.setVerticalAlignment(SwingConstants.TOP);
			else
				label.setVerticalAlignment(SwingConstants.BOTTOM);
		}
	}
	
	public static void main(String[] args) {
		new MenuActionEventEx();
	}

}
