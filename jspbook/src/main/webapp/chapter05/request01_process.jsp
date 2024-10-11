<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String userId = (String)request.getAttribute("id");
		String userPasswd = (String)request.getAttribute("passwd");
	%>
	<p>아 이 디 : <%=userId%></p>
	<p>비밀번호 : <%=userPasswd%></p>
</body>
</html>