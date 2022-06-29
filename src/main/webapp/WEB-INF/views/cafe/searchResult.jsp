<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SearchResult</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/cafe/searchResult.css?after3">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
<c:import url="../default/header.jsp"/>
	<div class="result">
		<table id="resultTable">
			<tr>
				<!-- <th width="100px">cafe_no</th> -->
				<th colspan="2" width="250px">카페 이름</th>
				<th width="100px">평균 별점</th>
				<th width="300x">위치</th>
				<th width="200px">Kidszone</th>
				<th width="200px">Petzone</th>
				<th width="200px">영업 시간</th>
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
				<td id="pos"><a href="http://localhost:8080/root/review/cafe?no=${loc.cafe_no}">${loc.cafe_name}</a></td>
				<td><a href="http://localhost:8080/root/review/cafe?no=${loc.cafe_no}"><img id="zoom" src="${contextPath }/img/${loc.cafe_no}/${loc.imgName}" 
									width="200px" height="200px" width="200px" height="200px" width="200px" height="200px"></a></td>
				<td id="pos">${loc.avg_star}</td>
				<td id="pos">${loc.location2}</td>
				<c:if test="${loc.kidszone==0}">
				<td id="pos"> - </td>
				</c:if>
				<c:if test="${loc.kidszone==1}">
				<td id="pos">키즈카페</td>
				</c:if>
				<c:if test="${loc.kidszone==2}">
				<td id="pos">노키즈존</td>
				</c:if>
				<c:if test="${loc.kidszone==3}">
				<td id="pos">캐어키즈존</td>
				</c:if>
				<c:if test="${loc.petzone==0 }">
				<td id="pos">무관(정보없음)</td>
				</c:if>
				<c:if test="${loc.petzone==1 }">
				<td id="pos">펫카페</td>
				</c:if>
				<c:if test="${loc.petzone==2 }">
				<td id="pos">노펫존</td>
				</c:if>
				<c:if test="${loc.petzone==3 }">
				<td id="pos">펫허용존</td>
				</c:if>
				<td id="pos">${loc.use_time}</td>
				<!--  <td>${imageFileName}</td>-->
				<td>
					<input type="button" value="♡"  id="selectBu" onclick="location.href='${contextPath}/cafe/cafeSelect?cafe_no=${loc.cafe_no}&id=${loginUser}'">
					${loc.select_count }
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div align="center">
		<c:if test="${currentPage>1 }">
			<input type="button" class="moveBu" value="&lt;" onclick="location.href='${contextPath }/cafe/searchResult?num=${currentPage-1 }&location1=${location1}&kidszone=${kidszone}&petzone=${petzone}&star=${star}'">
		</c:if>
		<c:forEach var="it" begin="${startPage }" end="${endPage }">
			<c:if test="${it==currentPage }">
				<a class="currentPage" href="${contextPath }/cafe/searchResult?num=${it }&location1=${location1}&kidszone=${kidszone}&petzone=${petzone}&star=${star}">[${it }]</a>
			</c:if>
			<c:if test="${it!=currentPage }">
				<a href="${contextPath }/cafe/searchResult?num=${it }&location1=${location1}&kidszone=${kidszone}&petzone=${petzone}&star=${star}">[${it }]</a>
			</c:if>
		</c:forEach>
		<c:if test="${currentPage<totalPage }">
			<input type="button" class="moveBu" value="&gt;" onclick="location.href='${contextPath }/cafe/searchResult?num=${currentPage+1 }&location1=${location1}&kidszone=${kidszone}&petzone=${petzone}&star=${star}'">
		</c:if>
	</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>