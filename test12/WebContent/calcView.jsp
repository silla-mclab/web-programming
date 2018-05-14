<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.test12.Calculator" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>간단 사칙연산 계산기</title>
</head>
<body>
	<%
		Calculator calc = (Calculator)request.getAttribute("calculator");
	%>
	<div align="center">
		<h1>간단 사칙연산 계산기</h1><hr>
		입력 값: <%= calc.getFirst() %>, <%= calc.getSecond() %><p>
		덧셈: <%= calc.add() %><p>
		뺄셈: <%= calc.subtract() %><p>
		곱셈: <%= calc.multiply() %><p>
		나눗셈: <%= calc.divide() %><p>
		<br><br><br>
		<a href="calculate.html">첫페이지로 가기</a><p><hr>
	<%
		RequestDispatcher view = request.getRequestDispatcher("today.jsp");
		view.include(request, response);
	%>				
		
	</div>
</body>
</html>