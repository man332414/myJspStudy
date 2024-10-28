<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "DTO.exam_DTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update member</title>
</head>
<body>
	<%
		exam_DTO dto = (exam_DTO)request.getAttribute("dto");
	
		String id = dto.getId();
		String pw = dto.getPassword();
		String name = dto.getName();
	%>

	<form action="16_7" method = "post">
		<p>아이디 : <input type = "text" name = "id" value = "<%=id %>" readonly></p>
		<p>비밀번호 : <input type = "text" name = "pw" value = "<%=pw %>"></p>
		<p>이름 : <input type = "text" name = "name" value = "<%=name %>"></p>
		<p><input type = "submit" value = "수정"></p>
	</form>
</body>
</html>