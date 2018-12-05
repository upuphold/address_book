package com.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.model.User;
import com.service.UserService;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class login {

	public  JFrame frame;
	private JTextField userName;
	private JLabel iusername;
	private JLabel ipassword;
	private JPasswordField passWord;
	private JButton button;
	private JButton btnNewButton_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login login = new login();
					login.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("\u4E2A\u4EBA\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 623, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("黑体", Font.BOLD, 22));
		label.setBounds(159, 81, 99, 40);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setFont(new Font("黑体", Font.BOLD, 22));
		label_1.setBounds(159, 154, 99, 40);
		frame.getContentPane().add(label_1);
		
		userName = new JTextField();
		userName.setBounds(260, 87, 105, 35);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B  \u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = userName.getText();
				
				@SuppressWarnings("deprecation")
				String password = passWord.getText();
				
				//判断输入框是否为空
				if(username.isEmpty()){
					iusername.setVisible(true);
					if(password.isEmpty()){
						ipassword.setVisible(true);
					}else {
						ipassword.setVisible(false);
					}
				}else {
					iusername.setVisible(false);
					if(password.isEmpty()){
						ipassword.setVisible(true);
					}else {
						ipassword.setVisible(false);
					}	
				}
				
				//拿到数据，调用后台方法
				if(!username.isEmpty()&&!password.isEmpty()){
				User user  = new User();
				UserService userService = new UserService();
				user.setUserName(username);
				user.setPassWord(password);
				boolean bl = false;
				try {
					bl = userService.login(user);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(bl==true){
					home home = new home();
					home.frame.setVisible(true);
					login.this.frame.dispose();
				}else {
					fail fail =new fail();
					fail.frame.setVisible(true);
					login.this.frame.dispose();
				}
				}
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton.setBounds(124, 236, 113, 40);
		frame.getContentPane().add(btnNewButton);
		
		iusername = new JLabel("\u7528\u6237\u540D\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
		iusername.setForeground(Color.RED);
		iusername.setFont(new Font("新宋体", Font.PLAIN, 14));
		iusername.setBounds(379, 88, 147, 32);
		iusername.setVisible(false);
		frame.getContentPane().add(iusername);
		
		ipassword = new JLabel("\u5BC6\u7801\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
		ipassword.setFont(new Font("新宋体", Font.PLAIN, 14));
		ipassword.setForeground(Color.RED);
		ipassword.setBounds(379, 161, 147, 32);
		ipassword.setVisible(false);
		frame.getContentPane().add(ipassword);
		
		passWord = new JPasswordField();
		passWord.setBounds(260, 160, 105, 35);
		frame.getContentPane().add(passWord);
		
		button = new JButton("\u524D\u5F80\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register register =new register();
				register.frame.setVisible(true);
				login.this.frame.dispose();
			}
		});
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.setBounds(276, 236, 113, 40);
		frame.getContentPane().add(button);
		
		btnNewButton_1 = new JButton("\u767B\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.this.frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 18));
		btnNewButton_1.setBounds(423, 236, 113, 40);
		frame.getContentPane().add(btnNewButton_1);
	}
}
