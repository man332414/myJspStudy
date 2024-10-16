<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>
<body>
	<form action = "8_2" method = "post" id = "form">
		<p>아이디 : <input type = "text" name = "id" id = "id"></p>
		<p>비밀번호 : <input type = "password" name = "passwd" id = "passwd"></p>
		<p><input type = "button" value = "전송" id = "button"></p>
	</form> 
</body>
<script>
	let btn = document.querySelector("#button");
	btn.addEventListener("click", checkLogin);
	
	function checkLogin()
	{
		let id = document.querySelector("#id");
		let passwd = document.querySelector("#passwd");
		let form = document.querySelector("#form")
		console.log(id);
		console.log(passwd.value);
		console.log(form);		
		
		if(id.value == "")
		{
			alert("아이디를 입력해 주세요");
			id.focus()
			return false
		}
		else if(passwd.value == "")
		{
			alert("비밀번호를 입력해 주세요");
			passwd.focus()
			return false
		}
		form.submit();
	}
</script>
</html>