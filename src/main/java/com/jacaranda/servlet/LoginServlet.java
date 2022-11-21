package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;

import com.jacaranda.ConnectionDAO;
import com.jacaranda.Element;
import com.jacaranda.Users;
import com.jacaranda.control.ElementControl;
import com.jacaranda.control.UserControl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConnectionDAO c = new ConnectionDAO();
		Session session= c.getSession();
		
		
		response.setContentType("text/html");
		//Datos del formulario y creaci�n de usuario
		String nick = request.getParameter("nick").trim();
		String password=request.getParameter("password").trim();
		//Encriptamos contrase�a
		String passwordEndcript = DigestUtils.md5Hex(password);
		
		Boolean login = UserControl.loginUser(nick, passwordEndcript);
		
		if(login !=false){
			//Validamos o no al usuario
				Users user = UserControl.getUser(nick);
				
				HttpSession sesion = request.getSession();
				sesion.setAttribute("login","true");
				sesion.setAttribute("user",user.getName());
				PrintWriter out = response.getWriter();
				 
				
				out.println("<html><body> <div class='card' align='center'>");
				//Bienvenida al usuario
				out.println("<h1>Bienvenido "+user.getName()+" </h1>");
				out.println("<h1>Lista de articulos   <a href='html/AddElement.html'>Anadir articulo</a>");
				out.println("<a href='html/Index.html'>Atras</a>");
				//Tabla de art�culos
				
				out.println("<table border=\"1px\">\r\n"
						+ "    <tr>\r\n"
						+ "        <td>\r\n"
						+ "            Nombre\r\n"
						+ "        </td>\r\n"
						+ "        <td>\r\n"
						+ "            Descripci�n\r\n"
						+ "        </td>\r\n"
						+ "        <td>\r\n"
						+ "            Precio\r\n"
						+ "        </td>\r\n"
						+ "        <td>Cantidad</td>\r\n"
						+"			<td>Add</td></tr>"
						        );
				
				List<Element> element = ElementControl.getListElement();
				for(Element i: element) {
					out.println("<tr><td>"+i.getName_ele()+"</td>\r\n"
							+ "<td>"+i.getDescription_ele()+"</td>\r\n"
							+ "<td>"+i.getPrice()+"</td>");
					out.println("<td><input type='number' placeholder='cantidad' min='1'></td>");
					out.println("<td><button>Add Card</button></td></tr>");		
					
				}
				out.println("</table>");
				
				out.println("</div></body></html>");
			}else{
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				out.println("<h1>Error al loguearte</h1>");
				out.println("<a href='html/Index.html'>Atras</a>");
				out.println("</body></html>");
			}
	}

}
