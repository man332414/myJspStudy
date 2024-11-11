<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>회원 정보</h2>
        
        <!-- 에러 메시지 표시 -->
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        
        <div class="card">
            <div class="card-body">
                <!-- 회원의 상세 정보 표시 -->
                <div class="row mb-3">
                    <div class="col-3">
                        <strong>ID:</strong>
                    </div>
                    <div class="col-9">
                        ${member.id} <!-- 회원 ID -->
                    </div>
                </div>
                
                <div class="row mb-3">
                    <div class="col-3">
                        <strong>사용자명:</strong>
                    </div>
                    <div class="col-9">
                        ${member.username} <!-- 사용자명 -->
                    </div>
                </div>
                
                <div class="row mb-3">
                    <div class="col-3">
                        <strong>이름:</strong>
                    </div>
                    <div class="col-9">
                        ${member.name} <!-- 이름 -->
                    </div>
                </div>
                
                <div class="row mb-3">
                    <div class="col-3">
                        <strong>이메일:</strong>
                    </div>
                    <div class="col-9">
                        ${member.email} <!-- 이메일 -->
                    </div>
                </div>
                
                <div class="row mb-3">
                    <div class="col-3">
                        <strong>전화번호:</strong>
                    </div>
                    <div class="col-9">
                        ${member.phone} <!-- 전화번호 -->
                    </div>
                </div>
                
                <div class="row mb-3">
                    <div class="col-3">
                        <strong>가입일:</strong>
                    </div>
                    <div class="col-9">
                        ${member.createdAt} <!-- 가입일 -->
                    </div>
                </div>
                
                <div class="row mb-3">
                    <div class="col-3">
                        <strong>수정일:</strong>
                    </div>
                    <div class="col-9">
                        ${member.updatedAt} <!-- 수정일 -->
                    </div>
                </div>
            </div>
        </div>
        
        <div class="mt-3">
            <a href="${pageContext.request.contextPath}/member/form?id=${member.id}" class="btn btn-primary">수정</a>
            <button type="button" class="btn btn-danger" 
                    onclick="if(confirm('정말 삭제하시겠습니까?')) 
                    location.href='${pageContext.request.contextPath}/member/delete?id=${member.id}'">
                삭제
            </button>
            <a href="${pageContext.request.contextPath}/member/list" class="btn btn-secondary">목록</a>
        </div>
    </div>
</body>
</html>
