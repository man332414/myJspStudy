<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp:useBean practice</title>
</head>
<body>
	<jsp:useBean id = "jc" class = "test1.justClass"></jsp:useBean>
	
	<jsp:setProperty property="*" name="jc"/>
	
	<jsp:getProperty property="*" name="jc"/>
	
	<p>ID : <jsp:getProperty property="id" name="jc"/></p>
	<p>Name : <jsp:getProperty property="name" name="jc"/></p>
	<p><a href = "home">home</a></p>
</body>
</html>