<%-- <%@page import="com.web.root.member.dao.MemberDAO"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<html>
<head>
<meta charset="UTF-8">
<title>중복 확인</title>
<script type="text/javascript">
	function sendCheckValue() {
		var openJoinform = opener.document.writeForm;
		
		if(document.checkIdForm.chResult.value=="N") {
			alert("다른 아이디를 입력해주세요.");
			openJoinform.id.focus();
			openJoinform.id.value="";
			
			window.close();
		} else {
			window.close();
			openJoinform.pw.focus();
			openJoinform.check.value="t";
		}
		
	}

</script>
</head>
<body>
	<b><font size="4" color="gray">ID 중복 확인</font></b>
	<br>
	
	<form name="checkIdForm">
		<input type="text" name="id" value="${id }" id="id" disabled>
		
		<c:choose>
		<c:when test="${result==0 }">
			<p style="color: red">이미 사용 중인 아이디입니다</p>
			<input type="hidden" name="chResult" value="N"/>
		</c:when>
		<c:when test="${result==1 }">
			<p style="color: red"> 사용가능한 아이디입니다</p>
			<input type="hidden" name=chResult	 value="Y"/>
		</c:when>
		<c:otherwise>
			<p>오류 발생(-1)</p>
			<input type="hidden" name="chResult" value="N"/>
		</c:otherwise>
		</c:choose>
		
		<input type="button" onclick="window.close()" value="취소"/><br>
		<input type="button" onclick="sendCheckValue()" value="사용하기"/>
	</form>
</body>
</html>

























