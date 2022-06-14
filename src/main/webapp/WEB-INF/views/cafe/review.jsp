<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="review.css" rel="stylesheet" type="text/css">
    <!-- icon -->
    <script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
    <link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<c:import url="../default/header.jsp"/>
<div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="header-area">
                    <div class="col-md-12">
                        <!-- 이곳은 jsp로 만들어진 부분을 사용함 -->
                        헤더 영역
                    </div>
                </div>
                <div class="picture-area">
                    <div class="col-md-12">
                        사진 영역
                        <ul>
                            <li></li>
                        </ul>
                    </div>
                </div>
                <div class="review-area">
                    <div class="section-restaurant">
                        <div class="inner">
                            <div class="restaurant-header">
                                <div class="restaurant-title-wrap">
                                    <div class="section-tilte">
                                        <h2 class="restaurant-title"></h2>
                                        <div class="btn-area">
                                            <button>write-review</button>
                                        </div>
                                    </div>


                                    <div class="restaurant-status">
                                        스테이스 영역~
                                    </div>

                                </div>

                                <div class="section-restaurant-detail">
                                    <table border="1">
                                        <tr>
                                            <td class="detail-col-size" >주소</td>
                                            <td>${cafeDetail.addr}</td>
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
                                            <td class="detail-col-size">주차</td>
                                            <td>${cafeDetail.cafe_tel}</td>
                                        </tr>
                                        <tr>
                                            <td class="detail-col-size">영업시간</td>
                                            <td>${cafeDetail.cafe_tel}</td>
                                        </tr>
                                        <tr>
                                            <td class="detail-col-size">마지막 주문</td>
                                            <td>${cafeDetail.use_time}</td>
                                        </tr>
                                        <tr>
                                            <td>휴일</td>
                                            <td>gd</td>
                                        </tr>
                                        <tr>
                                            <td class="detail-col-size">메뉴</td>
                                            <td>
                                                <ul>
                                                    <li></li>
                                                </ul>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="section-restaurant-reviews">
                                리뷰 영역
                            </div>
                        </div>
                    </div>
                    <div class="map">
                        지도 영역
                    </div>
                </div>
            </div>
        </div>
    </div>
<c:import url="../default/footer.jsp"/>
</body>
</html>