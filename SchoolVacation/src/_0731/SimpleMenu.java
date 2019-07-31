package _0731;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import _0731.MenuAndFileDialogEx.OpenActionListener;

public class SimpleMenu extends JFrame{

	Container contentPane;
	JLabel imageLabel = new JLabel();

	SimpleMenu() {
		setTitle("SimpleMenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.add(imageLabel);
		createMenu();
		setSize(250, 200);
		setVisible(true);
	}
	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("����");
		JMenu changeMenu = new JMenu("����");
		JMenu showMenu = new JMenu("����");
		JMenu inputMenu = new JMenu("�Է�");
		JMenuItem screenItem = new JMenuItem("ȭ��Ȯ��");
		JMenuItem sideItem = new JMenuItem("������");
//		screenItem.addActionListener(new OpenActionListener());
//		sideItem.addActionListener(new OpenActionListener());
		showMenu.add(screenItem);
		showMenu.add(sideItem);
		mb.add(fileMenu);
		mb.add(changeMenu);
		mb.add(showMenu);
		mb.add(inputMenu);
		this.setJMenuBar(mb);
	}
	public static void main(String[] args) {
		new SimpleMenu();
	}
}
