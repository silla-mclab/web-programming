<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 상품 관리</title>
</head>
<body>
<%--
	<%@ include file="header.jsp" %>
 --%>
 	<jsp:include page="header.jsp" />
 	
	<div align="center">
		<h1>도서 상품 조회</h1><p>
		<form method="get" action="search_result">
			도서 코드: <input type="text" name="code" /><p>
			<input type="submit" value="조회" />
		</form>
	</div>
	
<%--
	<%@ include file="footer.jsp" %>
--%>
	<jsp:include page="footer.jsp" />
</body>
</html>