package com.dto;

public class Admin {
	private String name;
	private int id;
	private String email;
	private String phoneNo;
	private String password;
	private int revenue;
	
	public Admin(String name, int id, String email, String phoneNo, String password,int revenue) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.revenue=revenue;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	
}
