package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class home {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home home = new home();
					home.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("\u4E2A\u4EBA\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 884, 637);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u4EBA\u5458\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				select select = new select();
				select.frame.setVisible(true);
				home.this.frame.dispose();
				
				
			}
		});
		btnNewButton.setBounds(564, 90, 161, 63);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u4EBA\u5458\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add add = new add();
				add.frame.setVisible(true);
				home.this.frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(564, 206, 161, 63);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("\u5220\u9664\u4EBA\u5458\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete delete = new delete();
				delete.frame.setVisible(true);
				home.this.frame.dispose();
			}
		});
		button.setBounds(564, 439, 161, 63);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539\u4EBA\u5458\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				update update = new update();
				update.frame.setVisible(true);
				home.this.frame.dispose();
				
			}
		});
		button_1.setBounds(564, 323, 161, 63);
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login login =new login();
				login.frame.setVisible(true);
				home.this.frame.dispose();
			}
		});
		btnNewButton_2.setBounds(171, 457, 113, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.this.frame.dispose();
			}
		});
		button_2.setBounds(171, 359, 113, 27);
		frame.getContentPane().add(button_2);
	}
}
