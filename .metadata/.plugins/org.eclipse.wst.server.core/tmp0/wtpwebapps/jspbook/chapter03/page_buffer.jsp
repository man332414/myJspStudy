<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directives Tag</title>
</head>
<body>
	<%@ page buffer = "34kb" %>
	Today is : <%= new java.util.Date() %>
	<p><a href = "home">home</a></p>
</body>
</html>