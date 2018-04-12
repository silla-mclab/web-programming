package com.example.test07;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleLogin
 */
//@WebServlet("/SimpleLogin")
public class SimpleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PrintWriter logFile = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleLogin() {
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
		
		// Step #2: data processing
		writeLog(name);
		
		// Step #3: output processing results
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1 align='center'>Simple Login</h1><p>");
		out.println("<div align='center'>");
		out.println(name + "님, 반갑습니다!...");
		out.println("</div>");
		out.println("<br><br><br><br><br><br><br><br><hr>");

//		ServletContext context = getServletConfig().getServletContext();
		ServletContext context = getServletContext();		

		out.println("<div align='center'>");
		out.println(
			"Contact Point: " + getInitParameter("admin_email") + "<br>" 
			+ "Master Contact Point: " + 
						context.getInitParameter("master_email") + "<br>"
			+ "Server Info: " + 
						context.getServerInfo() + "<br>"
			+ "Servlet API Version: ver." + 
						context.getMajorVersion() + "." 
						+ context.getMinorVersion() + "<br>"
			+ "</div>");
	}

	private void writeLog(String msg) {
		if (logFile != null) {
			GregorianCalendar now = new GregorianCalendar();
			logFile.printf("%TF %TT - %s\n", now, now, msg);
		}
	}
	
	@Override
	public void destroy() {
		if (logFile != null) {
			logFile.close();
			logFile = null;
		}
	}

	@Override
	public void init() throws ServletException {
		if (logFile == null) {
			try {
				logFile = new PrintWriter(
						new FileWriter(
							getServletConfig().getInitParameter("logfile_name"),
							true));
//				    new FileWriter("/Users/comit/loginlog.txt", true));
//					new FileWriter("c:\\loginlog.txt", true));
				
			} catch (IOException e) {
				throw new ServletException(e);
			}
		}
	}

	
}
