package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.model.User;
import com.service.UserService;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class register {

	public  JFrame frame;
	private JTextField userName;
	private JPasswordField passWord;
	private JLabel iusername;
	private JLabel ipassword;
	private JButton button_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
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
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("\u4E2A\u4EBA\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 612, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 22));
		lblNewLabel.setBounds(125, 112, 92, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6 \u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 22));
		lblNewLabel_1.setBounds(125, 165, 86, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		userName = new JTextField();
		userName.setBounds(231, 112, 100, 35);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		passWord = new JPasswordField();
		passWord.setBounds(231, 165, 100, 35);
		frame.getContentPane().add(passWord);
		
		JButton button = new JButton("\u786E\u8BA4\u6CE8\u518C");
		button.setFont(new Font("黑体", Font.BOLD, 18));
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String username = userName.getText();
				String password = passWord.getText();
				User user = new User();
				boolean b = false;
				user.setUserName(username);
				user.setPassWord(password);
				
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
				
				if(!username.isEmpty()&&!password.isEmpty()){
				UserService userService =new UserService();
				try {
					 b = userService.register(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(b==true){
					login login = new login();
					login.frame.setVisible(true);
					register.this.frame.dispose();
				}else {
					iusername.setText("用户名已经被使用");
					iusername.setVisible(true);
				}
				}
			}
		});
		button.setBounds(188, 239, 113, 40);
		frame.getContentPane().add(button);
		
		iusername = new JLabel("\u7528\u6237\u540D\u4E0D\u80FD\u4E3A\u7A7A\uFF01\uFF01\uFF01");
		iusername.setForeground(Color.RED);
		iusername.setBounds(341, 126, 150, 18);
		frame.getContentPane().add(iusername);
		iusername.setVisible(false);
		
		ipassword = new JLabel("\u5BC6\u7801\u4E0D\u80FD\u4E3A\u7A7A\uFF01\uFF01\uFF01");
		ipassword.setForeground(Color.RED);
		ipassword.setBounds(339, 179, 142, 18);
		frame.getContentPane().add(ipassword);
		
		JButton button_1 = new JButton("\u524D\u5F80\u767B\u5F55");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login login = new login();
				login.frame.setVisible(true);
				register.this.frame.dispose();
				
				
			}
		});
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		button_1.setBounds(341, 239, 113, 40);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register.this.frame.dispose();
			}
		});
		button_2.setBounds(32, 23, 113, 27);
		frame.getContentPane().add(button_2);
		ipassword.setVisible(false);
	}
}
