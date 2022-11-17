package com.jacaranda;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		//Datos user
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String nick =request.getParameter("nick").trim();
		String date = request.getParameter("date");
		String gender = request.getParameter("gender");
		boolean admin = false;
		boolean sex=true;
		if(gender.equals("Masculino")) {
			sex=false;
		}
		//Encriptamos contrase�a
		String passwordEndcript = DigestUtils.md5Hex(password);
		//Inserci�n de datos
		
		try {
			Users user = new Users();
			Users oldUser = UserControl.getUser(nick);
			if(oldUser==null) {
				user.setPassword(passwordEndcript);
				user.setName(name);
				user.setNick(nick);
				user.setDate(date);
				user.setGender(sex);
				user.setAdmin(admin);
				UserControl.addUser(user);
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				out.println("<h1>Usuario creado </h1>");
				out.println("<h1>Bienvenido </h1>");
				out.println("<a href='miTiendaCastillejo/html/Index.html'>Atras</a>");
				out.println("</body></html>");
			}else {
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				out.println("<h1>Error nick de usuario ya existente </h1>");

				out.println("<a href='/miTiendaCastillejo/html/Index.html'>Atras</a>");
				out.println("</body></html>");
			}
			
			
			
			
		} catch (UserException e) {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>Error </h1>");
			out.println("<h3>"+e.getMessage()+"</h3>");
			out.println("<a href='/miTiendaCastillejo/html/Index.html'>Atras</a>");
			out.println("</body></html>");
			
		}
		
	}

}
