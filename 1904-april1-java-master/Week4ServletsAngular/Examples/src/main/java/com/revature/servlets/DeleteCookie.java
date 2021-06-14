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
 * Servlet implementation class DeleteCookie
 */
public class DeleteCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		int num = 0;
		
		if(cookies!=null) {
			for(Cookie c:cookies) {
				num++;
				c.setMaxAge(0);//this is how you delete a cookie
				response.addCookie(c);
			}
		}
		
		PrintWriter out = HtmlTemplate.getHtmlOut(response);
		out.println("<h3 style='color:green'>" + num +
				"Cookies DeVoUrEd!</h3>");
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
