package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.model.PersonInfo;
import com.service.PersonService;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class add {

	 JFrame frame;
	 private JTextField Name;
	 private JTextField Sex;
	 private JTextField Phone;
	 private JTextField Qq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add window = new add();
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
	public add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBackground(Color.GRAY);
		frame.setTitle("\u4E2A\u4EBA\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 856, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel bName = new JLabel("\u59D3\u540D\uFF1A");
		bName.setBounds(81, 83, 88, 32);
		frame.getContentPane().add(bName);
		
		Name = new JTextField();
		Name.setBounds(134, 87, 86, 24);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		JLabel bSex = new JLabel("\u6027\u522B\uFF1A");
		bSex.setBounds(392, 90, 72, 18);
		frame.getContentPane().add(bSex);
		
		Sex = new JTextField();
		Sex.setBounds(442, 87, 86, 24);
		frame.getContentPane().add(Sex);
		Sex.setColumns(10);
		
		JLabel bPhone = new JLabel("\u624B\u673A\u53F7\uFF1A");
		bPhone.setBounds(73, 161, 72, 18);
		frame.getContentPane().add(bPhone);
		
		Phone = new JTextField();
		Phone.setBounds(134, 158, 86, 24);
		frame.getContentPane().add(Phone);
		Phone.setColumns(10);
		
		JLabel bQq = new JLabel("QQ:");
		bQq.setBounds(392, 161, 72, 18);
		frame.getContentPane().add(bQq);
		
		Qq = new JTextField();
		Qq.setBounds(442, 158, 86, 24);
		frame.getContentPane().add(Qq);
		Qq.setColumns(10);
		
		JLabel bWork = new JLabel("\u5DE5\u4F5C\uFF1A");
		bWork.setBounds(81, 244, 72, 18);
		frame.getContentPane().add(bWork);
		
		JTextArea Work = new JTextArea();
		Work.setBounds(129, 242, 161, 77);
		frame.getContentPane().add(Work);
		
		JLabel baddress = new JLabel("\u5BB6\u5EAD\u5730\u5740\uFF1A");
		baddress.setBounds(380, 244, 84, 18);
		frame.getContentPane().add(baddress);
		
		JTextArea Address = new JTextArea();
		Address.setBounds(463, 242, 196, 77);
		frame.getContentPane().add(Address);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\u4E0D\u80FD\u4E3A\u7A7A");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(234, 90, 103, 18);
		lblNewLabel.setVisible(false);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer id = null;
				try {
					@SuppressWarnings("resource")
					BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/Id.txt"))));
					String str=null; 
					while((str=br.readLine())!=null) 
					{ 
						id = Integer.parseInt(str);
						
					 
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				PersonInfo personInfo =new PersonInfo();
				PersonService personService =new PersonService();
				String name;
				name = Name.getText();
				if(name.isEmpty()){
					lblNewLabel.setVisible(true);
				}else {
					personInfo.setUserId(id);
					personInfo.setPersonName(name);
					personInfo.setPersonSex(Sex.getText());
					personInfo.setPersonPhone(Phone.getText());
					personInfo.setPersonQq(Qq.getText());
					personInfo.setPersonWork(Work.getText());
					personInfo.setPersonAddress(Address.getText());
					
					boolean bl = false;
					try {
						bl = personService.addPerson(personInfo);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(bl==true){
						home home = new home();
						home.frame.setVisible(true);
						add.this.frame.dispose();
					}
					
					
				}
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(203, 402, 113, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home home = new home();
				home.frame.setVisible(true);
				add.this.frame.dispose();
			}
		});
		btnNewButton_1.setBounds(442, 402, 113, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add.this.frame.dispose();
			}
		});
		button.setBounds(32, 13, 113, 27);
		frame.getContentPane().add(button);
		
		
	}
}
