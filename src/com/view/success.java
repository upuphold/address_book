package com.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class success {

	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					success window = new success();
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
	public success() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("\u4E2A\u4EBA\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 651, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u64CD\u4F5C\u6210\u529F\uFF01\uFF01\uFF01");
		label.setFont(new Font("ºÚÌå", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(217, 83, 157, 40);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home home = new home();
				home.frame.setVisible(true);
				success.this.frame.dispose();
			}
		});
		button.setBounds(237, 163, 113, 40);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				success.this.frame.dispose();
			}
		});
		button_1.setBounds(14, 13, 113, 27);
		frame.getContentPane().add(button_1);
	}

}
