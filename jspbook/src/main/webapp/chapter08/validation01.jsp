<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>
<body>
	<form action="8_1" method = "post">
		<p> 아이디 : <input type = "text" name = "id" id = "id"></p>
		<p> 비밀번호 : <input type = "password" name = "passwd" id = "passwd"></p>
		<p><input type = "submit" value = "전송" id = "summit"></p>
	</form>
	<a href = "home">home</a>
</body>
<script>
	var summit = document.querySelector("#summit");
	summit.addEventListener("click", checkForm);
	function checkForm()
	{
		var id = document.querySelector("#id").value;
		var pw = document.querySelector("#passwd").value;
		console.log(id);
		console.log(pw);
		alert("아이디 : " + id + "\n"	+ "비밀번호 : " + pw + "\n니 비밀번호 내가 다 털었지롱");
	}
</script>
</html>