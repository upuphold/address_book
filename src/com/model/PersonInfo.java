package com.model;

public class PersonInfo {
	private Integer userId;
	private Integer personId;
	private String personName;
	private String personSex;
	private String personPhone;
	private String personQq;
	private String personWork;
	private String personAddress;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonSex() {
		return personSex;
	}
	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}
	public String getPersonPhone() {
		return personPhone;
	}
	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}
	public String getPersonQq() {
		return personQq;
	}
	public void setPersonQq(String personQq) {
		this.personQq = personQq;
	}
	public String getPersonWork() {
		return personWork;
	}
	public void setPersonWork(String personWork) {
		this.personWork = personWork;
	}
	public String getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}
	@Override
	public String toString() {
		return "PersonInfo [userId=" + userId + ", personId=" + personId + ", personName=" + personName + ", personSex="
				+ personSex + ", personPhone=" + personPhone + ", personQq=" + personQq + ", personWork=" + personWork
				+ ", personAddress=" + personAddress + "]";
	}
		

	
	
	
}
