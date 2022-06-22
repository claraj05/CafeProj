<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link
	href="${pageContext.request.contextPath}/resources/css/index.css?after"
	rel="stylesheet" type="text/css">
</head>
<body>
	<c:import url="default/header.jsp" />
	<div class="board_text">
        <div class="main-container">
            <div class="recommand-cafe-list">
                <div class="sector-one">
                    <figure class="recommend">
                        <img src="">
                        <figcaption>
                            <div class="recommand-info">
                                <div class="info-title">

                                </div>
                            </div>
                        </figcaption>
                    </figure>
                    <figure class="recommend">
                        <img src="">
                        <figcaption>
                            <div class="recommand-info">
                               hi2
                            </div>
                        </figcaption>
                    </figure>
                    <figure class="recommend">
                        <img src="">
                        <figcaption>
                            <div class="recommand-info">
                                hi3
                            </div>
                        </figcaption>
                    </figure>
                </div>
                <div class="sector-two">
                    <figure class="recommend">
                        <img src="">
                        <figcaption>
                            <div class="recommand-info">
                                hi4
                            </div>
                        </figcaption>
                    </figure>
                    <figure class="recommend">
                        <img src="">
                        <figcaption>
                            <div class="recommand-info">
                                hi5
                            </div>
                        </figcaption>
                    </figure>
                    <figure class="recommend">
                        <img src="">
                        <figcaption>
                            <div class="recommand-info">
                                hi6
                            </div>
                        </figcaption>
                    </figure>
                </div>
            </div>
        </div>
    </div>
	<script src="${pageContext.request.contextPath}/resources/script/index.js"></script>

	<c:import url="default/footer.jsp" />

</body>
</html>