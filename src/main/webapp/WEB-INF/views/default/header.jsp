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

.searchArea form  #search {
	border:none;
	background:rgba(0,0,0,0.0);
	width:250px;
	height:40px;
	padding-left:20px;
	
	color:#fff;
}



.searchArea > form > #searchB {
	width:50px;
	color:#fff;
	font-weight:bold;
	cursor:pointer;
	font-size: 15px;
}

.nav {
	padding: 10px;
	display: flex;	
	width:calc(1280px - 200px);
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
C:\Users\jimin\Desktop\proj\Yoo\Cafe-proj_Yoo\src\main\webapp\resources
</style>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	<div class="navdic">
		<div class="intro_bg">
			<div class="header">
				<div class="searchArea">
					<form name="searchKW" action="http://localhost:8080/root/searchEng">
						<span class="material-symbols-outlined">search</span>
						<input id="search" type="search" name="searchKW">
						<input id="searchB"type="button" value="검색" onclick="searchEng()">
					</form>
				</div>
				<ul class="nav">
					<li><a href="${contextPath }/cafe/searchView">카페 검색</a></li>
					<li><a href="${contextPath }/cafe/eventView">EVENT</a></li>
					<li><a href="${contextPath }/board/boardList">게시판</a></li>
					<li><a href="${contextPath }/cafe/mycafe?id=${loginUser}">내가 찜한 카페</a></li>
					<li><a href="${contextPath }/member/memberInfo?id=${loginUser}">마이페이지(정보 수정용)</a></li>
					<c:if test="${loginUser == null }">
						<li><a href="${contextPath }/member/login">로그인</a></li>
						<li><a href="${contextPath }/member/register">회원가입</a></li>
					</c:if>	
					<c:if test="${loginUser!=null }">
						<li><a href="${contextPath }/member/logout">로그아웃</a></li>
		 			<c:if test="${code==0 }">
						<li><a href="${contextPath }/cafe/cafemanager">카페 등록</a></li>
						</c:if>
					</c:if>
				</ul>			
			</div>
		</div>
	</div>
	<script>
	function searchEng(){
		   if(document.searchKW.search.value==""){
		      alert("검색어를 입력하세요")
		      document.searchKW.search.focus()
		   }else{
		      document.searchKW.submit()
		   }
		}
	</script>
</body>
</html>