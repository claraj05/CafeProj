<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/cafe/cafeSearchResult.css?after1">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$("#star").click(function(){
			if(this.checked){
				location.href="${contextPath}/cafe/cafeAllListS"
			}else{
				location.href="${contextPath}/cafe/cafeAllList"
			}
			
		});
	});
</script>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	<h1 align="center">카페 전체 목록</h1>
	<div class="highstar">
		<input type="hidden" name="star"  value="0" checked>
		<c:if test="${star==1 }">
			<input type="checkbox" id="star" name="star" value="1" checked>별점 높은 순으로 정렬 On
		</c:if>
		<c:if test="${star==0 }">
			<input type="checkbox" id="star" name="star" value="0">별점 높은 순으로 정렬 On
		</c:if>
	</div>
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
				<td><a href="http://localhost:8080/root/review/cafe?no=${loc.cafe_no}">${loc.cafe_name}</a></td>
				<td><a href="http://localhost:8080/root/review/cafe?no=${loc.cafe_no}"><img id="zoom" src="${contextPath }/img/${loc.cafe_no}/${loc.imgName}" 
									width="200px" height="200px"></a>
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
			<c:if test="${star==1 }">
			<input type="button" class="moveBu" value="&lt;" onclick="location.href='${contextPath }/cafe/cafeAllListS?num=${currentPage-1 }&star=${star }'">
			</c:if>
			<c:if test="${star==0 }">
			<input type="button" class="moveBu" value="&lt;" onclick="location.href='${contextPath }/cafe/cafeAllList?num=${currentPage-1 }&star=${star }'">
			</c:if>
		</c:if>
		<c:forEach var="num" begin="${startPage }" end="${endPage }">
			<c:if test="${num==currentPage }">
				<c:if test="${star==1 }">
				<a href="${contextPath }/cafe/cafeAllListS?num=${num }&star=${star }" class="currentPage">[${num }]</a>
				</c:if>
				<c:if test="${star==0 }">
				<a href="${contextPath }/cafe/cafeAllList?num=${num }&star=${star }" class="currentPage">[${num }]</a>
				</c:if>
			</c:if>
			<c:if test="${num!=currentPage }">
				<c:if test="${star==1 }">
				<a href="${contextPath }/cafe/cafeAllListS?num=${num }&star=${star }">[${num }]</a>
				</c:if>
				<c:if test="${star==0 }">
				<a href="${contextPath }/cafe/cafeAllList?num=${num }&star=${star }">[${num }]</a>
				</c:if>
			</c:if>
		</c:forEach>
		<c:if test="${currentPage<totalPage }">
			<c:if test="${star==1 }">
			<input type="button" class="moveBu" value="&gt;" onclick="location.href='${contextPath }/cafe/cafeAllListS?num=${currentPage+1 }&star=${star }'">
			</c:if>
			<c:if test="${star==0 }">
			<input type="button" class="moveBu" value="&gt;" onclick="location.href='${contextPath }/cafe/cafeAllList?num=${currentPage+1 }&star=${star }'">
			</c:if>
		</c:if>
	</div>
<c:import url="../default/footer.jsp"/>

</body>
</html>