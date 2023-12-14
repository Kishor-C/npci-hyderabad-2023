package com.npci;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TestHibernateClient {

	public static void main(String[] args) {
		// in real time you will get the object through factory pattern
		StudentDao dao = new StudentDaoOrmImpl();
		System.out.println("Enter options 1: FindAll 2: Store 3: Find By Id:-");
		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();
		if(option == 1) {
			List<Student> students = dao.findAll();
			students.forEach(x -> System.out.println(x));
		}
		if(option == 2) {
			System.out.println("Enter roll no, name and dob in 'yyyy-MM-dd' format separated by space");
			// below code takes input from scanner, we don't  have nextLocalDate(), we must use next()
			// for date & pass to the LocalDate.parse()
			Student student = new Student(scan.nextInt(), scan.next(), LocalDate.parse(scan.next()));
			int key = dao.save(student);
			System.out.println("Stored with a roll no: "+key);
		}
		if(option == 3) {
			System.err.println("NOT IMPLEMENTED YET!");
		}
		scan.close();
	}

}
