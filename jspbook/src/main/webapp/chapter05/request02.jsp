<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object</title>
</head>
<body>
	<table border = "1">
	<tr><th>헤더 이름</th><th>값</th></tr>
	
	<%
		Enumeration en = request.getHeaderNames();
		while(en.hasMoreElements())
		{
			String headerName = (String)en.nextElement();
			String headerValue = (String)request.getHeader(headerName);
	%>
	
	<tr><td><%=headerName%></td><td><%=headerValue%></td></tr>
	
	<%
		}
	%>
	</table>
</body>
</html>