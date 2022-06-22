<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SearchResult</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/cafeSearchResult.css">
<script>
function loginConfirm(cafe_no, location1, kidszone, petzone, star, id){
	if(id==""){ //로그인x
		alert("로그인해주세요")
		location.href="${contextPath}/member/login"
	}else { //로그인o
		location.href="${contextPath}/cafe/cafeSelect?cafe_no="+cafe_no+"&location1="+location1+"&kidszone="+kidszone+"&petzone="+petzone+"&star="+star+"&id="+id
	}
}
/* function selectCheck(){
	if(${check }==1){
		document.getElementById("selectBu").value="♥"
	}	
}  */
</script>
</head>
<body>
<!-- cafe_no number(30) primary key,
cafe_name varchar2(100) not null, 
location1 varchar2(20) not null, --@@동
location2 varchar2(100) not null, --상세주소
cafe_tel varchar2(20), 
menu varchar2(1000), --메뉴
kidszone number(10), --0: 정보없음/ 1 : 키즈존(전문) /2: 노키즈존 / 3:캐어키즈존 
petzone number(10), --0:정보없음/ 1: 펫존(애견카페o) / 2:노펫존 / 3:펫허용(애견카페x)
use_time varchar2(30), --오전 ~~:~~ ~ 오후 ~~:~~ 까지 포맷으로
imageFileName varchar2(1000) not null,
avg_star number(10,2), --평균 별점
logtime date default sysdate --등록일 -->
<c:import url="../default/header.jsp"/>
	<div class="result">
		<c:if test="${list.size()==0}">
			검색된 카페 없음(test)
		</c:if>
		<c:if test="${list.size()!=0}">
			검색된 카페 있는데 안나옴..(test)
		</c:if>
		<table id="resultTable">
			<tr>
				<!-- <th width="100px">cafe_no</th> -->
				<th width="250px">cafe_name</th>
				<th width="200px">cafe_img</th>
				<th width="100px">avg_star</th>
				<th width="300x">location2</th>
				<th width="200px">kidszone</th>
				<th width="200px">petzone</th>
				<th width="200px">use_time</th>
				<th width="150px">My Favorites</th>
				<!-- <th width="100px">imageFileName</th>-->
			</tr>
			<c:if test="${list.size()==0}">
			<td colspan="8" width="200" height="200">
				검색된 카페가 없습니다.<br>
				<a href="${contextPath}/cafe/cafeAllList">전체 카페 리스트</a>
			</td>
			</c:if>
			<c:forEach var="loc" items="${list}">
			<tr>		
				<%-- <td>${loc.cafe_no}</td> --%>
				<td><a href="http://localhost:8080/root/review/cafe?no=${loc.cafe_no}">${loc.cafe_name}</a></td>
				<td><img src="${contextPath }/img/${loc.cafe_no}/${loc.imgName}" 
									width="200px" height="200px" width="200px" height="200px" width="200px" height="200px"></td>
				<td>${loc.avg_star}</td>
				<td>${loc.location2}</td>
				<c:if test="${loc.kidszone==0}">
				<td>무관(정보없음)</td>
				</c:if>
				<c:if test="${loc.kidszone==1}">
				<td>키즈카페</td>
				</c:if>
				<c:if test="${loc.kidszone==2}">
				<td>노키즈존</td>
				</c:if>
				<c:if test="${loc.kidszone==3}">
				<td>캐어키즈존</td>
				</c:if>
				<c:if test="${loc.petzone==0 }">
				<td>무관(정보없음)</td>
				</c:if>
				<c:if test="${loc.petzone==1 }">
				<td>펫카페</td>
				</c:if>
				<c:if test="${loc.petzone==2 }">
				<td>노펫존</td>
				</c:if>
				<c:if test="${loc.petzone==3 }">
				<td>펫허용존</td>
				</c:if>
				<td>${loc.use_time}</td>
				<!--  <td>${imageFileName}</td>-->
				<td>
					<input type="button" value="♡"  id="selectBu" onclick="location.href='${contextPath}/cafe/cafeSelect?cafe_no=${loc.cafe_no}&id=${loginUser}'">
					${loc.select_count }
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>