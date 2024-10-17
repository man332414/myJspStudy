<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security</title>
</head>
<body>
	<p> 사용자명 : <%=request.getRemoteUser() %></p>
	<p> 인증방법 : <%=request.getAuthType() %></p>
	<p> 인증한 사용자 명이 역할명 "manager"에 속하는 사용자 인가요?</p>
		<%= request.isUserInRole("manager") %>
	<p> 인증한 사용자 명이 역할명 "guest"에 속하는 사용자 인가요?</p>
		<%= request.isUserInRole("guest") %>
</body>
</html>