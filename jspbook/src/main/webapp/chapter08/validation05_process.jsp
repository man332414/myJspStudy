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
		String name = (String)request.getAttribute("name");
		String pw = (String)request.getAttribute("pw");
		String phone = (String)request.getAttribute("phone");
		String email = (String)request.getAttribute("email");	
	%>
	<h3>축하합니다. <%=name%>님</h3> 
	<h1>로그인 되었습니다.</h1>
	
	<p>아이디 : <%=id %></p>
	<p>이름 : <%=name %></p>
	<p>비밀번호 : <%=pw %></p>
	<p>전화번호 : <%=phone %></p>
	<p>이메일 : <%=email %></p>
</body>
</html>