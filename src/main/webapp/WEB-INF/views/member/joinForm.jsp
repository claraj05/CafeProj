<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	function daumPost() {
		new daum.Postcode({
			oncomplete: function(data) {
				// 도로명일 경우 R, 지번일 경우 J의 값을 가지고 있습니다
				var addr=""
				if(data.userSelectedType=='R') {
					addr = data.roadAddress 	
				} else {
					addr = data.jibunAddress
				}
				$("#addr1").val(data.zonecode)
				$("#addr2").val(addr)
				$("#addr3").focus()
			}
		}).open();
	}
 
/* function register() {

	
}  */

function joinform_check()  {
	var name = document.getElementById("name");
	var code = document.getElementById("code");
	var id = document.getElementById("id");
	var pw = document.getElementById("pw");
	var addr = document.getElementById("addr");
	var repw  = document.getElementById("repw");
	var phone = document.getElementById("phone");
	var gender  = document.getElementById("gender");
 	var birth = document.getElementById("birth");
	var email  = document.getElementById("email");
	
	
	if(name.value == "") {
		alert("이름를 입력하세요!");
	    document.writeForm.name.focus();	    
	} else if(id.value == "")  {
		alert("아이디를 입력하세요.");
		 document.writeForm.id.focus();
	} else if(pw.value == "") {
		alert("비밀번호를 입력하세요..");
		 document.writeForm.pw.focus();
	} else if(email.value == "") {
		alert("이메일을 입력하세요.");
		document.writeForm.email.focus();
	} else {
		document.writeForm.submit();
	}

}

function checkpw() {
	
	if(pw.value != repw.value) {
		alert("비밀번호가 일치 하지 않습니다");
		return false;
	} else {
		alert("비밀번호가 일치합니다");
		return true;
	}
	
	
}

</script>
</head>
<body>
	<form name="writeForm" action="joinForm" method="post">
 		<input type="hidden" name="code" value="1">  
	<%-- 	<c:if test="${code == 0 }"> 
		<a href="#">카페 추가하기 </a>
		</c:if>  --%>

		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" id="name" width="20"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>
				<input type="text" name="id" id="id" width="20" >
				<input type="button"onclick="checkId()" value="중복 확인">
				</td>
		
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" id="pw" width="20"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="repw" id="repw" width="20"><input type="button" onclick="checkpw()" value="비밀번호 확인"></td>
			</tr>
			<tr>
				<th>phone</th>
				<td colspan="2">
				<input type="text" name="phone" id="phone" width="20">
				</td>
			</tr>
			
			<tr>
				<th>성별</th>
				<td colspan="2">
				<input type="radio" name="gender" value="man" checked >남자
				<input type="radio" name="gender" value="woman">여자
				</td>
			</tr>
	  	 	<tr>
				<th>주 소</th>
					<td>
						<input type="text" id="addr1" name="addr1" placeholder="우편번호" 	>
						<input type="button" onclick="daumPost()" value="우편번호 찾기"><br>
						<input type="text" id="addr2" name="addr2" placeholder="주소" readonly>
						<input type="text" id="addr3" name="addr3" placeholder="상세주소">
					</td>
			</tr> 

			 <tr>
			<th>생일</th>
			<td>
	            <label for="birthdate">생년월일</label>
	            <input type="date" name="birth" id="birth">
	         </td>
			</tr>
			
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="email" id="email" width="20">@
					<select id = "domain" name = "domain" size = "1">
						<option value = "none">----선택----</option>
						<option value = "naver">naver.com</option>
						<option value = "daum">kakao.com</option>
						<option value = "gmail">gmail.com</option>
					</select>
						<option value = "naver.com">naver.com</option>
						<option value = "daum.net">kakao.com</option>
						<option value = "gmail.com">gmail.com</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<!-- <input type="submit" value="회원가입"> -->
					<input type="button"  onclick="joinform_check()" value="회원가입">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>