package com.npci.springbootdemo.beans;

import java.time.LocalDate;

public class Profile {
	private int id;
	private String name;
	private LocalDate dob;
	// setters & getters - 2 constructors
	// Note: When you are using framework default constructor must be present
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(int id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
}
