package com.example.test04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutputScores
 */
//@WebServlet("/OutputScores")
public class OutputScores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutputScores() {
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
		// Step #1: get processing results
		Scores scoreObj = (Scores)request.getAttribute("scoreObj");
		
		// Step #2: output processing result
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>성적 처리 및 결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>성적 처리 결과</h1><hr>");
		out.print("입력 점수 : ");
		int[] scores = scoreObj.getScores();
		for (int i=0; i<scores.length; i++) {
			out.print(scores[i] + "  ");
		}
		out.println("<br><br>");
		out.println("총점 : " + scoreObj.getTotalScore() + "<br><br>");
		out.println("평균 : " + scoreObj.getMean() + "<br><br>");
		out.println("표준편차 : " + scoreObj.getSd() + "<br><br>");
		out.println("</body>");
		out.println("</html>");
	}

}
