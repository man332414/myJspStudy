<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어서와 집이야</title>
</head>
<body>
	실습 리스트
	<div style = "display : flex; justify-content : left;">
		<div>
			<p><a href = "2_1"> 선언문 태그 예제 2-1</a></p>
			<p><a href = "2_2"> 선언문 태그 예제 2-2</a></p>
			<p><a href = "2_3"> 선언문 태그 예제 2-3</a></p>
			<br>
			<p><a href = "2_4"> 스크립틀릿 태그 예제 2-4</a></p>
			<p><a href = "2_5"> 스크립틀릿 태그 예제 2-5</a></p>
			<br>
			<p><a href = "2_6"> 표현문 태그 예제 2-6</a></p>
			<p><a href = "2_7"> 표현문 태그 예제 2-7</a></p>
		</div>
		<hr>
		<div>
			<p><a href = "3_1"> page 디렉티브 태그 예제 3-1</a></p>
			<p><a href = "3_2"> page 디렉티브 태그 예제 3-2</a></p>
			<p><a href = "3_3"> page 디렉티브 태그 예제 3-3</a></p>
			<p><a href = "3_4"> page 디렉티브 태그 예제 3-4</a></p>
			<p><a href = "3_6"> page 디렉티브 태그 예제 3-6</a></p>
			<p><a href = "3_7"> page 디렉티브 태그 예제 3-7</a></p>
			<p><a href = "3_9"> page 디렉티브 태그 예제 3-9</a></p>
			<p><a href = "3_10"> page 디렉티브 태그 예제 3-10</a></p>
			<p><a href = "3_11"> page 디렉티브 태그 예제 3-11</a></p>
		</div>
		<hr>
		<div>
			<p><a href = "4_1"> forward 액션 태그 예제 4-1</a></p>
			<p><a href = "4_2"> include 액션 태그 예제 4-2</a></p>
			<p><a href = "4_3"> param 액션 태그 예제 4-3</a>
			<p><a href = "4_4"> param 액션 태그 예제 4-4</a>
			<p><a href = "4_6"> useBean 액션 태그 예제 4-6</a></p>
			<p><a href = "4_7"> useBean 액션 태그 예제 4-7</a></p>
			<p><a href = "4_8"> useBean 액션 태그 예제 4-8</a></p>
			<p><a href = "4_9"> setProperty 액션 태그 예제 4-9</a></p>
			<p><a href = "4_10"> getProperty 액션 태그 예제 4-10</a></p>
			<p><a href = "4_11"> getProperty 액션 태그 예제 4-11</a></p>
		</div>
		<div>
			<form action = "5_1">
			<table>
				<tr><th>아이디</th> <td><input type = "text" name = "id" /></td></tr>
				<tr><th>비밀번호</th> <td><input type = "password" name = "passwd" /></td></tr>
				<tr><th colspan = "2"><input type = "submit" value = "전송" /></th></tr>
			</table>
			</form>
			<p><a href = "5_2">request 내장객체 예제 5-2</a></p>
			<p><a href = "5_3">request 내장객체 예제 5-3</a></p>
		</div>
	</div>
	<% 
		String id = "admin";
		String name = "송근형";
	%>
	<p><a href = "4_0?id=<%=id%>&name=${name}"> useBean 액션 태그 예제 4-8</a></p>
	
</body>
</html>