<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/findIdForm</title>
<script>
function findPw(){
	if("${pw}"=="1"){
		alert("해당 비밀번호가 존재하지 않습니다")
	}
}
function check(){
	if(document.findPwForm.id.value==""){
		alert("아이디를 입력해주세요")
		findPwForm.id.focus()
	}else if(findPwForm.name.value==""){
		alert("이름을 입력해주세요")
		findPwForm.name.focus()
	}else if(findPwForm.birth.value==""){
		alert("생년월일을 입력해주세요")
		findPwForm.birth.focus()
	}
	else{
		findPwForm.submit()
	}
}
</script>
</head>
<body onload="findPw()">
	<form action="findPw" method="post" name="findPwForm">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="birth"></td>
			</tr>
		</table>
		<input type="button" value="비밀번호 검색" onclick="check()">
		<br><br>
		<input type="button" value="로그인" onclick="location.href='${contextPath}/member/login'">
		<input type="button" value="아이디 찾기" onclick="location.href='${contextPath}/member/findIdForm'">
	</form>
</body>
</html>