<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
		<header class = "pb-3 mb-4 border-bottom d-flex">
			<a href = "home" class = "d-flex align-items-center text-dark text-decoration-none mx-3">
			<svg  width="32" height="32" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
	              <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
	              <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
	        </svg>
				<span class = "fs-4">Home</span>
			</a>
			<ul class = "nav nav-pills align-item-right">
				<!-- R : 전체상품 가져오기 -->
				<li class = "nav-item"><a href = "bookList" class = "nav-link">BookList</a></li>
				<!-- C : 상품입력 -->
				<li class = "nav-item"><a href = "addBook" class = "nav-link">AddBook</a></li>
				<!-- U : 상품 수정 -->
				<li class = "nav-item"><a href = "editBook?edit=update" class = "nav-link">EditBook</a></li>
				<!-- D : 상품 삭제 -->
				<li class = "nav-item"><a href = "editBook?edit=delete" class = "nav-link">DeleteBook</a></li>
			</ul>
			
		</header>

</body>
</html>