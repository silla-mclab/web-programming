package com.example.sessiontest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PageControlServlet
 */
//@WebServlet("/PageControlServlet")
public class PageControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1: get URL path info
		request.setCharacterEncoding("UTF-8");
		
		String reqSubPath = request.getPathInfo().split("/")[1];
		
		// step #2: route data processing & output using path info
		// get session objec
		HttpSession session = request.getSession();
		boolean bSessionClosed = false;
		
		FavoriteInfoDao dao = (FavoriteInfoDao)session.getAttribute("dao");
		if (dao == null) {
			dao = new FavoriteInfoDao();
			session.setAttribute("dao", dao);
		}
		
		String viewName = null;
		
		if (reqSubPath.equals("page1.do")) {
			String userName = request.getParameter("user_name");
			
			session.setAttribute("user_name", userName);
			
			viewName = "/page1.jsp";			
		}
		else if (reqSubPath.equals("page2.do")) {
			if (session.isNew()) {
				viewName="/session_error.jsp";
			}
			else {
				String fruit = request.getParameter("fruit");
				
				dao.setFavoriteItem("fruit", fruit);
				
				viewName= "/page2.jsp";
			}
		}
		else if (reqSubPath.equals("page3.do")) {
			if (session.isNew()) {
				viewName="/session_error.jsp";
			}
			else {
				String pet = request.getParameter("pet");
			
				dao.setFavoriteItem("pet", pet);
				
				viewName= "/page3.jsp";			
			}
		}
		else if (reqSubPath.equals("result.do")) {
			if (session.isNew()) {
				viewName="/session_error.jsp";
			}
			else {
				String subject = request.getParameter("subject");
				
				dao.setFavoriteItem("subject", subject);
				
				viewName= "/page4.jsp";
				bSessionClosed = true;
			}
		}
		else {
			viewName="/session_error.jsp";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(viewName);
		view.forward(request, response);
		
		if (bSessionClosed) {
			session.invalidate();
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
