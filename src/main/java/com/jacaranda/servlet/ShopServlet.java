package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.Cart;
import com.jacaranda.Element;
import com.jacaranda.Sales;
import com.jacaranda.control.ElementControl;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessionsa = request.getSession();
		String login = (String) sessionsa.getAttribute("login");
		String nick = (String) sessionsa.getAttribute("user");
		Cart cart = (Cart) sessionsa.getAttribute("cart");
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		Element e = ElementControl.getElement(id);
		
		Sales sales = new Sales();
		
		
		sales.setMysales(e);
		response.sendRedirect("LoginServlet");
	}

}
