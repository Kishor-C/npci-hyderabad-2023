package com.npci.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.npci.dao.ProfileDao;
import com.npci.dao.ProfileService;

public class TestServiceClient {
	public static void main(String[] args) {
		// this acts like a business layer
		// Below code initializes the spring container to create all the objects
		// based on the <bean> configuration
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// getting the dao object - abstracting the dao implementation
//		ProfileDao profileDao = (ProfileDao)context.getBean("dao");
//		System.out.println(profileDao.greet("Alex", "telugu"));
//		System.out.println(profileDao.greet("Alex", "kannada"));
//		System.out.println(profileDao.greet("Alex", "english"));
//		System.out.println(profileDao.greet("Alex", "tamil"));
		// this code comes in the controller
		ProfileService srv = (ProfileService)context.getBean("service");
		System.out.println(srv.greet("Brad", "english"));
	}
}
