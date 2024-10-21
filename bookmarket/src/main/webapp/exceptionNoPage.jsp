<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>페이지 오류</title>
</head>
<body>
	<div class = "jumbotron">
		<div class = "container">
			<jsp:include page = "menu.jsp"></jsp:include>
			<h2 class = "alert alert-danger">요청하신 페이지를 찾을 수 없습니다.</h2>
		</div>
	</div>
	<div class = "container">
		<p><%=request.getRequestURL() %></p>
		<p><a href = "booklist">도서목록</a></p>
	</div>
</body>
</html>