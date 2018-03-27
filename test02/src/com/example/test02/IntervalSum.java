package com.example.test02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IntervalSum
 */
//@WebServlet("/IntervalSum")
public class IntervalSum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntervalSum() {
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
		int startNum = Integer.parseInt(request.getParameter("first"));
		int endNum = Integer.parseInt(request.getParameter("second"));
		
		// Step #2: data processing
		int sum = 0;
		for (int i=startNum; i<=endNum; i++) {
			sum += i;
		}
		
		// Step #3: output processing results
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>구간 합 구하기</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>구간 합 구하기<h1><hr>");
		out.println(startNum + "에서 " + endNum + "까지의 구간 합 : " + sum);
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
