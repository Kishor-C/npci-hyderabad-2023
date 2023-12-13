package com.npci;

import java.util.List;

public class TestClient {
	public static void main(String[] args) {
		// you can create menu options like
		// 1: store 2: find all 3: find by id 4: update 5: exit
		// the below statement is tightly coupled code because we are not using interface & factory
		// pattern
		StudentDaoJdbcImpl jdbc = new StudentDaoJdbcImpl();
		List<Student> list = jdbc.findAll();
		
		list.forEach(s -> System.out.println(s));
		System.out.println(" ***** ------------ *****");
	}
}
