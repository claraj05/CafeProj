<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c"%>     
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/boardView</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/board/boardView.css?after4">

<script>
function loginConfirm(id){
	if(id==""){ //로그인x
		alert("로그인해주세요")
		location.href="${contextPath}/member/login"
	}else { //로그인o
		location.href="${contextPath}/board/boardLike?write_no=${board.write_no}&id="+id
	}
}
function likeCheck(){
	if(${check }==1){
		document.getElementById("likeBu").value="♥좋아요 +1"
	}	
}
function removeConfirm(){
	var check=confirm("삭제하시겠습니까?")
	if(check){
		location.href="${contextPath}/board/boardDelete?write_no=${board.write_no }"
		alert("삭제되었습니다")
	}
}
</script>
</head>
<body onload="likeCheck()">
	<c:import url="../default/header.jsp" />
	
	<h1 align="center">자유 게시판</h1>
	
	<table border="1">
		<tr>
			<th width="10%">제목</th>
			<td >${board.title }</td>
		</tr>
		<tr>
			<th width="10%">아이디</th>
			<td >${board.id }</td>
		</tr>
		<tr>
			<th width="10%" height="100px">내용</th>
			<td  class="content">${board.content }</td>
		</tr>
		<c:if test="${boardImage.imageFileName1!=null || boardImage.imageFileName2!=null || boardImage.imageFileName3!=null}">
		
			<c:if test="${boardImage.imageFileName1!=null}">
				<tr>
					<th rowspan="3" width="10%">사진</th>
					<td colspan="2"><img src="${contextPath}/board/download1?imageFileName1=${boardImage.imageFileName1}" style="width:300px; height:300px;"></td>
				</tr>
			</c:if>
			<c:if test="${boardImage.imageFileName2!=null}">
				<tr>
					<td colspan="2"><img src="${contextPath}/board/download2?imageFileName2=${boardImage.imageFileName2}" style="width:300px; height:300px;"></td>
				</tr>
			</c:if>
			<c:if test="${boardImage.imageFileName3!=null}">
				<tr>
					<td colspan="2"><img src="${contextPath}/board/download3?imageFileName3=${boardImage.imageFileName3}" style="width:300px; height:300px;"></td>
				</tr>
			</c:if>
		
		</c:if>
	</table>

	<div class="btn">
		<input type="button" id="likeBu" value="♡좋아요 +0" onclick="loginConfirm('${loginUser}')">
		<br><br>
		<input type="button" value="목록" onclick="location.href='${contextPath}/board/boardList'">
		<c:if test="${board.id==loginUser }">
			<input type="button" value="수정" onclick="location.href='${contextPath}/board/boardModifyForm?write_no=${board.write_no }'">
			<input type="button" value="삭제" onclick="removeConfirm()">
		</c:if>
	</div>
	<c:import url="../default/footer.jsp" />
</body>
</html>







