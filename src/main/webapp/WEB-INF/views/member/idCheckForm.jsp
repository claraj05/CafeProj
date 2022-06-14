<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheckForm.jsp</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>



</script>
</head>
<body> 
<div id="wrap">
	<br>
	<b><font size="4" color="gray">아이디 중복 체크</font></b>
	<hr size="1" width="460">
	<br>
	<div id="chk">
		<form id="checkForm">
			<input type="text" name="idinput" id="userId">
			<input type="button" value="중복확인" onclick="idCheck()"><!-- 중복 확인 버튼 클릭 시 중복체크를 하는 idCheck()가 호출된다 -->
		</form>
		<div id="msg"></div>
		<br>
		<input id="cancelBtn" type="button" value="취소" onclick="window.close()"><br> <!-- 현재 창 닫기 -->
		<input id="useBtn" type="button" value="사용하기" onclick="sendCheckValue()"> <!-- seneCheckValue()가 실행되어 입력된 값이 회원가입 화면으로 전달된다 -->
	</div>


</div>

</body>
</html>