package com.npci;

import java.util.List;

public interface StudentDao {

	int save(Student student);

	List<Student> findAll();

	Student find(int rollNo);

}