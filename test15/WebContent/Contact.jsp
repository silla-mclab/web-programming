<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>
<%@ taglib uri="http://com.example.test15/mytags" prefix="my" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Service</title>
</head>
<body>
<%--
	<jsp:include page="Header.jsp">
		<jsp:param name="subTitle" value="We take the sting out of SOAP." />
	</jsp:include>
 --%>
 <%--
 	<c:import url="Header.jsp">
		<c:param name="subTitle" value="We take the sting out of SOAP." /> 
	</c:import>
 --%>
<%-- 
 	<myTags:Header fontColor='#660099'>
 		We take the sting out of SOAP.
 	</myTags:Header>
 --%>
 	<my:MyHeader fontColor='#660099'>
 		We take the sting out of SOAP.
 	</my:MyHeader>
 	<br><br>
	Contact us at : ${initParam.mainEmail}
</body>
</html>