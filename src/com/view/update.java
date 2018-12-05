package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.model.PersonInfo;
import com.service.PersonService;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class update {

	public JFrame frame;
	private  JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update window = new update();
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
	public update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setFont(new Font("黑体", Font.BOLD, 18));
		frame.setTitle("\u4E2A\u4EBA\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 785, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 767, 215);
		frame.getContentPane().add(scrollPane);
		
		 table = new JTable();
		scrollPane.setViewportView(table);
		
		
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
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		List<PersonInfo> list = new ArrayList<>();
		PersonService personService = new PersonService();
		try {
			 list = personService.getAll(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 String[] tableHeads = new String[]{"id","Name","Sex","Phone","QQ","Work","Address"};
				  DefaultTableModel dtm = (DefaultTableModel)table.getModel();
				  dtm.setColumnIdentifiers(tableHeads);
				  for(int i = 0;i<list.size();i++){
				  Object[] rowData={list.get(i).getPersonId(),list.get(i).getPersonName(), list.get(i).getPersonSex(),list.get(i).getPersonPhone(), list.get(i).getPersonQq(),list.get(i).getPersonWork(),list.get(i).getPersonAddress()};
				  dtm.addRow(rowData);  
				  }
		
				  table.setModel(dtm);
				  
				  
				  JLabel lblId = new JLabel("id\u503C\u4E0D\u53EF\u4FEE\u6539");
					lblId.setForeground(Color.RED);
					lblId.setBounds(457, 254, 128, 18);
					lblId.setVisible(false);
					frame.getContentPane().add(lblId);
				
				  
					JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
					button.setFont(new Font("黑体", Font.PLAIN, 18));
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							PersonInfo personInfo =new PersonInfo();
							boolean b = false;
							String personName = null,personSex=null,personPhone=null,personQq=null,personWork=null,personAddress=null;
							int row = table.getSelectedRow();
							int col = table.getSelectedColumn();
							Object str1 =  dtm.getValueAt(row, 0);
							col =col-1;
							String str = textField.getText();
							if(col==-1){
								lblId.setVisible(true);
							}else if(str.isEmpty()){
								lblId.setText("此处不能为空");
								lblId.setVisible(true);
							}else {
								
							
							dtm.setValueAt(str, row, col);
							personInfo.setPersonId((Integer) str1);
							
							
							
							switch (col) {
							case 0:
								 personName = str;
								personInfo.setPersonName(personName);
								
								try {
									b = personService.update(personInfo,col);
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
									if(b==true){
										home home =new home();
										home.frame.setVisible(true);
										update.this.frame.dispose();
									}
								
							case 1:
								
								 personSex = str;
								 personInfo.setPersonSex(personSex);
								 try {
									b = personService.update(personInfo, col);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								 if(b==true){
									 home home =new home();
										home.frame.setVisible(true);
										update.this.frame.dispose();
									}
								 
								break;
							case 2:
								 personPhone = str;
								 personInfo.setPersonPhone(personPhone);
								try {
									b = personService.update(personInfo, col);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								 if(b==true){
									 home home =new home();
										home.frame.setVisible(true);
										update.this.frame.dispose();
									}
								 

								break;
							case 3:
								 personQq = str;
								 personInfo.setPersonQq(personQq);
									try {
										b = personService.update(personInfo, col);
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									 if(b==true){
										 home home =new home();
											home.frame.setVisible(true);
											update.this.frame.dispose();
										}
									 
								break;
							case 4:
								 personWork = str;
								 personInfo.setPersonWork(personWork);
									try {
										b = personService.update(personInfo, col);
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									 if(b==true){
										 home home =new home();
											home.frame.setVisible(true);
											update.this.frame.dispose();
										}
									 
								break;
							case 5:
								 personAddress = str;
								 personInfo.setPersonAddress(personAddress);
									try {
										b = personService.update(personInfo, col);
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									 if(b==true){
										 home home =new home();
											home.frame.setVisible(true);
											update.this.frame.dispose();
										}
									 
								break;
							default:
								break;
							}
						
							}
						}
					});
					button.setBounds(217, 302, 116, 40);
					frame.getContentPane().add(button);
					
					JLabel label = new JLabel("\u5F85\u4FEE\u6539\u7684\u503C\uFF1A");
					label.setBounds(221, 254, 90, 18);
					frame.getContentPane().add(label);
					
					textField = new JTextField();
					textField.setBounds(323, 251, 86, 24);
					frame.getContentPane().add(textField);
					textField.setColumns(10);
					
					JButton btnNewButton = new JButton("\u8FD4\u56DE");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							home home = new home();
							home.frame.setVisible(true);
							update.this.frame.dispose();
							
						}
					});
					btnNewButton.setFont(new Font("黑体", Font.PLAIN, 18));
					btnNewButton.setBounds(389, 304, 113, 40);
					frame.getContentPane().add(btnNewButton);
					
					JButton button_1 = new JButton("\u9000\u51FA");
					button_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							update.this.frame.dispose();
						}
					});
					button_1.setFont(new Font("黑体", Font.PLAIN, 18));
					button_1.setBounds(565, 302, 113, 40);
					frame.getContentPane().add(button_1);
					
					
					
					
					
					
					
	}
}
