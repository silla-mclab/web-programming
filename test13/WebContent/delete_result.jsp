<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 상품 관리</title>
</head>
<body>
	<%
		int result = Integer.parseInt(
				(String)request.getAttribute("result"));
	%>
<%--
	<%@ include file="header.jsp" %>
 --%>
 	<jsp:include page="header.jsp" />
 	
	<div align="center">
		<h1>도서 상품 삭제 결과</h1><p>
<%
		if (result > 0) {
%>
			<h3>도서 상품 정보를 성공적으로 삭제하였습니다...</h3>
			<br><br>
			<button onclick="window.location.href='../start';">첫페이지로 가기</button>
<%			
		}
		else {
%>
			<h3>도서 상품 정보를 삭제하지 못하였습니다...</h3>
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