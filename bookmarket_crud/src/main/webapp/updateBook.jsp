<%@ page import="dto.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<link rel = "stylesheet" href = "./resources/css/bootstrap.min.css" />
	<meta charset="UTF-8">
	<title>도서 수정</title>
</head>
<body>
	<%
		Book book = (Book)request.getAttribute("book");
	%>
	<fmt:bundle basename = "bundle.message">
	<div class = "container py-4">
		<%@ include file = "menu.jsp" %>
		
		<div class = "p-5 mb-4 bg-body-tertiary rounded-3">
			<div class = "container-fluid py-5">
				<h1 class = "display-5 fw-bold">도서 수정</h1>
				<p class = "col-md-8 fs-4">Book Updating</p>
			</div>
		</div>
		
		<div class = "row align-items-md-stretch">
			<div class = "col-md-5">
				<img alt="image" src="./resources/images/<%=book.getFilename()%>" style = "width : 100%" />
			</div>
			<div class = "col-md-7">
				<form action = "updateBook" method = "post" enctype = "multipart/form-data" class = "form-horizontal" id = "form">
					<div class = "mb-3 row">
						<label class = "col-sm-2"><fmt:message key = "bookId" /></label>
						<div class = "col-sm-5">
							<input type = "text" name = "bookId" id = "bookId" value = "<%=book.getBookId() %>" readonly>
						</div>
					</div>
					<div class = "mb-3 row">
						<label class = "col-sm-2"><fmt:message key = "name" /></label>
						<div class = "col-sm-5">
							<input type = "text" name = "name" id = "name" value = "<%=book.getBookname() %>">
						</div>
					</div>
					<div class = "mb-3 row">
						<label class = "col-sm-2"><fmt:message key = "unitPrice" /></label>
						<div class = "col-sm-5">
							<input type = "text" name = "unitPrice" id = "unitPrice" value = "<%=book.getUnitPrice() %>">
						</div>
					</div>
					<div class = "mb-3 row">
						<label class = "col-sm-2"><fmt:message key = "author" /></label>
						<div class = "col-sm-5">
							<input type = "text" name = "author" id = "author" value = "<%=book.getAuthor() %>">
						</div>
					</div>
					<div class = "mb-3 row">
						<label class = "col-sm-2"><fmt:message key = "publisher" /></label>
						<div class = "col-sm-5">
							<input type = "text" name = "publisher" id = "publisher" value = "<%=book.getPublisher() %>">
						</div>
					</div>
					<div class = "mb-3 row">
						<label class = "col-sm-2"><fmt:message key = "releaseDate" /></label>
						<div class = "col-sm-5">
							<input type = "text" name = "releaseDate" id = "releaseDate" value = "<%=book.getReleaseDate() %>">
						</div>
					</div>
					<div class = "mb-3 row">
						<label class = "col-sm-2"><fmt:message key = "description" /></label>
						<div class = "col-sm-8">
							<textarea name = "description" cols = "50" rows = "2" ><%=book.getBookdescription() %></textarea>
						</div>
					</div>
					<div class = "mb-3 row">
						<label class = "col-sm-2"><fmt:message key = "category" /></label>
						<div class = "col-sm-5">
							<input type = "text" name = "category" id = "category" value = "<%=book.getCategory() %>">
						</div>
					</div>
					<div class = "mb-3 row">
						<label class = "col-sm-2"><fmt:message key = "unitsInStock" /></label>
						<div class = "col-sm-5">
							<input type = "text" name = "unitsInSrock" id = "unitsInSrock" value = "<%=book.getUnitsInStock() %>">
						</div>
					</div>
					<div class = "mb-3 row">
						<label class = "col-sm-2"><fmt:message key = "condition" /></label>
						<div class = "col-sm-5">
							<input type = "radio" name = "condition" value = "New"> <fmt:message key = "condition_New" />
							<input type = "radio" name = "condition" value = "Old"> <fmt:message key = "condition_Old" />
							<input type = "radio" name = "condition" value = "EBook"> <fmt:message key = "condition_Ebook" />
						</div>
					</div>
					<div class = "mb-3 row">
						<label class = "col-sm-2"><fmt:message key = "bookImage" /></label>
						<div class = "col-sm-8">
							<input type = "file" name = "BookImage" class = "form-control">
						</div>
					</div>
					<div class = "mb-3 row">
						<div class = "col-sm-offset-2 col-sm-10">
							<input type = "button" value = "수정" id = "btn">
						</div>
					</div>
				</form>
			</div>
		</div>
		<jsp:include page = "footer.jsp" />
	</div>
	<script type="text/javascript" src = "./resources/js/validation.js"></script>
	</fmt:bundle>
</body>
</html>