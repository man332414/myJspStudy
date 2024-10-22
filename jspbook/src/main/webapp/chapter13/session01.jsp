<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<form action="13_1" method = "post">
		<p>아이디 : <input type = "text" name = "id"></p>
		<p>비밀번호 : <input type = "password" name = "pw"></p>
		<p><input type = "submit" value = "submit" ></p>		
	</form>
	<br>
	<%@include file = "session_footer.jsp" %>
</body>
</html>