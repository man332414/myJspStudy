<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form method="post" action="result.jsp" enctype="multipart/form-data" >
           <p> 이름 : <input type="text" name="name" >
           <p> 파일명 : <input type="file" name="filename">
           <p> <input type="submit" value="전송">
   </form>
</body>
</html>