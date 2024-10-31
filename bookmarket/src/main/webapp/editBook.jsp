<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "dto.Book" %>
<!DOCTYPE html>
<html>
<head>
	<link rel = "stylesheet" href = "./resources/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>도서 편집</title>
</head>
<body>
<div class = "container py-4">
	<%@ include file = "menu.jsp" %>
	<div class = "p-5 mb-4 bg-body-tertiary rounded-3">
		<div class = "container-fluid py-5">
			<h1 class = "display-5 fw-bold">도서 편집</h1>
			<p class = "col-md-8 fs-4">Book Editing</p>
		</div>
	</div>
	<%
		ArrayList<Book> listOfBooks = (ArrayList<Book>)request.getAttribute("arr");
		String edit = (String)request.getAttribute("edit");
		Book book = null;
	%>
	<div class = "row align-items-md-stretch text-center">
		<%
			for(int i=0; i<listOfBooks.size(); i++)
			{
				book = listOfBooks.get(i);
		%>
				<div class = "col-md-4">
					<div class = "h-100 p-2">
						<img src = "./resources/images/<%=book.getFilename()%>" style = "width : 250px; height : 350px;">
						<h5><b><%=book.getBookname()%></b></h5>
						<p><%=book.getAuthor()%>
						<br><%=book.getPublisher()%> | <%=book.getUnitPrice()%>원
						</p>
						<p><%=book.getBookdescription()%>...</p>
						<p><%=book.getUnitPrice()%>원</p>
						<p>
						<%
							if(edit.equals("update"))
							{
						%> 
						<a href = "updateBook?id=<%=book.getBookId() %>" class = "btn btn-success" role = "button">
						수정 &raquo;</a></p>
						<%
							}
							else if(edit.equals("delete"))
							{
						%>
						<p><a href = "#" class = "btn btn-danger" role = "button" onclick = "deleteConfirm('<%=book.getBookId() %>')">
						삭제 &raquo;</a></p>
						<%
							}
						%>
					</div>
				</div>
		<%
			}
		%>
	</div>
	<%@ include file = "footer.jsp" %>
</div>
<script type="text/javascript">
	function deleteConfirm(id)
	{
		console.log(id);
		if(confirm("해당도서를 삭제합니다 !!")==true)
			{
				location.href = "deletebook?id=" + id;
			}
		else
			{
			return;
			}
	}
</script>
</body>
</html>