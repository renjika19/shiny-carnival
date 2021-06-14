package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Polkaman;
import com.revature.services.PolkamanService;

/**
 * Servlet implementation class FetchPolkamansServlet
 */
public class FetchPolkamansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchPolkamansServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Jackson Mapper
		 * 
		 * We will use this object in order to conver the java object
		 * (obtained via JDBC) and turn it into a JSON string representation
		 * of the data. This will make for handling any data passed from java
		 * to javascript significantly easier to work with
		 */
		List<Polkaman> polkamans = new PolkamanService().getAllPolkamans();
		ObjectMapper om = new ObjectMapper();
		
		//tell the client that it will be receiving JSON formatted data
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		//Convert the collection into a JSON string representation
		out.println(om.writeValueAsString(polkamans));
		//very crudely like stringify
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
