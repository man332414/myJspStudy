<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<h4>---- 세션을 삭제하기 전 -----</h4>
	<% 		
		String name;
		String value;
		
		Enumeration en = session.getAttributeNames();
		int i = 0;
		
		while(en.hasMoreElements())
		{
			name = en.nextElement().toString();
			value = (String)session.getAttribute(name);
			i++;
	%>
			<p>세션이 갖고 있는 친구들 [<%=i%>] : <%=name %></p>
			<p>세션이 갖고 있는 친구들 [<%=i%>] : <%=value %></p>
	<%
		}
		
		session.removeAttribute("id");
	%>
	
		<h4>---- 세션을 삭제한 후 -----</h4>
	<% 				
		en = session.getAttributeNames();
		i = 0;
		
		while(en.hasMoreElements())
		{
			name = en.nextElement().toString();
			value = (String)session.getAttribute(name);
			i++;
	%>
			<p>세션이 갖고 있는 친구들 [<%=i%>] : <%=name %></p>
			<p>세션이 갖고 있는 친구들 [<%=i%>] : <%=value %></p>
	<%
		}
	%>
	<%@include file = "session_footer.jsp" %>
</body>
</html>