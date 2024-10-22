<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<h4>---- 세션을 삭제하기 전 ----</h4>
	<%
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		
		
		if(request.isRequestedSessionIdValid()==true)
		{
			out.print("설정된 세션 이름 id : " + id + "<br>");
			out.print("설정된 세션 이름 pw : " + pw + "<br>");
			out.print("세션이 유효합니다." + "<br>");
		}
		else
		{
			out.print("유효한 세션이 없습니다.");
		}
		
		session.invalidate();
	%>
	<h4>---- 세션을 삭제 후 ----</h4>
	<%
		
		if(request.isRequestedSessionIdValid()==true)
		{
			out.print("설정된 세션 이름 id : " + id + "<br>");
			out.print("설정된 세션 이름 pw : " + pw + "<br>");
			out.print("세션이 유효합니다." + "<br>");
		}
		else
		{
			out.print("유효한 세션이 없습니다." + "<br>");
		}
	%>
	<%@include file = "session_footer.jsp" %>
</body>
</html>