<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.test14.*" %>    
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

/*	
		PersonalInfo pInfo = new PersonalInfo();
		pInfo.setName(request.getParameter("name"));
		pInfo.setGender(request.getParameter("gender").charAt(0));
		pInfo.setAge(Integer.parseInt(request.getParameter("age")));
			
		// step #2: data processing
		
		// step #3: output results
		request.setAttribute("pInfo", pInfo);
*/		
//		RequestDispatcher view = request.getRequestDispatcher("InputView.jsp");
//		view.forward(request, response);
	%>
	<jsp:useBean id="pInfo" 
		class="com.example.test14.PersonalInfo" scope="request" />
<%--		
	<jsp:setProperty property="name" name="pInfo"
		 value='<%= request.getParameter("name") %>' />
	<jsp:setProperty property="gender" name="pInfo"
		 value='<%= request.getParameter("gender").charAt(0) %>' />
	<jsp:setProperty property="age" name="pInfo"
		 value='<%= Integer.parseInt(request.getParameter("age")) %>' />
 --%>
 <%--
	<jsp:setProperty property="name" name="pInfo" param="name" />
	<jsp:setProperty property="gender" name="pInfo" />
	<jsp:setProperty property="age" name="pInfo" />
  --%>
  
	<jsp:setProperty property="*" name="pInfo" />
  		 
	<jsp:forward page="InputView.jsp" />
</body>
</html>