
<!-- member/checkIdResult.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복 확인</title>
</head>
<body>
	<form action="checkId.jsp" method="post">
	<c:if test="${exist == true }">
		<p>${id } 사용 중 입니다</p>
		아이디 : <input type="text" name="id"> &nbsp; <input type="submit" value="중복 체크">
	</c:if>
	<c:if test="${exist != true }">
		<p>${id } 사용 가능합니다</p>
		<input type="button" value="사용" onclick="checkIdClose()">
	</c:if>
	</form>
	<!-- script -->
	<script>
		function checkIdClose(){
			opener.writeForm.id.value="${id }";
			window.close();
			opener.writeForm.pwd.focus();
		}
	</script>
</body>
</html>