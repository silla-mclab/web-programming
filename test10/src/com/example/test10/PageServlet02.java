package com.example.test10;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageServlet02
 */
//@WebServlet("/PageServlet02")
public class PageServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet02() {
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
		Cookie cookie = new Cookie("age", "100");
		response.addCookie(cookie);
		
		// Step #3: output processing results
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<div align='center'>");
		out.println("<h1>접속 서비스</h1><p>");
		out.println("<div align='right'>" + cookieTable.get("name") + "님, 반갑습니다...<hr></div>");
		out.println("당신의 성별은 " + 
				(cookieTable.get("gender").equals("male") ? "남자" : "여자")
				+ " 입니다.<p>");
		out.println("<br><br><br><br><br>");
		out.println("<a href='third.do'>다음 페이지</a>");		
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
