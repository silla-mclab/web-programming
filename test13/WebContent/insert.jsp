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
		<h1>도서 상품 추가</h1><p>
		<form method="POST" action="insert_result">
			도서 코드: <input type="text" name="code" /><p>
			도서 제목: <input type="text" name="title" /><p>
			도서 저자: <input type="text" name="writer" /><p>
			도서 가격: <input type="text" name="price" /><p>		
			<input type="submit" value="도서 추가" />
		</form>
	</div>
<%--
	<%@ include file="footer.jsp" %>
--%>
	<jsp:include page="footer.jsp" />
</body>
</html>