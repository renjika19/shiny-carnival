package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.services.OwnerService;
import com.revature.util.HtmlTemplate;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(RegisterServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass1 = request.getParameter("password1");
		String pass2 = request.getParameter("password2");
		String name = request.getParameter("name");
		
		PrintWriter out = HtmlTemplate.getHtmlOut(response);
		
		//Confirm that the user did not enter information in maliciously
		//(nulls or empty strings against front end validation)
		if(username==null||pass1==null||pass2==null||name==null||
			username.equals("")||pass1.equals("")||pass2.equals("")||name.equals("")) {
			response.sendError(418);
			return;
		}
		
		//Confirm passwords match
		if(!pass1.equals(pass2)) {
			out.println("<h3 style ='color:red'>Passwords do not match!</h3>");
			
			HtmlTemplate.goBack(out);
			return;
		}
		
		//Confirm username exists 
				if(new OwnerService().usernameExists(username)) {
					out.println("<h3 style ='color:red'>Username Taken!</h3>");
					
					HtmlTemplate.goBack(out);
					return;
				}
				
				if(new OwnerService().registerUser(username, pass1, name)) {
					out.println("<h3 style ='color:aliceblue'>"
							+username.toUpperCase()+" CREATED!"
							+ "</h3>");
					HtmlTemplate.goBack(out);
					return;
				}else {
					out.println("<h3 style ='color:red'>"
							+"An ERROR occurred during REGISTRATION"
							+ "</h3>");
					HtmlTemplate.goBack(out);
					return;
					
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
