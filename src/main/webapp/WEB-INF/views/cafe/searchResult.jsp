<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SearchResult</title>
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
		<table border="1">
	
			<c:forEach var="loc" items="${list}">
			<tr>
				<th width="200px">cafe_no</th>
				<th width="200px">cafe_name</th>
				<th width="100px">location1</th>
				<th width="200px">location2</th>
				<th width="200px">cafe_tel</th>
				<th width="600px">menu</th>
				<th width="200px">kidszone</th>
				<th width="200px">petzone</th>
				<th width="200px">use_time</th>
				<th width="100px">imageFileName</th>
				<th width="100px">avg_star</th>
				<th width="200px">logtime</th>
			</tr>
			<tr>		
				<td>${loc.cafe_no}</td>
				<td>${loc.cafe_name}</td>
				<td>${loc.location1}</td>
				<td>${loc.location2}</td>
				<td>${loc.cafe_tel}</td>
				<td>${loc.menu}</td>
				<td>${loc.kidszone}</td>
				<td>${loc.petzone}</td>
				<td>${loc.use_time}</td>
				<td>${loc.imageFileName}</td>
				<td>${loc.avg_star}</td>
				<td>${loc.logtime}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>