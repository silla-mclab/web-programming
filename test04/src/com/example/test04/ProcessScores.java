package com.example.test04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessScores
 */
//@WebServlet("/ProcessScores")
public class ProcessScores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessScores() {
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
		Scores scoreObj = new Scores();
		
		String[] scoresStr = request.getParameterValues("scores");
		int[] scores = scoreObj.getScores();
		for (int i=0; i<scoresStr.length; i++) {
			scores[i] = Integer.parseInt(scoresStr[i]);
		}
		
		// Step #2: data processing
		int sum = 0;
		int sqSum = 0;
		for (int i=0; i<scores.length; i++) {
			int score = scores[i];
			sum += score;
			sqSum += score * score;
		}
		
		double mean = (double)sum / scores.length;
		double sqMean = (double)sqSum / scores.length;
		double sd = Math.sqrt(sqMean - (mean *mean));
		
		scoreObj.setTotalScore(sum);
		scoreObj.setMean(mean);
		scoreObj.setSd(sd);
		
		// step #3: forward to output servlet
		request.setAttribute("scoreObj", scoreObj);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("/output_scores.do");
		view.forward(request, response);
	}

}
