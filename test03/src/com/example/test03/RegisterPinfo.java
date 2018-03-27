package com.example.test03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterPinfo
 */
//@WebServlet("/RegisterPinfo")
public class RegisterPinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPinfo() {
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
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String inotice = request.getParameter("inotice");
		String cnotice = request.getParameter("cnotice");
		String dnotice = request.getParameter("dnotice");
		String job = request.getParameter("job");
		String intro = request.getParameter("intro");
		
		// Step #2: data processing
		// Save personal info to DB
		
		// Step #3: out processing result
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>개인 정보 입력 결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개인 정보 입력 결과</h1><hr>");
		out.println("1. 이름 :" + name + "<br><br>");
		out.println("2. 아이디 :" + id + "<br><br>");
		out.println("3. 패스워드 :" + passwd + "<br><br>");
		out.println("4. 성별 :" + 
				(gender.equals("male") ? "남" : "여") + "<br><br>");
		out.println("5. 공지 메일 수신 :" + 
				(inotice != null ? "수신함" : "수신하지 않음") + "<br><br>");
		out.println("6. 광고 메일 수신 :" + 
				(cnotice != null ? "수신함" : "수신하지 않음") +  "<br><br>");
		out.println("7. 배송확인 메일 수신 :" + 
				(dnotice != null ? "수신함" : "수신하지 않음") +  "<br><br>");
		out.println("8. 직업 :" + job + "<br><br>");
		out.println("9. 자기소개 :" + intro + "<br><br>");
		out.println("</body>");
		out.println("</html>");
	}

}
