<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h2>내 정보</h2></div>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이 름</th>
			<th>주 소</th>
			<th>전화번호</th>
			<th>권 한</th>
		</tr>
		<tr>
			<td>${member.id }</td>
			<td>${member.password }</td>
			<td>${member.name }</td>
			<td>${member.address }</td>
			<td>${member.tel }</td>
			<td>${member.author }</td>
		</tr>
	</table>
</div><br>
<div align="center"><a href="home.do">홈 가기</a></div>
</body>
</html>