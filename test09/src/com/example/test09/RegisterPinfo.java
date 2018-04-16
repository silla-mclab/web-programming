package com.example.test09;

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
		
		PersonalInfo pInfo = new PersonalInfo();
		
		pInfo.setName(request.getParameter("name"));
		pInfo.setId(request.getParameter("id"));
		pInfo.setPasswd(request.getParameter("passwd"));
		pInfo.setGender(
			request.getParameter("gender").equals("male")?'M':'F');
		pInfo.setInotice(
			request.getParameter("inotice")!=null?true:false);
		pInfo.setCnotice(
				request.getParameter("cnotice")!=null?true:false);
		pInfo.setDnotice(
				request.getParameter("dnotice")!=null?true:false);
		pInfo.setJob(request.getParameter("job"));
		pInfo.setIntro(request.getParameter("intro"));
		
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
		out.println("1. 이름 :" + pInfo.getName() + "<br><br>");
		out.println("2. 아이디 :" + pInfo.getId() + "<br><br>");
		out.println("3. 패스워드 :" + pInfo.getPasswd() + "<br><br>");
		out.println("4. 성별 :" + 
				(pInfo.getGender() == 'M' ? "남" : "여") + "<br><br>");
		out.println("5. 공지 메일 수신 :" + 
				(pInfo.isInotice() ? "수신함" : "수신하지 않음") + "<br><br>");
		out.println("6. 광고 메일 수신 :" + 
				(pInfo.isCnotice() ? "수신함" : "수신하지 않음") +  "<br><br>");
		out.println("7. 배송확인 메일 수신 :" + 
				(pInfo.isDnotice() ? "수신함" : "수신하지 않음") +  "<br><br>");
		out.println("8. 직업 :" + pInfo.getJob() + "<br><br>");
		out.println("9. 자기소개 :" + pInfo.getIntro() + "<br><br>");
		out.println("</body>");
		out.println("</html>");
	}

}
