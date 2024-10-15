<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String name = (String)request.getAttribute("name0");
		String subject = (String)request.getAttribute("name1");
		String fileFieldName = (String)request.getAttribute("fileFieldName");
		String fileName = (String)request.getAttribute("fileName");
		String contentType = (String)request.getAttribute("contentType");
		long fileSize = (long)request.getAttribute("fileSize");
		out.print("이름 : " + name + "<br>");
		out.print("제목 : " + subject + "<br>");
		out.print("------------------------------------<br>");
		out.print("요청 파라미터 이름 : " + fileFieldName + "<br>");
		out.print("저장 파일 이름 : " + fileName + "<br>");
		out.print("파일 컨텐츠 유형 : " + contentType + "<br>");
		out.print("파일 크기 : " + fileSize);
	%>
</body>
</html>