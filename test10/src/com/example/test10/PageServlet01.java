package com.example.test10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageServlet01
 */
//@WebServlet("/PageServlet01")
public class PageServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet01() {
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
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// Step #2: data processing
		Cookie cookie = new Cookie("name", name);
		response.addCookie(cookie);
		
		cookie = new Cookie("gender", gender);
		response.addCookie(cookie);
		
		cookie = new Cookie("age", String.valueOf(age));
		response.addCookie(cookie);
		
		// Step #3: output processing results
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<div align='center'>");
		out.println("<h1>접속 서비스</h1><p>");
		out.println("<div align='right'>" + name + "님, 반갑습니다...<hr></div>");
		out.println("당신의 이름은 " + name + "입니다.<p>");
		out.println("<br><br><br><br><br>");
		out.println("<a href='second.do'>다음 페이지</a>");		
		out.println("</div>");	
	}

}
