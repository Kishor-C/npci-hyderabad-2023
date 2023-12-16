package com.npci.springbootdb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactId;
	private String name;
	private long phone;
	// a foreign key reference property
	@Column(name = "profile_ref")
	private int profileRef;  
	/*
	 *  sometimes spring boot may not detect the columns when you use camel case - 
	 *  hence you must use physical naming strategy
	 */
	
	// generate getters & setters
	
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getProfileRef() {
		return profileRef;
	}
	public void setProfileRef(int profileRef) {
		this.profileRef = profileRef;
	}
	
}
