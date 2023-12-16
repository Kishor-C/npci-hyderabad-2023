package com.npci.springbootdb.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {
	// create properties id, name, password, birthday, phone
	@Id // import jakarta.persistence
	@GeneratedValue(strategy = GenerationType.IDENTITY) // jakarta.persistence.GeneratedValue
	private int id;
	// other properties name, password, birthday, phone
	private String name;
	private String password;
	private LocalDate birthday;
	private long phone;
	
	// this joins profile & contact table by matching pk = fk with the help of @JoinColumn
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_ref")
	private List<Contact> contacts; // generate getters & setters
	
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	// generate 2 constructors - setters, getters
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(int id, String name, String password, LocalDate birthday, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}
