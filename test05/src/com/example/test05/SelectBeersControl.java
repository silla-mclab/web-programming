package com.example.test05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectBeersControl
 */
//@WebServlet("/SelectBeersControl")
public class SelectBeersControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBeersControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step #1: get input parameters
		request.setCharacterEncoding("UTF-8");
		String color = request.getParameter("color");
		
		// Step #2: data processing
		BeerExpert expert = new BeerExpert();
		ArrayList<String> brands = expert.getBrands(color);
		
		// Step #3: output processing results
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1 align='center'>Beer Recommandation Service</h1><p>");
		out.println("<center>");
		
		Iterator<String> it = brands.iterator();
		while (it.hasNext()) {
			out.println("Try : " + it.next() +"<p>");
		}
		
		out.println("</center>");
	}

}
