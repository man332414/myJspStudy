<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "dto.Book" %>
<%@ page import = "dao.BookRepository" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<%
		String cartId = session.getId();
	%>
	<title>장바구니</title>
</head>
<body>
	<div class = "container py-4">
		<%@ include file = "menu.jsp" %>
		<div class = "p-5 mb-4 by-body-tertiary rounded-3">
			<div class = " container-fluid py-5">
				<h1 class = "display-5">장바구니</h1>
				<p class = "col-md-8 fs-4">Cart</p>
			</div>
		</div>
		
		<div class = "row align-items-md-stretch">
			<div class = "row">
				<table width = "100%">
					<tr>
						<td align = "left"><a href = "resetCart" class = "btn btn-danger">모두 삭제하기</a></td>
						<td align = "right"><a href = "shippingInfo" class = "btn btn-success">주문하기</a></td>
					</tr>
				</table>
				<div style = "padding-top:50px">
					<table class = "table table-hover">
						<tr>
							<th>도서</th>
							<th>가격</th>
							<th>수량</th>
							<th>소계</th>
							<th>비고</th>
						</tr>
						<%
							int sum = 0;
							ArrayList<Book> cartList = (ArrayList<Book>)session.getAttribute("cartlist");
							
							if(cartList==null)
							{
								cartList = new ArrayList<Book>();
							}
							
							for(int i = 0; i<cartList.size(); i++)
							{
								Book book = cartList.get(i);
								int total = book.getUnitPrice() * book.getQuantity();
								sum += total;
						%>
						<tr>
							<td><%=book.getBookId() %> - <%=book.getBookname() %></td>
							<td><%=book.getUnitPrice() %></td>
							<td><%=book.getQuantity() %></td>
							<td><%=total %></td>
							<td><a href = "removeCart?id=<%=book.getBookId() %>" class = "badge text-bg-danger">삭제</a></td>
						</tr>
						<%
							}
						%>
						<tr>
							<th></th>
							<th></th>
							<th>총액</th>
							<th><%=sum %></th>
							<th></th>
						</tr>
					</table>
					<a href = "bookList" class = "btn btn-secondary">&laquo; 쇼핑 계속하기</a>
				</div>
			</div>
		</div>
		<%@ include file = "footer.jsp" %>
	</div>
</body>
</html>