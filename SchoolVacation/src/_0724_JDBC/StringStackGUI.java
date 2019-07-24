package _0724_JDBC;

import java.awt.BorderLayout;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

import _0723.StringStack;



public class StringStackGUI extends JFrame {
	private static int n;
	JLabel array = new JLabel("배열 갯수 : ");
	JTextField artf = new JTextField();
	JButton arInput = new JButton("입력");
	JLabel data = new JLabel("입력 데이터 : ");
	JTextField datf = new JTextField();
	JButton daInput = new JButton("입력");
	JButton output = new JButton("출력");
	JLabel op = new JLabel();
	JPanel In = new JPanel();
	JPanel Out= new JPanel();
	Container contentPane;

	public StringStackGUI() {
		setTitle("String Stack Gui");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		In.setLayout(new BorderLayout());
		Out.setLayout(new BorderLayout());
		
		add(In, BorderLayout.NORTH);
		add(Out, BorderLayout.CENTER);
		
		In.setLayout(new GridLayout(2,3));
		Out.setLayout(new GridLayout(1,3));
		
		In.add(array);
		In.add(artf);
		In.add(arInput);
		In.add(data);
		In.add(datf);
		In.add(daInput);
		Out.add(new JLabel());
		Out.add(output);
		Out.add(op);
		
		
		add(In);
		add(Out);
		
		
		setSize(250,200);
		setVisible(true);
	}
	
	class ArrayInput implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			 JButton btn = (JButton) e.getSource();
			 if(btn.getText().equals("입력"))
				 n = artf;
		}
				   
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		StringStackGUI ssg = new StringStackGUI();
		
		StringStack ss = new StringStack(n);
	}

}
