<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>카페 전체 목록</h1>
	<c:import url="../default/header.jsp"/>
	<div class="result">
	<c:if test="${list.size()==null }">
		검색 리스트 없음
	</c:if>
	<c:if test="${list.size()!=null }">
		있어도 안 나옴ㅎ
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