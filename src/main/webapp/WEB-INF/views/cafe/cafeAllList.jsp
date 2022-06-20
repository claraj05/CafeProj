<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/cafe/cafeSearchResult.css">
</head>
<body>
	<c:import url="../default/header.jsp"/>
	<h1 align="center">카페 전체 목록</h1>
	<div class="result">
	<table id="resultTable">
			<tr>
				<th colspan="2" width="250px">카페 이름</th>
				<th width="50px">평균 별점</th>
				<th width="500x">위치</th>
				<th width="200px">키즈존 여부</th>
				<th width="200px">펫존 여부</th>
				<th width="200px">이용 가능 시간</th>
				<th width="150px">My Favorites</th>
			</tr>
			<c:forEach var="loc" items="${list}">
			<tr>		
				<td><a href="">${loc.cafe_name}</a></td>
				<td><img src="${contextPath }/cafe/download?cafe_no=${loc.cafe_no}" 
									width="200px" height="200px">
				</td>
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
				<td><input type="button" value="즐찾버튼" onclick="location.href='${contextPath}/cafe/addFavorite?cafe_no=${loc.cafe_no}&id=${loginUser }'"></td>
			</tr>
			</c:forEach>
			
			<tr>
				<td colspan="8" align="center">
					<c:forEach var="num" begin="1" end="${repeat }">
						<a href="cafeAllList?num=${num }">[${num }]</a>
					</c:forEach>
				</td>
			</tr>
		</table>
			</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>