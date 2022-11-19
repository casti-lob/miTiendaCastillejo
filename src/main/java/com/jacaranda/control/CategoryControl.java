package com.jacaranda.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.jacaranda.Category;
import com.jacaranda.ConnectionDAO;

public class CategoryControl {
	
	public static Category getCategoryforName(String name) {
		ConnectionDAO conex = new ConnectionDAO();
		Session session= conex.getSession();
		Category c = new Category();
		Query<Category> query=session.createQuery("SELECT u FROM com.jacaranda.Category u WHERE u.name LIKE'"+name+"'");
		try {
			c = query.getSingleResult();
			}catch (Exception e) {
				c=null;
			}
		return c;
		
	}
	
	
}
