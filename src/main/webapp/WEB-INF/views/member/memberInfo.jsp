<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myInfo</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/member/memberInfo.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
function checkModify(){
	if(document.modifyForm.name.value==""){
		alert("이름을 입력하세요!");
		document.modifyForm.name.focus();
	}
	else if(document.modifyForm.pwd.value==""){
		alert("비밀번호를 입력하세요!");
		document.modifyForm.pwd.focus();
	}
	else if(document.modifyForm.pwd.value!=document.modifyForm.repwd.value){
		alert("비밀번호가 틀립니다!");
		document.modifyForm.repwd.focus();
	}
	else if(document.modifyForm.email.value==""){
		alert("이메일을 입력하세요!");
		document.modifyForm.email.focus();
	}
	else if(document.modifyForm.tel1.value==""){
		alert("전화번호를 입력하세요!");
		document.modifyForm.tel1.focus();
	}
	else if(document.modifyForm.tel2.value==""){
		alert("전화번호를 입력하세요!");
		document.modifyForm.tel2.focus();
	}
	else if(document.modifyForm.tel3.value==""){
		alert("전화번호를 입력하세요!");
		document.modifyForm.tel3.focus();
	}
	else if(document.modifyForm.addr.value==""){
		alert("주소를 입력하세요!");
		document.modifyForm.addr.focus();
	}
	else {
		document.modifyForm.submit();
	}
}

function checkDelete(){
	var check=confirm("정말 탈퇴하시겠습니까?")
	if(check){
		location.href="${contextPath}/member/delete?id=${loginUser}"
	}
}
</script>

</head>
<body>
	<section class="memberInfo">
		<h1>마이페이지</h1>  
		<div class="int-area">                           
			<a>${loginUser }</a>
			<label for="id">id</label>
		</div>
		
		<div class="int-area">
			<a>${member.name }</a>
			<label for="id">name</label>
		</div>
		<div class="int-area">
			<a>${member.pw }</a>
			<label for="id">pw</label>
		</div>
		<div class="int-area">
			<a>${member.phone }</a>
			<label for="id">phone</label>
		</div>
		<div class="int-area">
			<a>${member.gender }</a>
			<label for="id">gender</label>
		</div>
		<div class="int-area">
			<a>${member.addr }</a>
			<label for="id">addr</label>
		</div>
		<div class="int-area">
			<a>${member.birth }</a>
			<label for="id">birth</label>
		</div>
		<div class="int-area">
			<a>${member.email }@${member.domain }</a>
			<label for="id">email</label>
		</div>
		
		<div class="btn-area">
		<a href="${contextPath }/index">메인화면</a>
		<a href="info?id=${loginUser}">수정하기</a>
		<input type="button" value="탈퇴하기" onclick="checkDelete()"> 
		</div>
			
	</section>

</body>
</html>





