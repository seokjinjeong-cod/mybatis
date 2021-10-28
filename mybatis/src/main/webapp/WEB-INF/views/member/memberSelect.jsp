<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function CallEdit(str) {
		document.getElementById("modPw").value = document.getElementById("password").value;
		document.getElementById("modAuthor").value = document.getElementById("author").value;
		if(str == 'E'){
			frm.action = "memberEdit.do";
		} else {
			frm.action = "memberDelete.do";
		}
		frm.submit();
	}
</script>
</head>
<jsp:include page="../home/header.jsp"></jsp:include>
<body>
<div align="center">
	<div><h2>내 정보</h2></div>
	<table border="1" style="margin-top: 10px">
			<tr>
				<th>아이디</th>
				<td>${member.id }</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><textarea id="password" name="password">${member.password }</textarea></td>
			</tr>
			<tr>
				<th>이 름</th>
				<td>${member.name }</td>
			</tr>
			<tr>
				<th>주 소</th>
				<td>${member.address }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${member.tel }</td>
			</tr>
			<tr>
				<th>권한</th>
				<td><textarea id="author" name="author">${member.author }</textarea></td>
			</tr>
		</table>
</div><br>
<div align="center">
	<button type="button" onclick="CallEdit('E')">수 정</button>
	<button type="button" onclick="CallEdit('D')">탈 퇴</button>
	<button type="button" onclick="location.href='home.do'">홈 가기</button>
</div>
<div>
	<form id="frm" action="" method="post">
		<input type="hidden" id="id" name="id" value="${member.id }">
		<input type="hidden" id="modPw" name="modPw" value="">
		<input type="hidden" id="modAuthor" name="modAuthor" value="">
	</form>
</div>
</body>
</html>