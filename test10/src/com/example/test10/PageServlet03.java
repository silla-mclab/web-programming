package com.example.test10;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageServlet03
 */
//@WebServlet("/PageServlet03")
public class PageServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step #1: get input parameters
		request.setCharacterEncoding("UTF-8");
		
		// read cookie data
		Cookie[] cookies = request.getCookies();
		
		HashMap<String, String> cookieTable = new HashMap<String, String>();
		for (Cookie cookie : cookies) {
			cookieTable.put(cookie.getName(), cookie.getValue());
		}
		
		// Step #2: data processing
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		// Step #3: output processing results
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<div align='center'>");
		out.println("<h1>접속 서비스</h1><p>");
		out.println("<div align='right'>" + cookieTable.get("name") + "님, 반갑습니다...<hr></div>");
		out.println("당신의 나이는 " + cookieTable.get("age") + " 입니다.<p>");
		out.println("<br><br><br><br><br>");
		out.println("<a href='connect.html'>첫 페이지</a>");		
		out.println("</div>");	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
