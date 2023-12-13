package com.npci;

import java.time.LocalDate;
import java.util.List;

public class TestClient {
	public static void main(String[] args) {
		// you can create menu options like
		// 1: store 2: find all 3: find by id 4: update 5: exit
		// the below statement is tightly coupled code because we are not using interface & factory
		// pattern
		StudentDaoJdbcImpl jdbc = new StudentDaoJdbcImpl();
		
		//storing a Student
		Student student = new Student(16, "Virat", LocalDate.parse("1988-10-25"));
		int status = jdbc.save(student);
		if(status > 0) 
			System.out.println("Student is stored....");
		else 
			System.err.println("Student store failed!");
		// finding all records
		List<Student> list = jdbc.findAll();
		
		list.forEach(s -> System.out.println(s));
		System.out.println(" ***** ------------ *****");
	}
}
