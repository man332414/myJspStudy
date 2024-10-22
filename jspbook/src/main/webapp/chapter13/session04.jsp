<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<h4>---- 세션을 삭제하기 전 -----</h4>
	<%
		out.print(session.getId());
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
	%>
	<p>설정된 세션 이름 ID : <%= id %></p>
	<p>설정된 세션 이름 pw : <%= pw %></p>
	
	<% session.removeAttribute("id"); %>
	
	<h4>---- 세션을 삭제한 후 -----</h4>
	<%
		out.print(session);
		id = (String)session.getAttribute("id");
		pw = (String)session.getAttribute("pw");
	%>
	<p>설정된 세션 이름 ID : <%= id %></p>
	<p>설정된 세션 이름 pw : <%= pw %></p>
	<%@include file = "session_footer.jsp" %>
</body>
</html>