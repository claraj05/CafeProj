<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/member/login.css?after">
<script>
function find(){ 
	if("${id}"!=""){
		alert("귀하의 아이디는 ${id}입니다")		
	}
	if("${pw}"!=""){
		alert("귀하의 비밀번호는 ${pw}입니다")		
	}
}
</script>
</head>
<body onload="find()">
	<section class="login_form">
		<h1>로그인</h1>
		<form action="${contextPath }/member/user_check" method="post">
			<div class="int-area">
				<input type="text" name="id" id="id" autocomplete="off" required>
				<label for="id">USER_ID</label>
			</div>
			<div class="int-area">
				<input type="password" name="pw" id="pw" autocomplete="off" required>
				<label for="pw">password</label>
			</div>
			<div class="btn-area">
				<button id="btn" type="submit">LOGIN</button>
			</div>
			<div class="caption">
				<a href="${contextPath }/member/register">회원가입</a>
			</div>
			<div class="caption">
				<input type="button" value="아이디 찾기" onclick="location.href='${contextPath}/member/findIdForm'"> &nbsp;&nbsp;
				<input type="button" value="비밀번호 찾기" onclick="location.href='${contextPath}/member/findPwForm'">
				<br>
				<input type="button" value="home" onclick="location.href='${contextPath}/'">
			</div>
		</form>
	</section>
</body>
<script>
	


	let id = $('#id');
 	let pw = $('#pw');
 	let btn = $('#btn');
 	
 	$(btn).on('click', function() {
 		if($(id).val() == "") {
 			$(id).next('label').addClass('warning');
 			setTimeout(function() {
 				$('label').removeClass('warning');
 			},2000);
 			
 		} else if ($(pw).val() == "") {
 			$(pw).next('label').addClass('warning');
 			setTimeout(function() {
 				$('label').removeClass('warning');
 			},2000);
 		}
 	});
</script>

</html>















