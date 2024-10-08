<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String makeItLower(String data)
		{
			return data.toLowerCase();
		}
	%>
	<% out.println(makeItLower("Hello World")); %>
	<br>
	<%= makeItLower("Hello World") %>
	
	<p><a href = "home">집으로 가볼까?</a></p>
</body>
</html>