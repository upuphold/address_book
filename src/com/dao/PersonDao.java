package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.PersonInfo;

public class PersonDao {

	public boolean addPerson(PersonInfo personInfo) throws SQLException {
		
		Connection connection  = sqlconnection.getcon();
		Statement statement =  connection.createStatement();
		String sql = "INSERT INTO personinfo(userId,personName,personSex,personPhone,personQq,personWork,personAddress) VALUES('"+personInfo.getUserId()+"','"+personInfo.getPersonName()+"','"+personInfo.getPersonSex()+"','"+personInfo.getPersonPhone()+"','"+personInfo.getPersonQq()+"','"+personInfo.getPersonWork()+"','"+personInfo.getPersonAddress()+"');";
		boolean b = statement.execute(sql);
		if(b==false){
		return true;
		}
		return false;
	}

	public List<PersonInfo> getAll(Integer id) throws SQLException {
		List<PersonInfo> list = new ArrayList<>();
		
		Connection connection  = sqlconnection.getcon();
		Statement statement =  connection.createStatement();
		String sql = "select * from personinfo where userId = '"+id+"';";
		ResultSet rSet = statement.executeQuery(sql);
		while(rSet.next()){
			Integer Id = rSet.getInt("personId");
			String Name = rSet.getString("personName");
			String Sex = rSet.getString("personSex");
			String Phone = rSet.getString("personPhone");
			String Qq = rSet.getString("personQq");
			String Work = rSet.getString("personWork");
			String Address = rSet.getString("personAddress");
			PersonInfo personInfo = new PersonInfo();
			personInfo.setPersonId(Id);
			personInfo.setPersonName(Name);
			personInfo.setPersonSex(Sex);
			personInfo.setPersonPhone(Phone);
			personInfo.setPersonQq(Qq);
			personInfo.setPersonWork(Work);
			personInfo.setPersonAddress(Address);
			list.add(personInfo);

		}
		
		return list;
		
	}

	public boolean deletePerson(int row) throws SQLException {
		Connection connection  = sqlconnection.getcon();
		Statement statement =  connection.createStatement();
		String sql = "delete from personinfo where personId='" + row + "'";
		boolean b = statement.execute(sql);
		if(b==false){
			return true;
		}else {
			return false;
		}
		
		
	}

	public boolean update(PersonInfo personInfo, int col) throws SQLException {
		Connection connection  = sqlconnection.getcon();
		Statement statement =  connection.createStatement();
		String sql = null;
		switch (col) {
		case 0:
			sql = "update  personinfo set personName = '"+personInfo.getPersonName()+"'where personId='" + personInfo.getPersonId() + "'";
			break;
		case 1:
			sql = "update  personinfo set personSex = '"+personInfo.getPersonSex()+"'where personId='" + personInfo.getPersonId() + "'";
			break;
		case 2:
			sql = "update  personinfo set personPhone = '"+personInfo.getPersonPhone()+"'where personId='" + personInfo.getPersonId() + "'";
			break;
		case 3:
			sql = "update  personinfo set personQq = '"+personInfo.getPersonQq()+"'where personId='" + personInfo.getPersonId() + "'";
			break;
		case 4:
			sql = "update  personinfo set personWork = '"+personInfo.getPersonWork()+"'where personId='" + personInfo.getPersonId() + "'";
			break;
		case 5:
			sql = "update  personinfo set personAddress = '"+personInfo.getPersonAddress()+"'where personId='" + personInfo.getPersonId() + "'";
			break;

		default:
			break;
		}
	
		boolean b = statement.execute(sql);
		if(b==false){
			return true;
		}else {
			return false;
		}
	}

}
