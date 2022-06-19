<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<style type="text/css">

* {
	margin: 0px;
	padding: 0px;
	list-style: none;
	border-collapse: collapse;
}

.intro_bg {
	/* background-image:url(""); */
	width:100%;
	height:200px;
	border : 1px solid black;
	
}

.header {
	width: 1280px;
	margin: auto;
	display: flex;
	height: 86px;
	
}

.searchArea {
	width: 300px;
	height: 40px;
	background:rgba(0,0,0,0.5);
	border-radius: 5px;
	margin-top: 24px;

}

.searchArea > form > input {
	border:none;
	background:rgba(0,0,0,0.0);
	width:250px;
	height:40px;
	padding-left:20px;
	
	color:#fff;
}



.searchArea > form > span {
	width:50px;
	color:#fff;
	font-weight:bold;
	cursor:pointer;
	font-size: 15px;
}

.nav {
	padding: 10px;
	display: flex;	
	width:calc(1280px - 300px);
	justify-content: flex-end;
	line-height: 60px;
	
}

.nav li {
	margin-left: 50px;
}


.nav li a {
	text-decoration: none;
	color:black;
	font-weight:bold;
}

.nav li a:hover {
	color:orange;
}

</style>
</head>
<body>
	<div class="navdic">
		<div class="intro_bg">
			<div class="header">
				<div class="searchArea">
					<form action="#">
						<input type="search" placeholder="cafe search">
						<span>검색</span>
					</form>
				</div>
				<ul class="nav">
					<li><a href="${contextPath }/cafe/searchView">카페 검색</a></li>
					<li><a href="${contextPath }/cafe/eventView">EVENT</a></li>
					<li><a href="${contextPath }/board/boardList">게시판</a></li>
					<li><a href="${contextPath }/cafe/mycafe">내가 찜한 카페</a></li>
					<li><a href="${contextPath }/member/myInfo">마이페이지(정보 수정용)</a></li>
					<c:if test="${loginUser == null }">
						<li><a href="${contextPath }/member/login">로그인</a></li>
						<li><a href="${contextPath }/member/register">회원가입</a></li>
					</c:if>	
		 			<c:if test="${loginUser != null }">
						<li><a href="${contextPath }/member/logout">로그아웃</a></li>
							<c:if test="${code=='0' }">
								<li><a href="${contextPath }/cafe/cafemanager">카페 관리</a></li>
								</c:if>
					</c:if>	 
				<%-- 	<c:if test=""> 관리자 계정 로그인 시 보이는 메뉴
						<li><a href="${contextPath }/cafe/cafemanager">카페 관리</a></li>
					</c:if> --%>
				</ul>			
			</div>
		</div>
	</div>

</body>
</html>