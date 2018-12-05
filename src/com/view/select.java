package com.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class select {

	 JFrame frame;
	 private JScrollPane scrollPane;
	 private JTable table;
	 private JButton btnNewButton;
	 private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					select window = new select();
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
	public select() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("\u4E2A\u4EBA\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 809, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	
			
		JButton button = new JButton("\u67E5\u8BE2");
		button.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<PersonInfo> list = new ArrayList<>();
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
				PersonService personService = new PersonService();
				try {
					 list = personService.getAll(id);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				 String[] tableHeads = new String[]{"Name","Sex","Phone","QQ","Work","Address"};
						  DefaultTableModel dtm = (DefaultTableModel)table.getModel();
						  dtm.setColumnIdentifiers(tableHeads);
						  for(int i = 0;i<list.size();i++){
						  String[] rowData={list.get(i).getPersonName(), list.get(i).getPersonSex(),list.get(i).getPersonPhone(), list.get(i).getPersonQq(),list.get(i).getPersonWork(),list.get(i).getPersonAddress()};
						  dtm.addRow(rowData);  
						  }
				table.setModel(dtm);
				button.setEnabled(false);
				
			}
		});
		button.setBounds(136, 297, 113, 40);
		frame.getContentPane().add(button);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 791, 198);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home home =new home();
				home.frame.setVisible(true);
				select.this.frame.dispose();
			}
		});
		btnNewButton.setBounds(363, 297, 113, 40);
		frame.getContentPane().add(btnNewButton);
		
		button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select.this.frame.dispose();
			}
		});
		button_1.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		button_1.setBounds(609, 297, 113, 40);
		frame.getContentPane().add(button_1);
	}
}
