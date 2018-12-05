package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.model.User;


public class UserDao {
	
	public List<User> getAll() throws SQLException{
		ArrayList<User> list = new ArrayList<>();
		Connection connection  = sqlconnection.getcon();
		Statement statement =  connection.createStatement();
		String sql = "select * from user;";
		ResultSet rSet = statement.executeQuery(sql);
		while(rSet.next()){
			Integer userId = rSet.getInt("userId");
			String userName = rSet.getString("userName");
			String passWord = rSet.getString("passWord");
			User user = new User();
			user.setUserId(userId);
			user.setUserName(userName);
			user.setPassWord(passWord);
			list.add(user);
		}
		
		return list;
	}


	public static boolean register(User user) throws SQLException {
		Connection connection  = sqlconnection.getcon();
		Statement statement =  connection.createStatement();
		String sql = "INSERT INTO user(userName,passWord) VALUES('"+user.getUserName()+"','"+user.getPassWord()+"');";
		boolean b = statement.execute(sql);
		if(b==false){
		return true;
		}
		return false;
	}
}
