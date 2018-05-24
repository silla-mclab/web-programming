package com.example.sessiontest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Page2Servlet
 */
//@WebServlet("/Page2Servlet")
public class Page2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page2Servlet() {
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
		
		String fruit = request.getParameter("fruit");
		
		// Step #2: data processing 
		FavoriteInfoDao dao = new FavoriteInfoDao();
		dao.setFavoriteItem("fruit", fruit);
		
		HttpSession session = request.getSession();
		if (session.isNew()) {
			
		}
		session.setAttribute("dao", dao);
		
		// Step #3: output processing results
		RequestDispatcher view = request.getRequestDispatcher("page2.jsp");
		view.forward(request, response);		
	}

}
