<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c"%>     
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/boardView</title>
<style>
table{
width:80%;
margin:20px auto;
}
tr{
height:50px;
}
div{
text-align:center;
}
input{
width:80px;
height:30px;
}
.content{
vertical-align:top;
}
</style>
<script>
function loginConfirm(id){
	if(id==""){ //로그인x
		alert("로그인해주세요")
		location.href="${contextPath}/member/login"
	}else { //로그인o
		location.href="${contextPath}/board/boardLike?write_no=${board.write_no}&id="+id
	}
}
function likeCheck(id){
	if(${check }==0){
	}
	else if(${check }==1){
		document.getElementById("likeBu").style.backgroundColor="yellow";
	}
	
}
</script>
</head>
<body onload="likeCheck()">
	<c:import url="../default/header.jsp" />
	
	<h1 align="center">자유 게시판</h1>
	
	<table border="1">
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td colspan="3">${board.id }</td>
		</tr>
		<tr>
			<th height="300px">내용</th>
			<td colspan="3" class="content">${board.content }</td>
		</tr>
		<tr>
			<th height="300px">사진</th>
			<td><img src="${contextPath}/board/download1?imageFileName1=${boardImage.imageFileName1}" style="width:300px; height:300px;"></td>
			<td><img src="${contextPath}/board/download2?imageFileName2=${boardImage.imageFileName2}" style="width:300px; height:300px;"></td>
			<td><img src="${contextPath}/board/download3?imageFileName3=${boardImage.imageFileName3}" style="width:300px; height:300px;"></td>
		</tr>
	</table>

	<div>
		<input type="button" value="목록" onclick="location.href='${contextPath}/board/boardList'">
		<c:if test="${board.id=='poikh' }">
			<input type="button" value="수정" onclick="location.href='${contextPath}/board/boardModifyForm?write_no=${board.write_no }'">
			<input type="button" value="삭제" onclick="location.href='${contextPath}/board/boardDelete?write_no=${board.write_no }'">
		</c:if>
		<input type="button" id="likeBu" value="좋아요" onclick="loginConfirm('poikh7')">
	</div>
	<c:import url="../default/footer.jsp" />
</body>
</html>







