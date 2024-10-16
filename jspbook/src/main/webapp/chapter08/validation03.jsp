<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>
<body>
	<form action = "8_3" method = "post" id = "form">
		<p>아이디 : <input type = "text" name = "id" id = "id"></p>
		<p>비밀번호 : <input type = "password" name = "passwd" id = "passwd"></p>
		<p><input type = "button" value = "전송" id = "btn"></p>
	</form>
</body>
<script>
	let btn = document.querySelector("#btn");
	
		
	btn.addEventListener("click", checkLogin)
	
	function checkLogin()
	{		
		console.log("연결");
		let form = document.querySelector("#form");
		let id = document.querySelector("#id");
		let idlen = id.value.length;
		let pw = document.querySelector("#passwd");
		let pwlen = pw.value.length;
		console.log(form);
		console.log(idlen);
		console.log(pwlen);
		console.log(id.value);
		console.log(pw.value);
		if (idlen < 4 || idlen >12)
		{
			alert("아이디는 4 ~ 12자 이내로 입력 가능합니다!");
			id.select();
			return;
		}
		if (pwlen < 4)
		{
			alert("비밀번호는 4자 이상 입력 해야합니다!");
			pw.select();
			return;
		}
		if(!isNaN(id.value.substr(0,1)))
		{
			alert("이름은 숫자로 시작할 수 없습니다.");
			id.select();
			return;
		}
		form.submit();
	}
	
</script>
</html>