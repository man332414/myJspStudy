<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>
<body>
	<form action = "8_4" method = "post" id = "form">
		<p>아이디 : <input type = "text" name = "id" id = "id"></p>
		<p>비밀번호 : <input type = "password" name = "passwd" id = "passwd"></p>
		<p><input type = "button" value = "전송" id = "button"></p>
	</form>
</body>
<script>
	let button = document.querySelector("#button");
	console.log(button);
	button.addEventListener("click", checkLogin);
	
	function checkLogin()
	{
		let id = document.querySelector("#id");
		let pw = document.querySelector("#passwd");
		console.log(id);
		console.log(pw);
		let form = document.querySelector("#form");
		
		for(i = 0; i<id.value.length; i++)
		{
			let ch = id.value.charAt(i);			
			if((ch<'a'|| ch>'z')&&(ch>'A' || ch<'Z')&&(ch>'0'||ch<'9'))
			{
				alert("아이디는 영문 소문자만 입력 가능합니다.");
				id.select();
				return;
			}
			if(isNaN(pw.value))
			{
				alert("비밀번호는 숫자만 입력 가능합니다.");
				pw.select();
				return;
			}
			form.submit();
		}
	}
</script>
</html>