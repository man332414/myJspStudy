<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scriptlet01</title>
</head>
<body>
	<%
		int a = 2;
		int b = 3;
		int sum = a + b;
		out.print("2 + 3 = " + sum);
	%>
	<br>
	<p><a href = "home">집으로 가기</a></p>
</body>
</html>