<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
<meta charset="UTF-8">
<title>cafe/mycafe</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/cafe/cafeSearchResult.css?after4">
</head>
<body>
	<c:import url="../default/header.jsp"/>
			<br>
			<h1 align="center">내가 찜한 카페 리스트</h1>
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
					<th width="200px">찜하기</th>
					<!-- <th width="100px">imageFileName</th>-->
				</tr>
				
				<c:if test="${list.size()==0}">
				<td colspan="7" width="200" height="200">
					찜한 카페가 없습니다.<br>
					<a href="${contextPath}/cafe/cafeAllList">전체 카페 리스트</a>
				</td>
				</c:if>
				<c:forEach var="loc" items="${list}">
				<tr>		
					<%-- <td>${loc.cafe_no}</td> --%>
					<td><a href="">${loc.cafe_name}</a></td>
					<td><a href="http://localhost:8080/root/review/cafe?no=${loc.cafe_no}"><img id="zoom" src="${contextPath }/img/${loc.cafe_no}/${loc.imgName}" 
									width="200px" height="200px" width="200px" height="200px" width="200px" width="200px" height="200px"></a></td>
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
					<td>
						<input type="button" value="♡"  id="selectBu" onclick="location.href='${contextPath}/cafe/cafeSelect2?id=${loginUser }&cafe_no=${loc.cafe_no }&num=${num }'">
						${loc.select_count }
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
			<div align="center">
		<c:if test="${currentPage>1 }">
			<input type="button" class="moveBu" value="&lt;" onclick="location.href='${contextPath }/cafe/mycafe?num=${currentPage-1 }&id=${loginUser}'">
		</c:if>
		<c:forEach var="num" begin="${startPage}" end="${endPage}">
			<c:if test="${num==currentPage }">
				<a href="${contextPath }/cafe/mycafe?num=${num }&id=${loginUser}" class="currentPage">[${num }]</a>
			</c:if>
			<c:if test="${num!=currentPage }">
				<a href="${contextPath }/cafe/mycafe?num=${num }&id=${loginUser}">[${num }]</a>
			</c:if>
		</c:forEach>
		<c:if test="${currentPage<totalPage }">
			<input type="button" class="moveBu" value="&gt;" onclick="location.href='${contextPath }/cafe/mycafe?num=${currentPage+1 }&id=${loginUser}'">
		</c:if>
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>

