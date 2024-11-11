<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 ${empty member.id ? '등록' : '수정'}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2>회원 ${empty member.id ? '등록' : '수정'}</h2>
            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">메인으로</a>
        </div>
        
        <!-- 에러 메시지 표시 -->
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        
        <!-- 회원 정보 입력 폼 -->
        <form action="${pageContext.request.contextPath}/member/${empty member.id ? 'create' : 'update'}" method="post" class="mt-3">
            <c:if test="${not empty member.id}">
                <input type="hidden" name="id" value="${member.id}"> <!-- 수정 모드에서 ID 필드 숨김 -->
            </c:if>
            
            <div class="mb-3">
                <label for="username" class="form-label">사용자명</label>
                <input type="text" class="form-control" id="username" name="username" value="${member.username}" required>
            </div>
            
            <div class="mb-3">
                <label for="password" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="${not empty member.id ? '변경하지 않으려면 비워두세요' : ''}">
                <small class="form-text text-muted">비밀번호는 6자 이상이어야 합니다.</small>
            </div>
            
            <div class="mb-3">
                <label for="name" class="form-label">이름</label>
                <input type="text" class="form-control" id="name" name="name" value="${member.name}" required>
            </div>
            
            <div class="mb-3">
                <label for="email" class="form-label">이메일</label>
                <input type="email" class="form-control" id="email" name="email" value="${member.email}" required>
            </div>
            
            <div class="mb-3">
                <label for="phone" class="form-label">전화번호</label>
                <input type="tel" class="form-control" id="phone" name="phone" value="${member.phone}">
            </div>
            
            <button type="submit" class="btn btn-primary">저장</button>
            <a href="${pageContext.request.contextPath}/member/list" class="btn btn-secondary">취소</a>
        </form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
