<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "DTO.member_DTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All components</title>
</head>
<body>
	<%
		ArrayList<member_DTO> arr = (ArrayList<member_DTO>)request.getAttribute("list");
	%>
	
	<h1>회원명단</h1>
	<a href = "/login_CRUD">호므로</a>
	<table>
		<tr>
			<td>아이디</td><td>패스워드</td><td>나이</td><td>수정</td><td>삭제</td>
		</tr>
		<%
			for(int i = 0; i<arr.size(); i++)
			{
				member_DTO dto = arr.get(i);
				String id = dto.getId();
				String pw = dto.getPw();
				int age = dto.getAge();
		%>
		<tr>
			<td><%=id%></td>
			<td><%=pw%></td>
			<td><%=age%></td>
			<td><a href = "update?id=<%=id%>">수정</a></td>
			<td><a href = "delete?id=<%=id%>">삭제</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>