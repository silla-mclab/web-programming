<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.test13.model.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 상품 관리</title>
</head>
<body>
	<%
		BookDto book = (BookDto)request.getAttribute("book");
	%>
<%--
	<%@ include file="header.jsp" %>
 --%>
 	<jsp:include page="header.jsp" />
 	
	<div align="center">
		<h1>도서 상품 수정</h1><p>
<%
		if (book != null) {
%>
			<form method="POST" action="	update_result">
			도서 코드: <input type="text" name="code" 
						value=<%=book.getCode()%> readonly /><p>
			도서 제목: <input type="text" name="title" 
						value=<%=book.getTitle()%> /><p>
			도서 저자: <input type="text" name="writer" 
						value=<%=book.getWriter()%> /><p>
			도서 가격: <input type="text" name="price" 
						value=<%=book.getPrice()%> /><p>		
			<input type="submit" value="도서 	수정" />
			</form>
<%			
		}
		else {
%>
			<h3>도서 상품 정보를 잘못 검색하였습니다...</h3>
			<br><br>
			<button onclick="window.history.back();">이전 페이지로 가기</button>
<%			
		}
%>		
	</div>
<%--
	<%@ include file="footer.jsp" %>
--%>
	<jsp:include page="footer.jsp" />
</body>
</html>