package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlconnection {

	// JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/addressbook?useSSL=false";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";
    
    
    public static Connection getcon(){
    Connection conn = null;
    try{
        // 注册 JDBC 驱动
        Class.forName("com.mysql.jdbc.Driver");
    
        // 打开链接
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
    }catch(SQLException se){
        // 处理 JDBC 错误
        se.printStackTrace();
    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
	}
	return conn;
    }

}


