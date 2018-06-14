<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.test15.Employee, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Tag Library Test</title>
</head>
<body>
<%
	List<Employee> empList = new ArrayList<Employee>();

	Employee emp = new Employee();
	emp.setId("1000");
	emp.setName("홍길동");
	emp.setRole("생산직");
	empList.add(emp);
	
	emp = new Employee();
	emp.setId("2000");
	emp.setName("김철수");
	emp.setRole("연구직");
	empList.add(emp);
	
	request.setAttribute("empList", empList);
	
	request.setAttribute("htmlTagData", "<br/> creates a new line.");
%>

	<h1>JSTL Tag Test</h1><br><br>
	
	<h3>Employee List</h3>
	<table border='1'>
		<tr>
			<th></th><th>ID</th><th>Name</th><th>Role</th>
		</tr>
		<c:forEach var="emp" items="${requestScope.empList}" varStatus="loopCount">
			<tr>
				<td>${loopCount.count}</td>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.role}</td>
			</tr>
		</c:forEach>
	</table><br><br>
	<c:if test="${requestScope.htmlTagData ne null}">
		<h3><c:out value="${requestScope.htmlTagData}" escapeXml="true" /></h3>
	</c:if>
	<br><br>
	<c:catch var="ex">
		<% int x = 10/0; %>
		예외가 발생하지 않으면 이 문장이 출력됩니다...<br>
	</c:catch>
	<c:if test="${ex ne null}">
		Exception occured by ${ex.message}<br>
	</c:if>
	<br><br>
	<a href="<c:url value='http://com.example.test15'>
			<c:param name='first' value='10' />
			<c:param name='second' value='Hello World!' />
		</c:url>	">goto Test15</a>
</body>
</html>