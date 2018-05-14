<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Reference Count</title>
</head>
<body>
	<h1>Page Reference Count</h1><hr>
	<%!
		private int refCount = 0;
	%>
	<%!
		int getRefCount() {
			return (++refCount) * 2;
		}
	%>
	Page Ref. Count = <%= getRefCount() %>
</body>
</html>