<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		
		out.print("현재 설정되 쿠기 갯수 => " + cookies.length +"<br>");
		out.print("=======================================<br>");
		
		for(int i = 0; i<cookies.length; i++)
		{
			out.println("설정된 쿠키의 속성 이름 [" + i +"] : " +cookies[i].getName() +"<br>");
			out.println("설정된 쿠키의 속성 값 [" + i +"] : " +cookies[i].getValue() +"<br>");
			out.print("-----------------------------------------------------------<br>");

		}
	%>
</body>
</html>