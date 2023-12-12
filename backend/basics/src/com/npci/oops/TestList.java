package com.npci.oops;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestList {
	public static void main(String[] args) {
		// storing users in a List
		//List<User> users = new ArrayList<>();
		Set<User> users = new HashSet<>();
		users.add(new User(100, "Zaheer", LocalDate.of(2002, 12, 22) )); 
		users.add(new User(88, "Yuvraj", LocalDate.parse("2001-11-24"))); // ISO format yyyy-MM-dd
		users.add(new User(99, "Alex", LocalDate.parse("2003-09-25"))); // ISO format yyyy-MM-dd
		users.add(new User(99, "Alex", LocalDate.parse("2003-09-25"))); 
		
		System.out.println(users);
		System.out.println("-----------------------------");
		//using for to iterate the Collection
		for(User u : users) {
			System.out.println(u);
		}
		// adding simple values to the Set
		Set<String> strings = new HashSet<>();
		strings.add("test");
		strings.add("test");
		System.out.println("-------------------");
		System.out.println(strings);
	}
}
