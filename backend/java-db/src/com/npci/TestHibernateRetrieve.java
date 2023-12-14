package com.npci;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernateRetrieve {
	public static void main(String[] args) {
		// performing retrieving an entity
		// Configuration -> SessionFactory -> Session.get(EntityName.class, primaryKeyValue)
		
		// import from org.hibernate.cfg.Configuration - call configure() that loads hibernate.cfg.xml
		Configuration configuration = new Configuration().configure();
		// build a SessionFactory that creates connection pool: configuration.buildSessionFactory()
		SessionFactory factory = configuration.buildSessionFactory();
		// open Session : import from org.hibernate.Session : provides save(), update(), get() 
		Session session = factory.openSession();
		//retrieve a Student: internally takes care of generating query & type conversion
		Student student = session.get(Student.class, 2); // gets the student having roll_no = value
		System.out.println(student);
		
		
		// close the Session & SessionFactory
		session.close();
		factory.close();
	}
}
