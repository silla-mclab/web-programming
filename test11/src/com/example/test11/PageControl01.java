package com.example.test11;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PageControl01
 */
//@WebServlet("/PageControl01")
public class PageControl01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageControl01() {
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
		
		String userName = request.getParameter("user_name");
		
		// Step #2: data processing
		// create a session
		HttpSession session = request.getSession();
		session.setAttribute("user_name", userName);
		
		// Step #3: output processing results
		RequestDispatcher view = request.getRequestDispatcher("page1.jsp");
		view.forward(request, response);
	}

}
