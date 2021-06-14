package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.HtmlTemplate;

/**
 * Servlet implementation class CreateCookie
 */
public class CreateCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cookieName = request.getParameter("cname");
		String cookieValue = request.getParameter("cval");
		
		if(cookieName==null||cookieValue==null||
			cookieName.contentEquals("")||cookieValue.contentEquals("")) {
			response.sendError(400); //Bad Request
			return;
		}
		
		Cookie cookie = new Cookie(cookieName, cookieValue);
		
		Cookie[] cookies = request.getCookies();
		
		PrintWriter out = HtmlTemplate.getHtmlOut(response);
		
		//Clarify created cookie does not already exist
//		if(cookies != null) {
//			for(Cookie c: cookies) {
//				out.println("<h3 style='color:red'>"
//						+ "Cookie Already Exists!"
//						+ "</h3>");
//				HtmlTemplate.goBack(out);
//				return;
//			}
//		}
		//otherwise we create a cookie that will have a lifespan
		//of 20 seconds
		cookie.setMaxAge(20);
		response.addCookie(cookie);
		out.println("<h3 style='color:green'>"
				+ "Cookie BAKED!"
				+ "</h3>");
		HtmlTemplate.goBack(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
