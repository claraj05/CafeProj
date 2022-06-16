<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
</head>
<body>
	<form action="" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" width="20"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" width="20"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" width="20"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="pw2" width="20"><input type="button" onclick="checkpw()" value="확인"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="id" width="20">@
					<select id = "domain" name = "domain" size = "1">
						<option value = "none">----선택----</option>
						<option value = "naver">naver.com</option>
						<option value = "daum">kakao.com</option>
						<option value = "gmail">gmail.com</option>
					</select>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>