package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Servlets have the three key methods in their lifecycle:
	 * init(): which instantiates the servlet if it isn't already.
	 * If the servlet IS instantiated, this method is skipped.
	 * Servlets are singletons
	 */
	public void init() throws ServletException {
		System.out.println(this.getServletName() + " :INSTANTIATED!");
		super.init();
	}
	
	/*
	 * The next method we write is the service() method which will be used
	 * for the business logic and populating the response. When using
	 * servlets normally, you should NEVER EVER override the service()
	 * method unless you know exactly what you are doing
	 */
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException{
		System.out.println(this.getServletName() + ": Service Called!");
		/*
		 * In order to populate the response, we need to write to it.
		 * The way we write to a response is with its own PrintWriter
		 * object
		 */
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//Calling out.println starts populating the response.
		out.println("<h3 style='color:green'>Hello World!</h3>");
		
		//add a 'back' button
		out.println(
				"<hr><input type = 'button' value='GO BACK' "
				+ "onclick='goBack()'>"
				+ "<script>function goBack(){window.history.back();}"
				+ "</script>"
				);
		//At the end of service() response and request are sent back
		//to the web container
	}
	
	/*
	 * In the event of enough idle time passing for the servlet, or the
	 * server being shut down, the destroy method is invoked by the WC
	 * which preps the servlet for garbage collection
	 */
	
	public void destroy() {
		System.out.println(this.getServletName() + ": DESTROY CALLED!");
		super.destroy();
	}
	

}
