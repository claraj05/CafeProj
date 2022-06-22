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
	<form action="findId" method="post" name="findIdForm">
		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" name="phone"></td>
			</tr>
		</table>
		<input type="button" value="아이디 검색" onclick="check()">
		<br><br>
		<input type="button" value="로그인" onclick="location.href='${contextPath}/member/login'">
		<input type="button" value="비밀번호 찾기" onclick="location.href='${contextPath}/member/findPwForm'">
	</form>
</body>
</html>