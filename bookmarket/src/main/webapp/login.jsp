<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<title>Login</title>
</head>
<body>
	<div class = "container py-4">
		<%@include file = "menu.jsp" %>
		
		<div class = "p-5 mb-4 bg-body-tertiary rounded-3">
			<div class = "container-fluid py-5">
				<h1 class = "dispaly-5 fw-bold">로그인</h1>
				<p class = "col-md-8 fs-4">Login</p>
			</div>
		</div>
		
		<div class = "row align-items-md-stretch text-center">
			<div class = "row justify-content-center align-items-center">
				<div class = "h-100 p-5 col-md-6">
					<h3>Please sign in</h3>
					<%
						String error = request.getParameter("error");
						if(error != null)
						{
							out.print("<div class = 'alert alert-danger'>");
							out.print("아이디와 비밀번호를 확인해 주세요");
							out.print("</div>");
						}
					%>
					
					<form action = "j_security_check" method = "post" class = "form-signin">
						<div class = "form-floating mb-3 row">
							<input type = "text" name = "j_username" required autofocus class ="form-control">
							<label for = floatingInput>ID</label>
						</div>
						<div class = "form-floating mb-3 row">
							<input type = "password" name = "j_password" class = "form-control">
							<label for = floatingInput>Password</label>
						</div>
						<button type = "submit" class = "btn btn-lg btn-success">로그인</button>
					</form>
				</div>
			</div>
		</div>
		<%@include file = "footer.jsp" %>
	</div>
</body>
</html>