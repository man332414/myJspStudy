<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>
<body>
	<%
		String id = (String)request.getAttribute("id");
		String pw = (String)request.getAttribute("pw");
	%>
	<h2>축하합니다.</h2>
	<h1>입력에 성공했습니다.</h1>
	
	<p>아이디 : <%=id%></p>
	<p>비밀번호 : <%=pw%></p>
</body>
</html>