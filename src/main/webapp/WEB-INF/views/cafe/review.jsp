<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/review.css" rel="stylesheet"
	type="text/css">
<!-- icon -->
<script
	src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
<link
	href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<c:import url="../default/header.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="header-area">
				</div>
				<!-- picture area -->
				<div class="picture-area">
					<div class="picture-lists">
						<ul class="picture-title" id="picture-container">
							<c:if test="${cafeImage != null}">
								<c:forEach var="imgLink" items="${cafeImage}" varStatus="status">
									<li><img src="url(imgLink)"></li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
				</div>
				<!-- review area -->
				<div class="review-area">
					<div class="section-restaurant">
						<div class="inner">
							<div class="restaurant-header">
								<div class="restaurant-title-wrap">
									<div class="section-tilte">
										<h2 class="restaurant-title" value="${cafeDetail.cafe_name}">${cafeDetail.cafe_name}</h2>
										<h2 class="restaurant-avg" value="${cafeDetail.avg_star}">${cafeDetail.avg_star}</h2>
										<div class="btn-area">
											<button><a href="http://localhost:8080/root/review/writePage/${cafeDetail.cafe_no}">리뷰쓰기</a></button>
										</div>
									</div>
									<div class="restaurant-status">스테이스 영역~</div>
								</div>
								<div class="section-restaurant-detail"
									value="${cafeDetail.cafe_no }">
									<table>
										<tr>
											<td class="detail-col-size">주소</td>
											<td>${cafeDetail.location1 }${cafeDetail.location2 }</td>
										</tr>
										<tr>
											<td class="detail-col-size">전화번호</td>
											<td>${cafeDetail.cafe_tel}</td>

										</tr>
										<tr>
											<td class="detail-col-size">음식 종류</td>
											<td>${cafeDetail.menu}</td>

										</tr>
										<tr>
											<td class="detail-col-size">가격대</td>
											<td>${cafeDetail.cafe_tel}</td>
										</tr>
										<tr>
											<td class="detail-col-size">키드존 여부</td>
											<td>
												<c:if test="${cafeDetail.kidszone == 0}">
													<c:out value="정보 없음" />
												</c:if> <c:if test="${cafeDetail.kidszone == 1}">
													<c:out value="키즈존(전문)" />
												</c:if> <c:if test="${cafeDetail.kidszone == 2}">
													<c:out value="노키즈존" />
												</c:if> <c:if test="${cafeDetail.kidszone == 3}">
													<c:out value="캐어키즈존" />
												</c:if>
											</td>
										</tr>
										<tr>
											<td class="detail-col-size">펫존 여부</td>
											<td><c:if test="${cafeDetail.petzone == 0}">
													<c:out value="정보 없음" />
												</c:if> <c:if test="${cafeDetail.petzone == 1}">
													<c:out value="펫존(애견카페o)" />)</c:if> <c:if
													test="${cafeDetail.petzone == 2}">
													<c:out value="노펫존" />
												</c:if> <c:if test="${cafeDetail.petzone == 3}">
													<c:out value="펫허용(애견카페x)" />
												</c:if>
											</td>
										</tr>
										<tr>
											<td class="detail-col-size">영업시간</td>
											<td>${cafeDetail.logtime}</td>
										</tr>
										<tr>
											<td class="detail-col-size">마지막 주문</td>
											<td>${cafeDetail.use_time}</td>
										</tr>
										<tr>
											<td class="detail-col-size">메뉴</td>
											<td>${cafeDetail.menu}</td>
										</tr>
									</table>
									<p class="update_date">${cafeDetail.logtime }</p>
								</div>
							</div>
							<div class="section-restaurant-reviews">
								<div class="review-header">
									<h3 class="rivew-count">
										리뷰(
										<c:choose>
											<c:when test="${fn:length(reviewDetail) != 0 }">
												<c:out value="${fn:length(reviewDetail)}" />
											</c:when>
											<c:otherwise>
												<c:out value="0" />
											</c:otherwise>
										</c:choose>
										)
									</h3>
								</div>

								<div class="review-container">
									<ul class="review-lists">
										<c:forEach var="review" items="${reviewDetail}" begin="0" end="${fn:length(reviewDetail)}" varStatus="status">
											<li class="review-info">
												<div class="review-title" value="${review.review_no}">
													<span>${review.id}</span>
												</div>
												<div class="review-content">
													<div class="review-text">${review.review_content}~</div>
													<div class="review-image">
														<ul class="image">
															<c:if test="${fn:length(review.reviewImageDTOs) != 0}">
																<c:forEach var="imgs" items="${review.reviewImageDTOs}">
																	<li><img src="/resources/${imgs.imageLocation}/${imgs.imageFileName}"/></li>
																</c:forEach>
															</c:if>
														</ul>
													</div>
												</div>
												<div class="review-grade">
													<span>평점 :</span>
													<span>${review.grade}</span>
												</div>
												<div class="update">
													<a>수정</a>
												</div>
												<div class="delete">
													<a>삭제</a>
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>

								<c:if test="${fn:length(reviewDetail) > 5 }">
									<div class="more-review-area">
										<button>더보기</button>
									</div>
								</c:if>
								<c:if test="${fn:length(reviewDetail) == 0 }">
									<div class="non-review">리뷰 없음</div>
								</c:if>
							</div>
						</div>
					</div>
					<!-- <div class="map">지도 영역</div> -->
				</div>
			</div>
		</div>
	</div>
	<c:import url="../default/footer.jsp" />
</body>
</html>