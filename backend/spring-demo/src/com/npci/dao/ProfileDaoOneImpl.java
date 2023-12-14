package com.npci.dao;

public class ProfileDaoOneImpl implements ProfileDao {
	
	private Datasource data; // generate only setter method
		
	public void setData(Datasource data) {
		this.data = data;
	}

	@Override
	public String greet(String name, String language) {
		System.out.println("Username = "+data.getUsername()
		+", Password = "+data.getPassword()+", greet() in ImplOne");
		return "Hello "+name;
	}

}
