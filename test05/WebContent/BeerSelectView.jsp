<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beer Recommendation Service</title>
</head>
<body>
	<h1 align='center'>Beer Recommendation Result</h1><p>
	<div align='center'>
		Selected Beer Color : <%= request.getParameter("color") %><p>
		<%
			ArrayList<String> brands = 
				(ArrayList<String>)request.getAttribute("brands");
		
			for (int i=0; i<brands.size(); i++) {
		%>
				Try : <%= brands.get(i) %><p>
		<%		
			}
		%>	
	</div>
</body>
</html>