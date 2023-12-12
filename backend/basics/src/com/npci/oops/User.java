package com.npci.oops;
// java bean with userid, name, dob setters & getters

import java.time.LocalDate;
import java.util.Objects;

public class User implements Comparable<User> {
	private int userId;
	private String name;
	private LocalDate dob; // java.util.Date is not recommended
	// create default & argument constructors, setters & getters, toString
	public User() {
		super();
	}
	public User(int userId, String name, LocalDate dob) {
		super();
		this.userId = userId;
		this.name = name;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", dob=" + dob + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return userId == other.userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	@Override
	public int compareTo(User o) {
		return Integer.compare(userId, o.getUserId()); // 0 or +ve or -ve
	}
}
