<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "DTO.member_DTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User update</title>
</head>
<body>
	<%
		member_DTO dto = (member_DTO)request.getAttribute("DTO");
	%>
	<form action="update" method = "post">
		<p>아이디 : <input type = "text" name = "id" readonly value = "<%=dto.getId() %>"></p>
		<p>비밀번호 : <input type = "text" name = "pw" value = "<%=dto.getPw() %>"></p>
		<p>나이 : <input type = "text" name = "age" value = "<%=dto.getAge() %>"></p>
		<p><input type = "submit" value = "수정"></p>
	</form>
</body>
</html>