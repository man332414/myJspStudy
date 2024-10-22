<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		session = request.getSession();
		
		Enumeration en = session.getAttributeNames();
		String name;
		String value;
		int i = 0;
		while(en.hasMoreElements())
		{
			name = en.nextElement().toString();
			value = (String)session.getAttribute(name);
			i++;
	%>
	<p>세션이 갖고 있는 친구들 [<%=i%>] : <%=name %></p>
	<p>세션이 갖고 있는 친구들 [<%=i%>] : <%=value %></p>
	<%} %>
	<%@include file = "session_footer.jsp" %>
</body>
</html>