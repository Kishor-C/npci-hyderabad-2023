package com.npci;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoJdbcImpl implements StudentDao {
	@Override
	public int save(Student student) { 
		int status = 0;
		try {
			Connection connection = DBUtil.getConnection();
			String INSERT_QUERY = "insert into student values(?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
			statement.setInt(1, student.getRollNo());
			statement.setString(2, student.getName());
			statement.setDate(3, Date.valueOf(student.getDob())); // import java.sql.Date
			status = statement.executeUpdate();
			DBUtil.close(connection, statement, null);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status; // change it later
	} 
	@Override
	public List<Student> findAll() {
		List<Student> students = new ArrayList<>();
		// select query must be used here 
		try {
			Connection connection = DBUtil.getConnection(); //1st get the connection
			String SELECT_QUERY = "select * from student";//this query must be passed to PreparedStatement
			PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
			ResultSet result = statement.executeQuery(); // all the records are obtained
			while(result.next()) {
				// initialize student & add it to the List<Student>
				// toLocalDate() converts java.sql.Date to LocalDate
				Student student = new Student(result.getInt("roll_no"), 
						result.getString(2), result.getDate("dob").toLocalDate());
				students.add(student); // add the initalized student to the list
			}
			// closing the resources
			DBUtil.close(connection, statement, result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return students; // change it later
	}
	@Override
	public Student find(int rollNo) {
		return null; // change it later
	}
}
