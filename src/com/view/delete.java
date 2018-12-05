package com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.model.PersonInfo;
import com.service.PersonService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class delete {

	 JFrame frame;
	 private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					delete window = new delete();
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
	public delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("\u4E2A\u4EBA\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 754, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 744, 237);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u5F85\u5220\u9664\u7684\u884C\uFF01\uFF01\uFF01");
		label.setBounds(263, 260, 175, 18);
		frame.getContentPane().add(label);
		label.setVisible(false);
		label.setForeground(Color.RED);
		

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
		
		 String[] tableHeads = new String[]{"Id","Name","Sex","Phone","QQ","Work","Address"};
				  DefaultTableModel dtm = (DefaultTableModel)table.getModel();
				  dtm.setColumnIdentifiers(tableHeads);
				  for(int i = 0;i<list.size();i++){
				  Object[] rowData={list.get(i).getPersonId(),list.get(i).getPersonName(), list.get(i).getPersonSex(),list.get(i).getPersonPhone(), list.get(i).getPersonQq(),list.get(i).getPersonWork(),list.get(i).getPersonAddress()};
				  dtm.addRow(rowData);  
				  }
		
				  table.setModel(dtm);
		
		
		
		
		
		
		
		JButton button = new JButton("\u5220\u9664");
		button.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				boolean b =false;
				if(row==-1){
					label.setVisible(true);
				}else {
					PersonService personService = new PersonService();
				  try {
					Object string = dtm.getValueAt(row, 0);
					b = personService.deletePerson((int) string);
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
					
				}
				if(b==true){
					dtm.removeRow(row);	
					label.setVisible(false);
				}	
			}
		});
		button.setBounds(155, 302, 113, 40);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home home = new home();
				home.frame.setVisible(true);
				delete.this.frame.dispose();
			}
		});
		button_1.setBounds(356, 302, 113, 40);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete.this.frame.dispose();
			}
		});
		button_2.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		button_2.setBounds(552, 304, 113, 40);
		frame.getContentPane().add(button_2);
		
	

		
	}
}
