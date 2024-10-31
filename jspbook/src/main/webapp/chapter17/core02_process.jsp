<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int number = (int)request.getAttribute("num");
	%>
	
	<c:set var = "number" value = "<%=number%>" />
	<c:choose>
		<c:when test = "${number%2==0}">
			<c:out value = "${number}" /> 은 짝수 입니다.
		</c:when>
		<c:when test = "${number%2==1}">
			<c:out value = "${number}" /> 은 홀수 입니다.
		</c:when>
		<c:otherwise> 숫자가 아닙니다.</c:otherwise>
	</c:choose>
	
	<p><a href = "17_2">또 하세요</a></p>
</body>
</html>