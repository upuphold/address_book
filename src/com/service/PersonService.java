package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.PersonDao;
import com.model.PersonInfo;

public class PersonService {

	public boolean addPerson(PersonInfo personInfo) throws SQLException {
		
		PersonDao personDao =new PersonDao();
		boolean b = personDao.addPerson(personInfo);
		if(b==true){
		return true;
		}
		return false;
	}

	public List<PersonInfo> getAll(Integer id) throws SQLException {
		PersonDao personDao = new PersonDao();
		List<PersonInfo> list = personDao.getAll(id);
		return list;
		
	}

	public boolean deletePerson(int row) throws SQLException {
		PersonDao personDao =new PersonDao();
		
		boolean b = personDao.deletePerson(row);
		if(b==true){
			return true;
		}
		return true;
	}

	public boolean update(PersonInfo personInfo, int col) throws SQLException {
		PersonDao personDao = new PersonDao();
		boolean b = false;
		b = personDao.update(personInfo,col);
		if(b==true){
			return true;
		}
		return false;
	}

	

}
