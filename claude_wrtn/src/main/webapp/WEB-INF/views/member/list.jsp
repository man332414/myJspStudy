<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2>회원 목록</h2>
            <div>
                <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">메인으로</a>
                <a href="${pageContext.request.contextPath}/member/form" class="btn btn-primary">새 회원 등록</a>
            </div>
        </div>
        
        <!-- 회원 목록 테이블 -->
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>사용자명</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>전화번호</th>
                    <th>관리</th> <!-- 관리 버튼을 위한 열 -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="member" items="${members}"> <!-- 회원 목록 반복 -->
                    <tr>
                        <td>${member.id}</td> <!-- 회원 ID -->
                        <td>${member.username}</td> <!-- 사용자명 -->
                        <td>${member.name}</td> <!-- 이름 -->
                        <td>${member.email}</td> <!-- 이메일 -->
                        <td>${member.phone}</td> <!-- 전화번호 -->
                        <td>
                            <a href="${pageContext.request.contextPath}/member/view?id=${member.id}" class="btn btn-sm btn-info">상세보기</a>
                            <a href="${pageContext.request.contextPath}/member/form?id=${member.id}" class="btn btn-sm btn-warning">수정</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
