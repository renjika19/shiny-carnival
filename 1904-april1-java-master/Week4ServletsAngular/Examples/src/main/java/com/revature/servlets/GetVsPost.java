package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.HtmlTemplate;

public class GetVsPost extends HttpServlet{
	/*
	 * GET and POST are both "HTTP Methods." These two verbs are diffent
	 * ways that we can send requests to a server
	 * The difference between GET and POST is that, for one, GET will
	 * store all sent data in the url of the message. POST will store the
	 * data in the body of the message. GET also has a size limit of
	 * about 2KB, where POST is near limitless.
	 * In both cases, the parameters passed are stored in a header called:
	 * QUERY_STRINg
	 * 
	 * BTW
	 * Here are all of the HTTP methods that are worth noting:
	 * GET <--focus on these two for now
	 * POST <--
	 * PUT
	 * DELETE
	 * HEAD
	 * OPTIONS
	 * TRACE
	 * PATCH <- i don't like this one
	 */
	
	//It is customary to write a doGet and a doPost method when
	//you are working with servlets (note that you can do other
	//http methods as well)
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws
			ServletException, IOException{
		//String formData = request.getParamenter("username");
		//the line above can be used to get the username from a form
		
		PrintWriter out = HtmlTemplate.getHtmlOut(response);
		String values ="";
		
		Map<String,String[]> inputs = request.getParameterMap();
		out.println("<h3>GET</h3>");
		out.println(
				"<table border='2px'><tr><th>PARAMETER</th><th>VALUE</th></tr>"
				);
		for(String key: inputs.keySet()) {
			out.println("<tr><td>"+key+"</td><td>");
			values = "";
			for(String val:inputs.get(key)) {
				values+=(val+" ");
			}
			out.println(values + "</td></tr>");
		}
		out.println("</table>");
		HtmlTemplate.goBack(out);
	}
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws
			ServletException, IOException{
		//String formData = request.getParamenter("username");
		//the line above can be used to get the username from a form
		
		PrintWriter out = HtmlTemplate.getHtmlOut(response);
		String values ="";
		
		Map<String,String[]> inputs = request.getParameterMap();
		out.println("<h3>POST</h3>");
		out.println(
				"<table border='2px'><tr><th>PARAMETER</th><th>VALUE</th></tr>"
				);
		for(String key: inputs.keySet()) {
			out.println("<tr><td>"+key+"</td><td>");
			values = "";
			for(String val:inputs.get(key)) {
				values+=(val+" ");
			}
			out.println(values + "</td></tr>");
		}
		out.println("</table>");
		HtmlTemplate.goBack(out);
	}
}
