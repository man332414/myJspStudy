<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.oreilly.servlet.*" %>
<%@ page import = "com.oreilly.servlet.multipart.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String name = (String)request.getAttribute("name");
	String subject = (String)request.getAttribute("subject");
	String file = (String)request.getAttribute("file");
%>
<p> 이름 : <%=name %> </p>
<p> 제목 : <%=subject %> </p>
<p> 파일 : <img src = "img/<%=file%>">

</body>
</html>
