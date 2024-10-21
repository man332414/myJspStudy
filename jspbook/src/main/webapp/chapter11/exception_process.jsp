<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage = "exception_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception</title>
</head>
<body>
	<%
	String num1 = (String)request.getAttribute("num1"); 
	String num2 = (String)request.getAttribute("num2");
	
	int a = Integer.parseInt(num1);
	int b = Integer.parseInt(num2);
	double c = a/b;
	
	out.print(a + " / " + b + " = " + c);
	%>
	<p><a href = "11_3">다시하기</a></p>
</body>
</html>