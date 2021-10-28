<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>여기가 홈 페이지</h1></div>
	<a href="memberList.do">회원 목록</a><p>
	<c:if test="${not empty id }">
		<a href="memberSelect.do">내정보 조회</a><p>
	</c:if>
	<a href="noticeList.do">글 목록</a><p>
	<a href="memberLoginForm.do">로그인</a>
</div>
</body>
</html>