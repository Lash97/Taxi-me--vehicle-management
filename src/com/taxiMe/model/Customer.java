package com.taxiMe.model;

public class Customer {
	private int id;
	private String name;
	private String mail;
	private int telephone;
	private String gender;
	private String userName;
	private String password;
	private String address;
	public Customer() {
		super();
	}
	public Customer(int id, String name, String mail, int telephone, String gender, String userName, String password, String address) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.telephone = telephone;
		this.gender = gender;
		this.userName = userName;
		this.password = password;
		this.address = address;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
