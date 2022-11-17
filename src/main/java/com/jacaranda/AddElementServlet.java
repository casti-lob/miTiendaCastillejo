package com.jacaranda;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/AddElementServlet")
public class AddElementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Category c = new Category();
		
		String nameElement = request.getParameter("name");
		String descriptionElement=request.getParameter("description");
		int price=Integer.parseInt(request.getParameter("price")) ;
		String category= request.getParameter("category");
		
		Element element= new Element();
		
		try {
			element.setName_ele(nameElement);
			element.setDescription_ele(descriptionElement);
			element.setPrice(price);
			
			c= CategoryControl.getCategoryforName(category);
			
			if(c!=null) {
				element.setCateg(c);
				
				if(ElementControl.saveElement(element)) {
					PrintWriter out = response.getWriter();
					out.println("<html><body>");
					out.println("<h1>Articulo añadido</h1>");
					out.println("<a href='/PeliculasCastillejo/html/Index.html'>Atras</a>");
					out.println("</body></html>");
				}
			}else {
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				out.println("<h1>Categoria no encontrada</h1>");
				out.println("<a href='/PeliculasCastillejo/html/Index.html'>Atras</a>");
				out.println("</body></html>");
			}
			
		} catch (ElementException e) {
			// TODO Auto-generated catch block
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>Error</h1>");
			out.println("<h1>"+e.getMessage()+"</h1>");
			out.println("<a href='/PeliculasCastillejo/html/Index.html'>Atras</a>");
			out.println("</body></html>");
			
		}
		
		
		
		
		
		
		
		
		
	}
	
}
