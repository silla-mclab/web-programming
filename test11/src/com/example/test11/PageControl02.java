package com.example.test11;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PageControl02
 */
//@WebServlet("/PageControl02")
public class PageControl02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageControl02() {
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
		
		String pet = request.getParameter("pet");
		
		// Step #2: data processing
		// create a model object and save a favorite item
		MyFavoriteInfo info = new MyFavoriteInfo();
		info.setFavoriteItem("pet", pet);
		
		// save model object to session object
		HttpSession session = request.getSession();
		session.setAttribute("favorite_info", info);
		
		// Step #3: output processing results
		RequestDispatcher view = request.getRequestDispatcher("page2.jsp");
		view.forward(request, response);
	}

}
