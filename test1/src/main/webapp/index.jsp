<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<form action = "2_1" method = "post" enctype = "multipart/form-data">
		<p>이름 : <input type = "text" name = "name" placeholder = "이름을 작성하세요"></p>
		<p>아이디 : <input type = "text" name = "id" placeholder = "ID를 작성하세요"></p>
		<p>비밀번호 : <input type = "password" name = "pw" placeholder = "password를 작성하세요"></p>
		<p>파일 : <input type = "file" name = filename></p>
		<p><input type = "submit" value = "제출"></p>
	</form>
</body>
</html>