package com.jacaranda.control;


import org.hibernate.query.Query;

import com.jacaranda.ConnectionDAO;
import com.jacaranda.Users;

import org.hibernate.Session;

public class UserControl {
	
	public UserControl() {
		
	}
	

	public static boolean loginUser(String nick, String password) {
		boolean valid = false;
		ConnectionDAO c = new ConnectionDAO();
		Session session= c.getSession();
		Users u =(Users) session.get(Users.class,nick);
		if(u != null && password.equals(u.getPassword())) {
			valid = true;
			}
		return valid;
		
	}
	
	public static Users getUser(String nick) {
		ConnectionDAO c = new ConnectionDAO();
		Session session= c.getSession();
		Users u =(Users) session.get(Users.class,nick);
		return u;
	}
	
	public static boolean addUser(Users user) {
		boolean add = false;
		ConnectionDAO c = new ConnectionDAO();
		Session session= c.getSession();
			try {
				session.getTransaction().begin();
				session.save(user);
				session.getTransaction().commit();
				add=true;
			} catch (Exception e) {
				
				System.out.println(e);
			}
	
		return add;
	}
	
	
}
