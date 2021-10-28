<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../home/header.jsp"></jsp:include>
<body>
<div align="center">
	<div><h2>회원 목록</h2></div>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이 름</th>
			<th>주 소</th>
			<th>전화번호</th>
			<th>권 한</th>
		</tr>
		<c:forEach items="${members }" var="member">
			<tr>
				<td>${member.id }</td>
				<td>${member.password }</td>
				<td>${member.name }</td>
				<td>${member.address }</td>
				<td>${member.tel }</td>
				<td>${member.author }</td>
			</tr>
		</c:forEach>
	</table>
</div><br>
<div align="center"><a href="home.do">홈 가기</a></div>
</body>
</html>