<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ page import="com.example.sessiontest.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Favorite Info Registration</title>
</head>
<body>
	<div align="center">
		<h1>Favorite Info Registration</h1>
		<div align="right"><%=session.getAttribute("user_name") %> 님, 반갑습니다!...</div><hr>
		당신이 좋아하는 것들은?<p>
		<%
			FavoriteInfoDao dao = (FavoriteInfoDao)session.getAttribute("dao");
			Set<String> keys = dao.getFavoriteItemNames();
			
			for (String key : keys) {
				out.println(key + "은 " + dao.getFavoriteItem(key) + "<p>");
			}
			
//			session.invalidate();
//			session.setMaxInactiveInterval(0);			
		%>
		<br><br><br>
		<a href="../start.html">첫 페이지로 가기</a>
	</div>
</body>
</html>