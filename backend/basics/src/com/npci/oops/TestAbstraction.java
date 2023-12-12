package com.npci.oops;
// interface having some methods
interface DB {
	void store();
}
//DB implementation using JDBC
class JdbcImpl implements DB {
	@Override
	public void store() {
		System.out.println("store() is implemented using JDBC");
	}	
}
// DB implementation using JDBC
class HibernateImpl implements DB {
	@Override
	public void store() {
		System.out.println("store() is implemented using Hibernate");
	}	
}
// Factory pattern - to abstract the object creation
class ObjectFactory {
	public static DB getInstance() {
		return new HibernateImpl();
	}
}
// class name must begin with capital letters & use camel case for multiple words ex: HelloWorld
public class TestAbstraction {
	// this must be treated as the client program
	public static void main(String[] args) {
		//1st approach - client knows which object to create
		// not recommended because it makes the client code tightly coupled
		DB db = new HibernateImpl();
		db.store();
		//2nd approach - client doesn't know which object it gets
		DB db2 = ObjectFactory.getInstance();
		db2.store();
	}
}
