package com.npci;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class StudentDaoOrmImpl implements StudentDao {

	@Override
	public int save(Student student) {
		int key = 0; // ORM returns the primary key value while storing
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction(); //need for DML - import from org.hibernate
		key = (int)session.save(student); // saves & returns Serializable id hence convert to int
		transaction.commit(); // commits the save
		session.close();
		factory.close();
		return key;
	}

	@Override
	public List<Student> findAll() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		String SELECT_ALL = "select s from Student s";
		// import org.hibernate.query.Query
		Query<Student> query = session.createQuery(SELECT_ALL, Student.class);
		// below method takes care of converting SQL results to Java objects & adds them in a List<T>
		List<Student> list = query.getResultList();
		session.close();
		factory.close();
		return list; // client uses the List to process
	}

	@Override
	public Student find(int rollNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
