<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>data Value</title>
</head>
<body>
	<p>
		<%! int data = 50; %>
		<% out.println("Value of the variable is : " + data); %>
		<br>
		Value of the variable is : <%= data %>
	</p>
	
	<p><a href = "home">홈으로 가기</a></p>
</body>
</html>