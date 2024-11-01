<%@page import="dto.Member"%>
<%@ page session = "false" %>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="/bookmarket/resources/css/bootstrap.min.css" />
<script type="text/javascript">
	function checkForm() {
		if (!document.newMember.id.value) {
			alert("아이디를 입력하세요.");
			return false;
		}

		if (!document.newMember.password.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}

		if (document.newMember.password.value != document.newMember.password_confirm.value) {
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}
	}
	
	function cencle()
	{
		location.href = "/bookmarket"
	}
</script>
<title>회원 정보 수정</title>
</head>
<body>
<%
	Member mb = (Member)request.getAttribute("mb");
	
	String email = mb.getMail();
	String[] D_email = email.split("@");
	
	String birth = mb.getBirth();
	String[] D_birth = birth.split("/");
%>
<div class="container py-4">
   <jsp:include page="/menu.jsp" />

 <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">회원 정보 수정</h1>
        <p class="col-md-8 fs-4">Membership Update</p>      
      </div>
    </div>
	

   <div class="row align-items-md-stretch   text-center">
		<form name="newMember"  action="member_update" method="post" onsubmit="return checkForm()">
			<div class="mb-3 row">
				<label class="col-sm-2 ">아이디</label>
				<div class="col-sm-3">
					<input name="id" type="text" class="form-control" placeholder="id" value = "<%=mb.getId()%>" readonly>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">비밀번호</label>
				<div class="col-sm-3">
					<input name="password" type="text" class="form-control" placeholder="password" value = "<%=mb.getPassword() %>" >
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">비밀번호확인</label>
				<div class="col-sm-3">
					<input name="password_confirm" type="text" class="form-control" placeholder="password confirm" >
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">성명</label>
				<div class="col-sm-3">
					<input name="name" type="text" class="form-control" placeholder="name" value = "<%=mb.getName()%>" >
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">성별</label>
				<div class="col-sm-2">
				<%
					if(mb.getGender() == "남")
					{
				%>
						<input name="gender" type="radio" value="남" checked/> 남 
						<input name="gender" type="radio" value="여" /> 여
				<%
					}
					else
					{
				%>
						<input name="gender" type="radio" value="남" /> 남 
						<input name="gender" type="radio" value="여" checked/> 여
				<%
					}
				%>
				</div>
			</div>
			
			<div class="mb-3 row">
				<label class="col-sm-2">생일</label>
				<div class="col-sm-10  ">
				  <div class="row">
				  	<div class="col-sm-2">
						<input type="text" name="birthyy" maxlength="4"  class="form-control" placeholder="년(4자)" size="6" value = "<%=D_birth[0]%>"> 
					</div>
					<div class="col-sm-2">
					<select name="birthmm" class="form-select">
						<option value="">월</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select> 
					</div>
					<div class="col-sm-2">
					<input type="text" name="birthdd" maxlength="2" class="form-control" placeholder="일" size="4" value = "<%=D_birth[2]%>">
					</div>
				</div>
				</div>
			</div>
			
		<div class="mb-3 row">
			<label class="col-sm-2">이메일</label>
				<div class="col-sm-10">
				  <div class="row">
					<div class="col-sm-4">
						<input type="text" name="mail1" maxlength="50" class="form-control"  placeholder="email" value = "<%=D_email[0]%>">
					</div> @
					<div class="col-sm-3">
						 <select name="mail2" class="form-select">
							<option>naver.com</option>
							<option>daum.net</option>
							<option>gmail.com</option>
							<option>nate.com</option>
						</select>
					</div>
				</div>		
			</div>		
		</div>
			<div class="mb-3 row">
				<label class="col-sm-2">전화번호</label>
				<div class="col-sm-3">
					<input name="phone" type="text" class="form-control" placeholder="phone" value = "<%=mb.getPhone()%>" >

				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 ">주소</label>
				<div class="col-sm-5">
					<input name="address" type="text" class="form-control" placeholder="address" value = "<%=mb.getAddress()%>">

				</div>
			</div>
			<div class="mb-3 row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" class="btn btn-primary " value="업데이트 " > 
					<input type="reset" class="btn btn-primary " value="취소 " onclick="reset()" >
				</div>
			</div>
		</form>
	</div>
	
		   <jsp:include page="/footer.jsp" />  
  </div>	
</body>
</html>