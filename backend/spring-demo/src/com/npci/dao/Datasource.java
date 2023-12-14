package com.npci.dao;

public class Datasource {
	private String username;
	private String password;
	// 2 constructors - setters & getters
	public Datasource(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Datasource() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
