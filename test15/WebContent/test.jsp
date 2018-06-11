<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="DiceFunctions" prefix="myFn" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Dice Rolling Game</h1><br><br>
	Current Dice Value = ${myFn:rollIt()}
	<br><br>
	Squared Root of 100 = ${myFn:mySqrt(100)}
</body>
</html>