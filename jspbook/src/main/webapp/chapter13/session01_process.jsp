<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<%
		session = request.getSession();
		String id = session.getAttribute("id").toString();
		String pw = session.getAttribute("pw").toString();
	%>
	<p>id : <%=id %></p>
	<p>pw : <%=pw %></p>
	
	<%@include file = "session_footer.jsp" %>
</body>
</html>