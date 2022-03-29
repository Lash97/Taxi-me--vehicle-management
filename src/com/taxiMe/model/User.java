package com.taxiMe.model;

public class User {
	private int id;
	private String userName;
	private String password;
	private String userType;
	public User() {
		super();
	}
	public User(int id,String userName, String password, String userType) {
		super();
		
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
