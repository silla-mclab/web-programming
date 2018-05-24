<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
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
		<form method="post" action=<%=response.encodeURL("page2.do")%>>
			당신이 좋아하는 과일은?
			<select name="fruit">
				<option>사과</option>
				<option>딸기</option>
				<option>바나나</option>
			</select>
			<input type="submit" value="확인" />
		</form>
		<%= 10/0 %>
	</div>
</body>
</html>