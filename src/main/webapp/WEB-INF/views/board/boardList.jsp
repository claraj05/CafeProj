<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c"%>     
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/boardList</title>
<style>
table{
text-align:center;
width:80%;
margin:20px auto;
}
tr{
height:50px;
}
a{
text-decoration:none;
color:black;
}
a:hover{
text-decoration:underline;
color:red;
}
.writeBu{
display:block;
margin:auto;
width:80px;
height:30px;
}
.searchForm{
text-align:center;
margin:20px;
}
.search{
width:400px;
height:30px;
}
.searchBu{
width:80px;
height:30px;
}
.searchList{
width:80px;
height:30px;
}
.title{
text-align:left;
}
.currentPage{
color:red;
}
.moveBu{
width:20px;
height:20px;
}
</style>
<script>
function loginConfirm(id){
	if(id==""){ //로그인x
		alert("로그인해주세요")
		location.href="${contextPath}/member/login"
	}else { //로그인o
		location.href="${contextPath}/board/boardWriteForm"
	}
}
</script>
</head>
<body>
	<c:import url="../default/header.jsp" />
	
	<h1 align="center">자유 게시판</h1>
	
	<form action="boardSearch" method="post" class="searchForm">
		<select name="searchList" class="searchList">
			<option value="title">제목
			<option value="content">내용
			<option value="id">아이디
		</select>
		<input type="search" name="search" class="search">
		<input type="submit" value="검색" class="searchBu">
	</form>
	
	<table border="1">
		<tr>
			<th width="10%">번호</th>		
			<th width="50%">제목</th>		
			<th width="10%">아이디</th>		
			<th width="10%">등록일</th>		
			<th width="10%">조회수</th>		
			<th width="10%">좋아요</th>		
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.write_no }</td>
				<td class="title"><a href="${contextPath }/board/boardView?write_no=${dto.write_no}&id=poikh7">${dto.title }</a></td>
				<td>${dto.id }</td>
				<td>${dto.savedate }</td>
				<td>${dto.hit }</td>
				<td>${dto.like_count }</td>
			</tr>
		</c:forEach>
	</table>
	
	<div align="center">
		<c:if test="${currentPage>1 }">
			<input type="button" class="moveBu" value="&lt;" onclick="location.href='${contextPath }/board/boardList?currentPage=${currentPage-1 }'">
		</c:if>
		<c:forEach var="num" begin="${startPage }" end="${endPage }">
			<c:if test="${num==currentPage }">
				<a href="${contextPath }/board/boardList?currentPage=${num }" class="currentPage">[${num }]</a>
			</c:if>
			<c:if test="${num!=currentPage }">
				<a href="${contextPath }/board/boardList?currentPage=${num }">[${num }]</a>
			</c:if>
		</c:forEach>
		<c:if test="${currentPage<totalPage }">
			<input type="button" class="moveBu" value="&gt;" onclick="location.href='${contextPath }/board/boardList?currentPage=${currentPage+1 }'">
		</c:if>
	</div>
	<br>
	
	<input type="button" class="writeBu" value="글쓰기" onclick="loginConfirm('poikh')">
	
	<c:import url="../default/footer.jsp" />
</body>
</html>





