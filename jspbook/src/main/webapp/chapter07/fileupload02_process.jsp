<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Process</title>
</head>
<body>
	<%
		String name1 = (String)request.getAttribute("name1");
		String subject1 = (String)request.getAttribute("subject1");
		String file1 = (String)request.getAttribute("file1");
		String name2 = (String)request.getAttribute("name2");
		String subject2 = (String)request.getAttribute("subject2");
		String file2 = (String)request.getAttribute("file2");
		String name3 = (String)request.getAttribute("name3");
		String subject3 = (String)request.getAttribute("subject3");
		String file3 = (String)request.getAttribute("file3");
		
	%>
	<table>
		<tr>
			<th width = "100px">이름</th>
			<th width = "100px">제목</th>
			<th width = "100px">파일</th>	
		</tr>
		<tr>
			<% 
				out.print("<td>" + name1 + "</td>");
				out.print("<td>" + subject1 + "</td>");
				out.print("<tr><td>" + name2 + "</td>");
				out.print("<td>" + subject2 + "</td>");
				out.print("<tr><td>" + name3 + "</td>");
				out.print("<td>" + subject3 + "</td>");
			%>
		</tr>
		<tr>
			<td rowspan = "2"><img src = "img/<%=file1%>" width = "100px"></td>
			<td rowspan = "2"><img src = "img/<%=file2%>" width = "100px"></td>
			<td rowspan = "2"><img src = "img/<%=file3%>" width = "100px"></td>
		</tr>
				
	</table>
</body>
</html>