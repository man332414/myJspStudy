<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>
<body>
	<form action = "8_5" method = "post" id = "form">
		<p>아이디 : <input type = "text" name = "id" id = "id"></p>
		<p>비밀번호 : <input type = "password" name = "passwd" id = "passwd"></p>
		<p>이름 : <input type = "text" name = "name" id = "name"></p>
		<p>전화번호 : <select name = "phone1" id = "phone1">
			<option value = "010">010</option>
			<option value = "011">011</option>
			<option value = "016">016</option>
			<option value = "018">018</option>
			<option value = "019">019</option>
		</select>
		 - <input type = "text" name = "phone2" id="phone2" size = "4" maxlength = "4">
		 - <input type = "text" name = "phone3" id="phone3" size = "4" maxlength = "4"></p>
		<p>이메일 : <input type = "text" name = "email" id = "email"></p>
		<p><input type = "button" value = "제출" id = "btn"></p>
	</form>
</body>
<script>
	let btn = document.querySelector("#btn");
	btn.addEventListener("click", checkMember);
	
	function checkMember()
	{
		//console.log("dusruf");
		let regExpId = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		let regExpName = /^[가-힣]*$/;
		let regExpPasswd = /^[0-9]*$/;
		let regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/;
		let regExpEmail = /^[0-9a-zA-Z]([-_\.]?)[0-9a-zA-Z]*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		
		let form = document.querySelector("#form");
		let id = document.querySelector("#id").value;
		console.log(id)
		let pw = document.querySelector("#passwd").value;
		console.log(pw)
		let name = document.querySelector("#name").value;
		console.log(name)
		let phone1 = document.querySelector("#phone1").value;
		console.log(phone1)
		let phone2 = document.querySelector("#phone2").value;
		console.log(phone2)
		let phone3 = document.querySelector("#phone3").value;
		console.log(phone3)
		let phone = phone1+"-"+phone2+"-"+phone3;
		console.log(phone)
		let email = document.querySelector("#email").value;
		console.log(email)
		
		
		if(!regExpId.test(id))
		{
			alert("아이디는 문자로 시작해 주세요");
			form.id.select();
			return;
		}
		if(!regExpName.test(name))
		{
			alert("이름은 한글만 입력해 주세요!");
			return;
		}
		if(!regExpPasswd.test(pw))
		{
			alert("비밀번호는 외우기 쉽게 숫자만 입력하세요");
			return;
		}
		if(!regExpPhone.test(phone))
		{
			alert("연락처 입력 똑바로 해주세요");
			return;
		}
		if(!regExpEmail.test(email))
		{
			alert("이메일 입력을 확인해 주세요");
			return;
		}
		form.submit();
	}
</script>
</html>