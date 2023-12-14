package com.npci;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		// build a SessionFactory that creates connection pool: configuration.buildSessionFactory()
		SessionFactory factory = configuration.buildSessionFactory();
		return factory;
	}
	
}
