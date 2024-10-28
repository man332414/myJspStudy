<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "DTO.exam_DTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member list</title>
</head>
<body>
	<%
		ArrayList<exam_DTO> arr = (ArrayList<exam_DTO>)request.getAttribute("arr");
	%>
	<table width = "300" border = "1">
		<tr>
		<th>ID</th><th>PW</th><th>NAME</th><th>수정</th><th>삭제</th>
		</tr>
		<%
			for(int i = 0; i < arr.size(); i++)
			{
				exam_DTO dto = arr.get(i);
				
				String id = dto.getId();
				String pw = dto.getPassword();
				String name = dto.getName();
		%>
		<tr>
			<td><%=id %></td><td><%=pw %></td><td><%=name %></td><td><a href = "16_7?id=<%=id%>">수정</a></td><td><a href = "16_8?id=<%=id%>">삭제</a></td>
		</tr>
		<%
			}
		%>
		<tr></tr>
	</table>
	<p><a href = "16_3">폼으로 가기</a></p>
</body>
</html>