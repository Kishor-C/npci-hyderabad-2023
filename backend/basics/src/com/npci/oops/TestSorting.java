package com.npci.oops;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestSorting {
	public static void main(String[] args) {
		Set<String> stringSet = new TreeSet<>(); // sorts automatically if they are simple types
		stringSet.add("ABC");
		stringSet.add("abc");
		stringSet.add("Abc");
		stringSet.add("123");
		System.out.println(stringSet);
		System.out.println("------- Adding Complex Types -----");
		// id in descending order
		Comparator<User> c1 = (x, y) -> Integer.compare(y.getUserId(), x.getUserId());
		// name in ascending order
		Comparator<User> c2 = (x, y) -> x.getName().compareTo(y.getName());
		// dob in ascending order
		Comparator<User> c3 = (x, y) -> x.getDob().compareTo(y.getDob());
		Set<User> userSet = new TreeSet<>( c3 );
		userSet.add(new User(88, "Alex", LocalDate.parse("2000-10-25")));
		userSet.add(new User(77, "Brad", LocalDate.parse("2002-11-25")));
		userSet.add(new User(99, "David", LocalDate.parse("1999-11-25")));
		userSet.add(new User(66, "Charles", LocalDate.parse("1998-10-20")));
		
		for(User user : userSet) {
			System.out.println(user);
		}
		
	}
}
