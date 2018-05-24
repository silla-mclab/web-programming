package com.example.test13.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookManager
 */
//@WebServlet("/BookManager")
public class BookManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get URL path info
		request.setCharacterEncoding("UTF-8");
		
		String urlSubPath = request.getPathInfo().split("/")[1];
		
		// step #2. process input data and route output
		String viewName = null;
		
		if (urlSubPath.equals("search")) {
			viewName = "/search.jsp";
		}
		else {
			viewName = "/error_400.jsp";
		}
		
		// step #3. forward to view page
		if (viewName != null) {
			RequestDispatcher view 
				= request.getRequestDispatcher(viewName);
			view.forward(request, response);
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
