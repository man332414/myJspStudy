<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 관리 시스템</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .jumbotron {
            padding: 2rem 1rem; /* 상하 패딩 설정 */
            margin-bottom: 2rem; /* 아래 여백 설정 */
            background-color: #e9ecef; /* 배경색 설정 */
            border-radius: .3rem; /* 모서리 둥글게 설정 */
        }
    </style>
</head>
<body>
    <!-- 네비게이션 바 시작 -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">회원 관리 시스템</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span> <!-- 토글 버튼 아이콘 -->
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/member/list">회원 목록</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/member/form">회원 등록</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- 네비게이션 바 끝 -->

    <div class="container mt-5">
        <div class="jumbotron">
            <h1 class="display-4">회원 관리 시스템</h1>
            <p class="lead">회원 정보를 손쉽게 관리할 수 있는 시스템입니다.</p>
            <hr class="my-4">
            <p>아래 버튼을 클릭하여 시작하세요.</p>
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/member/list">회원 목록 보기</a>
            <a class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/member/form">새 회원 등록</a>
        </div>

        <div class="row mt-5">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">회원 관리</h5>
                        <p class="card-text">회원 정보를 조회, 등록, 수정, 삭제할 수 있습니다.</p>
                        <a href="${pageContext.request.contextPath}/member/list" class="btn btn-primary">회원 관리하기</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">회원 등록</h5>
                        <p class="card-text">새로운 회원을 시스템에 등록할 수 있습니다.</p>
                        <a href="${pageContext.request.contextPath}/member/form" class="btn btn-success">회원 등록하기</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">도움말</h5>
                        <p class="card-text">시스템 사용에 대한 도움말을 확인할 수 있습니다.</p>
                        <button class="btn btn-info" data-bs-toggle="modal" data-bs-target="#helpModal">도움말 보기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 도움말 모달 시작 -->
    <div class="modal fade" id="helpModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">사용 도움말</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <h6>회원 관리 시스템 사용 방법</h6>
                    <ul>
                        <li>회원 목록: 등록된 모든 회원을 확인할 수 있습니다.</li>
                        <li>회원 등록: 새로운 회원 정보를 입력할 수 있습니다.</li>
                        <li>회원 수정: 기존 회원의 정보를 수정할 수 있습니다.</li>
                        <li>회원 삭제: 더 이상 필요하지 않은 회원 정보를 삭제할 수 있습니다.</li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 도움말 모달 끝 -->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
