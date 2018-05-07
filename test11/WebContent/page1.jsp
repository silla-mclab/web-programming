<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Favorite List Management</title>
</head>
<body>
	<div align="center">
		<h1>Favorite List Management Service</h1>
		<div align="right">
		<%
//			HttpSession session = request.getSession();
		%>
		[<%= session.getAttribute("user_name") %> ]님, 반갑습니다!...
		</div>
		<hr><p>
		<form method="post" action="page2.do">
			좋아하는 반려 동물은?
			<select name="pet">
				<option>강아지</option>
				<option>고양이</option>
				<option>햄스터</option>
			</select>
			<input type="submit" value="확인" />
		</form>		
	</div>
</body>
</html>