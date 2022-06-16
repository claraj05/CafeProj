<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c"%>     
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	
<title>board/boardWriteForm</title>
<style>
table{
text-align:center;
width:80%;
margin:20px auto;
}
tr{
height:50px;
}
.title{
width:100%;
height:40px;
}
.content{
width:100%;
height:400px;
}
.modifyBu{
display:block;
margin:auto;
width:80px;
height:30px;
}
</style>
</head>
<body>
	<c:import url="../default/header.jsp" />
	
	<h1 align="center">자유 게시판</h1>
	
	<form action="boardModify" method="post" enctype="multipart/form-data">
		<input type="hidden" name="write_no" value="${dto.write_no }">
		<table border="1">
			<tr>
				<td colspan="3"><input type="text" name="title" value="${dto.title }" class="title"></td>
			</tr>
			<tr>
				<td colspan="3"><textarea name="content" class="content">${dto.content }</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="file1"></td>
				<td><input type="file" name="file2"></td>
				<td><input type="file" name="file3"></td>
			</tr>			
		</table>
		<input type="submit" value="수정" class="modifyBu">
	</form>	
	
	<c:import url="../default/footer.jsp" />
</body>
</html>





