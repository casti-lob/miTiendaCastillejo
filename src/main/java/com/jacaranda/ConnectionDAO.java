package com.jacaranda;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConnectionDAO {
	private  StandardServiceRegistry sr;
	private  SessionFactory sf;
	private  Session session;
	
	
		
	public ConnectionDAO() {
		super();
		this.sr = new StandardServiceRegistryBuilder().configure().build();
		this.sf =new MetadataSources(sr).buildMetadata().buildSessionFactory();
		this.session = session;
	}

	public  Session getSession() throws HibernateException {
		this.session = sf.openSession();
		return session;
	}
	
	public  void closeSession() {
		this.session.close();
	}
	
	

}
