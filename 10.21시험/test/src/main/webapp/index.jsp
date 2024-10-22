<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<jsp:useBean id="sc" class = "java.util.Scanner"  scope = "page" ></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%=new Date() %>
 
     <form method="post" action="result.jsp" enctype="multipart/data-file" >
           <p> 이름 : <input type="text" name="name" >
           <p> 파일명 : <input type="file" name="filename">
           <p> <input type="submit" value="전송">
   </form>
 
</body>
</html>