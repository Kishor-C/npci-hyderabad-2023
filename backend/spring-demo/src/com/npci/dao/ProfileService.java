package com.npci.dao;

public class ProfileService {
	
	private ProfileDao profileDao;

	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}
	
	public String greet(String name, String language) {
		return profileDao.greet(name, language);
	}
}
/*
 *  Configure the bean for ProfileService
 *  From the main getBean() of ProfileService instead of ProfileDao
 *   and call the greet() method from ProfileService
 */
