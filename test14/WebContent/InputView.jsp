<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.test14.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인 정보 입력 결과</title>
</head>
<body>
	<div align="center">
		<h1>개인 정보 입력 결과</h1><hr>
		<br><br>
<%--	
<%
		PersonalInfo pInfo = 
			(PersonalInfo)request.getAttribute("pInfo");
%>
 --%>
 		<jsp:useBean id="pInfo"	
			class="com.example.test14.PersonalInfo"	scope="request" />
<%--
		1. 이름: <%= pInfo.getName() %><p>
		2. 성별: <%= pInfo.getGender() %><p>
		3. 나이: <%= pInfo.getAge() %><p>
 --%>
<%-- 
		1. 이름: <jsp:getProperty property="name" name="pInfo"/><p>
		2. 성별: <jsp:getProperty property="gender" name="pInfo"/><p>
		3. 나이: <jsp:getProperty property="age" name="pInfo"/><p>
 --%>
		1. 이름: ${pInfo.name}<p>
		2. 성별: ${pInfo.gender}<p>
		3. 나이: ${pInfo.age}<p>
 
  	</div>
</body>
</html>