<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 세부보기</title>
<script type="text/javascript">
	function CallEdit(str) {
		document.getElementById("modTitle").value = document.getElementById("title").value;
		document.getElementById("modContents").value = document.getElementById("contents").value;
		if(str == 'E') {
			frm.action = "noticeEdit.do";
		} else {
			frm.action = "noticeDelete.do";
		}
		frm.submit();
	}
</script>
</head>
<body>
<%
	String name = (String)session.getAttribute("name");
%>
<div align="center">
	<div><h1>공지사항 조회</h1></div>
	<div>
		<table border="1">
			<tr>
				<th width="70">글번호</th>
				<td width="70" align="center">${notice.nid }</td>
				<th width="100">작성자</th>
				<td width="100" align="center">${notice.name }</td>
				<th width="100">작성일자</th>
				<td width="100" align="center">${notice.writeDate }</td>
				<th width="70">조회수</th>
				<td width="70" align="center">${notice.hit }</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td colspan="7">
					<textarea rows="1" cols="92" id="title" name="title">${notice.title }</textarea>
				</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td colspan="7">
					<textarea rows="10" cols="92" id="contents" name="contents">${notice.contents }</textarea>
				</td>
			</tr>
		</table>
	</div><br>
	<div>
		<button type="button" onclick="location.href='noticeList.do'">목록</button> &nbsp;&nbsp;&nbsp;
		<c:if test="${notice.name == name || member == 'ADMIN'}">
			<button type="button" onclick="CallEdit('E')">수정</button> &nbsp;&nbsp;&nbsp;
			<button type="button" onclick="CallEdit('D')">삭제</button>
		</c:if>
	</div>
	<div>
		<form id="frm" action="" method="post">
			<input type="hidden" id="nid" name="nid" value="${notice.nid }">
			<input type="hidden" id="modTitle" name="modTitle" value="">
			<input type="hidden" id="modContents" name="modContents" value="">
		</form>
	</div>
</div>
</body>
</html>