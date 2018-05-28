<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.example.test13.model.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 상품 관리</title>
</head>
<body>
	<script>
		function submitForm(url) {
			var form1 = document.getElementById("form1");
			form1.setAttribute("action", url);
			form1.submit();
		}
	</script>	
<%--
	<%@ include file="header.jsp" %>
 --%>
 	<jsp:include page="header.jsp" />
 	
	<div align="center">
		<h1>도서 상품 조회 결과</h1><p>
<%
	List<BookDto> bookList 
		= (List<BookDto>)request.getAttribute("book_list");
	if (bookList != null) {
%>		
		<form id="form1" method="GET" action="update">
		<table border="1">
			<tr>
				<th></th>
				<th>코 드</th>
				<th>제 목</th>
				<th>저 자</th>
				<th>가 격</th>
			</tr>
<%
		for (BookDto book : bookList) {
%>
			<tr>
				<td><input type="radio" name="code" 
					value="<%= book.getCode()%>" /></td>
				<td><%= book.getCode() %></td>
				<td><%= book.getTitle() %></td>
				<td><%= book.getWriter() %></td>
				<td><%= book.getPrice() %></td>
			</tr>
<%			
		}
%>			
		</table><p>	
		<br>
		<input type="button" value="수정"
			onclick='submitForm("update");' />
		<input type="button" value="삭제"
			onclick='submitForm("delete");' />
		<input type="button" value="첫 페이지 >>"
			onclick="window.location.href='../start';" />
		</form>	
<%		
	}
	else {
%>
		<h3>요청하신 검색 결과가 없습니다!....</h3><p>
		<input type="button" value="이전 페이지 >>"
			onclick="window.history.back();" />
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