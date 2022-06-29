<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/findIdForm</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/member/findIdForm.css?after4">
<script>
function findId(){
	if("${id}"=="1"){
		alert("해당 아이디가 존재하지 않습니다")
	}
}
function check(){
	if(document.findIdForm.name.value==""){
		alert("이름을 입력해주세요")
		findIdForm.name.focus()
	}else if(findIdForm.phone.value==""){
		alert("전화번호를 입력해주세요")
		findIdForm.phone.focus()
	}else{
		findIdForm.submit()
	}
}
</script>
</head>
<body onload="findId()">
	<section class="findIdForm2">
	<h1>아이디 찾기</h1>
	<form action="findId" method="post" name="findIdForm">

		<div class="int-area">	
				<input type="text" name="name" autocomplete="off" required>
				<label for="name">이름</label>
		</div>
		<div class="int-area">	
			<input type="tel" name="phone" autocomplete="off" required>
			<label for="tel">전화번호</label>
		</div>
		
		<div class="caption">
		<input type="button" value="아이디 찾기" onclick="check()">
	
		<input type="button" value="로그인" onclick="location.href='${contextPath}/member/login'">
		
		<input type="button" value="비밀번호 찾기" onclick="location.href='${contextPath}/member/findPwForm'">
		
		<a href="${contextPath }/">메인화면</a>
		</div>
	</form>
</section>
</body>
</html>