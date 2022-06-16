<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EventView</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/cafe/eventView.css">
</head>
<body>
	<!-- 이벤트 뷰에 있는 이벤트를 클릭하면 해당 카페 메인화면을 보여주면서, 우측 또는 상단에 이벤트 중 배너 표시 예정 -->
	<c:import url="../default/header.jsp"/>
	<h1 align="center">Event!</h1>
		<div class="eventPage">
			<div class="top">
				<div class="left">
					<div class="event1">
						 event1
						 <c:forEach var="ev1" items="${event1}">
						 	${ev1.event_no }<br>
						 	${ev1.event_type }<br>
						 	${ev1.event_content }<br>
						 	${ev1.event_time }<br>
						 </c:forEach>
					</div>
				</div>
				<div class="right">
					<div class="event2">
						event2
						<c:forEach var="ev2" items="${event2}">
						 	${ev2.event_no }<br>
						 	${ev2.event_type }<br>
						 	${ev2.event_content }<br>
						 	${ev2.event_time }<br>
						 </c:forEach>
					</div>
				</div>
			</div>
			<div class="bottom">
				<div class="left">
				<div class="event3">
					 event3
					 <c:forEach var="ev3" items="${event3}">
						 	${ev3.event_no }<br>
						 	${ev3.event_type }<br>
						 	${ev3.event_content }<br>
						 	${ev3.event_time }<br>
						 </c:forEach>
				</div>
			</div>
			<div class="right">
				<div class="event4">
					event4
					<c:forEach var="ev4" items="${event4}">
						 	${ev4.event_no }<br>
						 	${ev4.event_type }<br>
						 	${ev4.event_content }<br>
						 	${ev4.event_time }<br>
						 </c:forEach>
				</div>
			</div>
			</div>
		</div>

	<c:import url="../default/footer.jsp"/>
</body>
</html>