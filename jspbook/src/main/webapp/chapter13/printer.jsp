<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<% 
		//session = request.getSession(false);
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("id");
	%>
	
	<%= id%>
	<%= pw%>
	<p><a href = "13">dlehd</a></p>
</body>
</html>