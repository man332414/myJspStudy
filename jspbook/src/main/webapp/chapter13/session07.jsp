<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<h4>---- 세션 유효시간 변경 전 ----</h4>
	<%
		int time = session.getMaxInactiveInterval() / 60;
		out.print("세션 유효시간" + time +"분 <br>");
		
		session.setMaxInactiveInterval(60*60);
	%>
	
	<h4>---- 세션 유효시간 변경 후 ----</h4>
	<%
		time = session.getMaxInactiveInterval() / 60;
		out.print("세션 유효시간" + time +"분 <br>");
	%>
	<%@include file = "session_footer.jsp" %>
</body>
</html>