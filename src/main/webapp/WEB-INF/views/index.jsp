<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index.css?after3">
</head>
<body>
	<c:import url="default/header.jsp" />
	<div class="board_text">
		<div class="main-container">
			<div class="recommand-cafe-list">
				<div class="sector-one">
					<c:forEach var="item" items="${recommandSectionOne}">
						<a href="http://localhost:8080/root/review/cafe?no=${item.cafe_no}" class="recommend"
								style="background-image: url(/root/img/${item.cafe_no}/${item.imgName}); background-size: cover;">
							<div class="recommand-container">
								<div class="recommand-info">
									<div class="info-title">${item.cafe_name}</div>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
				<div class="sector-two">
					<c:forEach var="item" items="${recommandSectionTwo}">
						<a href="http://localhost:8080/root/review/cafe?no=${item.cafe_no}" class="recommend" 
								style="background-image: url(/root/img/${item.cafe_no}/${item.imgName}); background-size: cover;">
							<div class="recommand-container">
								<div class="recommand-info">
									<div class="info-title">${item.cafe_name}</div>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/script/index.js"></script>

	<c:import url="default/footer.jsp" />

</body>
</html>