<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
</head>
<jsp:include page="../home/header.jsp" />
<body>
<% String id = (String)session.getAttribute("id");
   String name = (String)session.getAttribute("name");
   LocalDate date = LocalDate.now();
%>
<div align="center">
	<div><h1>게시글 작성</h1></div>
	<div>
		<form id="frm" action="noticeInsert.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="100">아이디</th>
						<td width="150">
							<%= id %>
						</td>
						<th width="100">작성자</th>
						<td width="150">
							<%= name %>
						</td>
						<th width="100">작성일자</th>
						<td width="150">
							<%= date %>
						</td>
					</tr>
					<tr>
						<th>제 목</th>
						<td colspan="5">
							<input style="width: 98%;" type="text" id="title" name="title">
						</td>
					</tr>
					<tr>
						<th>내 용</th>
						<td colspan="5">
							<textarea rows="10" cols="100" id="contents" name="contents"></textarea>
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="hidden" id="id" name="id" value="<%= id %>">
				<input type="hidden" id="date" name="date" value="<%= date %>">
				<input type="hidden" id="name" name="name" value="<%= name %>">
				<input type="submit" value="저 장"> &nbsp;&nbsp;&nbsp;
				<input type="reset" value="취 소"> &nbsp;&nbsp;&nbsp;
				<input type="button" value="목 록" onclick="location.href='noticeList.do'">
			</div>
		</form>
	</div>
</div>
</body>
</html>