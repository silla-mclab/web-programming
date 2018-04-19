<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인 정보 저장 결과</title>
</head>
<body>
	<div align='center'>
		<h1>개인 정보 저장 결과</h1><hr>
		저장 결과: <%= (String)request.getAttribute("result") %><p>
		<br><br><br><br><br>
		<a href="input_pinfo.html">첫페이지로 가기</a>
	</div>
</body>
</html>