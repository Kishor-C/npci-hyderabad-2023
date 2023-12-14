package com.npci.dao;

public class ProfileDaoTwoImpl implements ProfileDao {
	private Datasource data; // generate only setter method
	
	public void setData(Datasource data) {
		this.data = data;
	}
	
	@Override
	public String greet(String name, String language) {
		System.out.println("Username = "+data.getUsername()
		+", Password = "+data.getPassword()+", greet() in ImplTwo");
		language = language.toLowerCase();
		switch(language) {
		case "telugu": return "Swagatham "+name;
		case "kannada": return "Namaskara "+name;
		case "hindi": return "Namaskar "+name;
		default : return "Hello "+name;
		}
		
	}

}
