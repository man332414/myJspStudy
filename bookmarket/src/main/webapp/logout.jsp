<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
</head>
<body>
	<%
		HttpSession session = request.getSession(false);
		session.invalidate();
		response.sendRedirect("addBook");
	%>
</body>
</html>