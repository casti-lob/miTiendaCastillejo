package com.jacaranda.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.jacaranda.ConnectionDAO;
import com.jacaranda.Element;

public class ElementControl {
	
	//Obtención de un elemento específico
	public static Element getElement(int id) {
		ConnectionDAO c = new ConnectionDAO();
		Session session= c.getSession();
		Element element = (Element) session.get(Element.class, id);
		return element;
	}
	//Obtencion lista de elementos
	public static List<Element> getListElement(){
		ConnectionDAO c = new ConnectionDAO();
		Session session= c.getSession();
		Query<Element> query=session.createQuery("SELECT e FROM com.jacaranda.Element e");
		List<Element> element = (List<Element>) query.getResultList();
		return element;
	}
	
	public static boolean saveElement(Element element) {
		boolean add = false;
		ConnectionDAO c = new ConnectionDAO();
		Session session= c.getSession();
		try {
		session.getTransaction().begin();
		session.save(element);
		session.getTransaction().commit();
		add=true;
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return add;
	}
	
	public static void updateElement(Element element) {
		ConnectionDAO c = new ConnectionDAO();
		Session session= c.getSession();
		try {
		session.getTransaction().begin();
		session.update(element);
		session.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteElement(Element element) {
		ConnectionDAO c = new ConnectionDAO();
		Session session= c.getSession();
		try {
			session.getTransaction().begin();
			session.delete(element);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
