package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fail {

	public  JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fail window = new fail();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public fail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("ºÚÌå", Font.BOLD | Font.ITALIC, 18));
		frame.setBounds(100, 100, 531, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u53F7\u5BC6\u7801\u51FA\u9519\uFF01\uFF01\uFF01");
		label.setFont(new Font("ºÚÌå", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(154, 57, 171, 35);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("\u8FD4\u56DE\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login login = new login();
				login.frame.setVisible(true);
				fail.this.frame.dispose();
			}
		});
		button.setFont(new Font("ºÚÌå", Font.PLAIN, 18));
		button.setBounds(171, 154, 113, 40);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fail.this.frame.dispose();
			}
		});
		button_1.setBounds(32, 23, 113, 27);
		frame.getContentPane().add(button_1);
	}
}
