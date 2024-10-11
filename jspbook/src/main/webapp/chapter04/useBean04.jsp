<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
</head>
<body>
	<jsp:useBean id = "person" class = "chapter04.Person" scope = "session" />
	<p> 아이디 : <%=person.getId() %></p>
	<p> 아이디 : <%=person.getName() %></p>
	
	<%
		person.setId(20230824);
		person.setName("홍길동");
	%>
	
	<jsp:include page = "useBean03.jsp"></jsp:include>
</body>
</html>