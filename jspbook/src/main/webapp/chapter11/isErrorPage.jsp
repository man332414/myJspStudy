<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage ="isErrorPage_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception</title>
</head>
<body>
	<%=request.getParameter("name").toUpperCase() %>
</body>
</html>