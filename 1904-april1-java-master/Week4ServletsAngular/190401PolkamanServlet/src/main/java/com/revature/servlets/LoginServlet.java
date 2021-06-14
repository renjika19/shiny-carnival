package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.services.OwnerService;
import com.revature.util.HtmlTemplate;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginServlet.class);
       
	@Override
	public void init() throws ServletException{
		logger.trace(this.getServletName() + ": INSTANTIATED");
		System.out.println("Grabing a Config Variable...");
		System.out.println("Variable:" +this.getInitParameter(
				"Param1"));
		System.out.println("Grabing a Context Variable...");
		System.out.println("Variable:" + this.getServletContext()
		.getInitParameter("Param2"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		logger.info("Login instantiated with username for PolkaUser:"
				+ username);
		if(new OwnerService().confirmLogin(username,password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			RequestDispatcher rq = request.getRequestDispatcher("user/home.html");
			rq.forward(request, response);
			logger.info(username + ":Logged in successfully.");
			}else {
				PrintWriter out = HtmlTemplate.getHtmlOut(response);
				logger.warn(username+": Suffered a failed login attempt.");
				out.println("<h3 style='color:red'>Denied!</h3>");
			}
		/*
		 * So servlets take requests from clients and forward them to the
		 * requested resources. There are two main ways that this can occur:
		 * 1)RequestDispatcher
		 * 	-supplied by the request object
		 * 	-it never leaves the current server, so you can't dispatch
		 * 	into another website
		 * 	-the url you send to people is masked
		 * 	-you make only one request
		 * 2)SendRedirect
		 * 	-supplied by the response object
		 * 	-Reveal the new URL that the client is sent to
		 * 	-Actually sends a response back to the client and sends in a new
		 * 	request. As a result, all data from the previous request is lost
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
