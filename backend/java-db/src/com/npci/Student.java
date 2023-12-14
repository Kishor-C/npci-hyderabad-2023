package com.npci;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student") // optional when class name & table name is same
public class Student {
	
	@Id // marking primary key column
	@Column(name = "roll_no")
	// generator name can be any thing ex: abc, postgres an so on
	@GeneratedValue(generator = "postgres_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "postgres_seq", sequenceName = "student_seq", allocationSize = 1)
	private int rollNo;
	
	@Column(name = "name") // optional when property & column names are same
	private String name;
	@Column(name = "dob") // optional
	private LocalDate dob;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rollNo, String name, LocalDate dob) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", dob=" + dob + "]";
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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
