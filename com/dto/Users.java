package com.dto;

public class Users {
	private String userName;
	private int id;
	private String email;
	private String phoneNo;
	private int wallet;
	private String password;
	private String enpassword;
	
	public Users(String userName, int id, String email, String phoneNo, int wallet, String password,
			String enpassword) {
		super();
		this.userName = userName;
		this.id = id;
		this.email = email;
		this.phoneNo = phoneNo;
		this.wallet = wallet;
		this.password = password;
		this.enpassword = enpassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getWallet() {
		return wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnpassword() {
		return enpassword;
	}
	public void setEnpassword(String enpassword) {
		this.enpassword = enpassword;
	}
	
}
