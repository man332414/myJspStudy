<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Processing</title>
</head>
<body>
	<%
		String id = (String)request.getAttribute("id");
		String password = (String)request.getAttribute("password");
		String name = (String)request.getAttribute("name");
		String phone = (String)request.getAttribute("phone");
		String sex = (String)request.getAttribute("sex");
		String[] hobby = (String[])request.getAttribute("hobby");
		String comment = (String)request.getAttribute("comment");
	%>
	
	<p>가입 정보</p>
	<p>아이디 : <%=id %></p>	
	<p>비밀번호 : <%=password %></p>
	<p>이름 : <%=name %>
	<p>연락처 : <%=phone %>
	<p>성별 : <%=sex %></p>
	<p>취미 : <%
		if(hobby != null)
		{
			for(int i = 0; i<hobby.length; i++)
			{
				out.print(" " + hobby[i]);
			}
		}
	%></p>	
	<p>가입인사 : <%= comment %></p>
	
	<p><a href = "home">home</a></p>
</body>
</html>