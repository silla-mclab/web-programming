<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String db_url = "jdbc:mysql://localhost:3306/bookdb1"
					+"?serverTimezone=Asia/Seoul&useSSL=false";
	String db_user = "testuser";
	String db_passwd = "test1234";
	String db_table = "bookinfo";
	
	Class.forName(jdbc_driver);
	
	Connection conn = DriverManager.getConnection(
							db_url, db_user, db_passwd);
	
	if (conn != null) {
		out.println("DB 연결에 성공하였습니다....<p>");
		
		// execute SQL commands
		
		conn.close();	
		out.println("DB 연결에 종료하였습니다....<p>");
	}
	else {
		out.println("DB 연결에 실패하였습니다....<p>");
	}
%>
</body>
</html>