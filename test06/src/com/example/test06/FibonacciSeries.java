package com.example.test06;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FibonacciSeries
 */
//@WebServlet("/FibonacciSeries")
public class FibonacciSeries extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BigInteger[] fiboArray = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FibonacciSeries() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step #1: get input parameters
		int count = Integer.parseInt(request.getParameter("count"));
		if (count > 100)  count = 100;
		
		// Step #2: data processing
		
		// Step #3: out processing results
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-7");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Fibonacci Series : count = " 
					+ count + "</h1><p>" );
		for (int i=0; i<count; i++) {
			out.print(fiboArray[i] + "   ");
			if ((i+1) % 5 == 0)
				out.println("<p>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		fiboArray = new BigInteger[100];
		fiboArray[0] = new BigInteger("1");
		fiboArray[1] = new BigInteger("1");
		for (int i=2; i<100; i++) {
			fiboArray[i] = fiboArray[i-1].add(fiboArray[i-2]);
		}
	}

	
}
