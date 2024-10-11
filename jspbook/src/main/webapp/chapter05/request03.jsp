<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object</title>
</head>
<body>
	<p>클라이언트 IP : <%=request.getRemoteAddr() %></p>
	<p>요청 정보 길이 : <%=request.getContentLength() %></p>
	<p>요청 정보 인코딩 : <%=request.getCharacterEncoding() %></p>
	<p>요청 정보 컨텐츠 유형 : <%=request.getContentType() %></p>
	<p>요청 정보 프로토콜 : <%=request.getProtocol() %></p>
	<p>요청 정보 전송 방식 : <%=request.getMethod() %></p>
	<p>요청 URI : <%=request.getRequestURI() %></p>
	<p>콘텍스트 경로 : <%=request.getContextPath() %></p>
	<p>서버이름 : <%=request.getServerName() %></p>
	<p>서버포트 : <%=request.getServerPort() %></p>
	<p>쿼리문 : <%=request.getQueryString() %></p>
	
	<p><a href = "home">home</a></p>
</body>
</html>