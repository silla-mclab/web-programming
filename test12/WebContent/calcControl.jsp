<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.test12.Calculator" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// step #1: get input parameters
		request.setCharacterEncoding("UTF-8");
		int first = Integer.parseInt(request.getParameter("first"));
		int second = Integer.parseInt(request.getParameter("second"));
		
		// step #2: data processing
		Calculator calc = new Calculator();
		calc.setFirst(first);
		calc.setSecond(second);
		
		// step #3: output results
		request.setAttribute("calculator", calc);
		
//		RequestDispatcher view = request.getRequestDispatcher("calcView.jsp");
//		view.forward(request, response);

//		pageContext.forward("calcView.jsp");
	%>
	<jsp:forward page="calcView.jsp" />
	
	<%
		out.println("감사합니다....");	
	%>
</body>
</html>