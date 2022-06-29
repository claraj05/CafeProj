<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EventView</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/cafe/eventView.css?after2">
</head>
<body>
   <!-- 이벤트 뷰에 있는 이벤트를 클릭하면 해당 카페 메인화면을 보여주면서, 우측 또는 상단에 이벤트 중 배너 표시 예정 -->
   <c:import url="../default/header.jsp"/>
   <h1 align="center">Event!</h1>
      <div class="eventPage">
         <div class="top">
            <div class="left">
               <a href="http://localhost:8080/root/review/cafe?no=${ev1.cafe_no}">
                  <div class="event1">
                     <div class="ev">
                         <img src="${contextPath }/img/${ev1.cafe_no}/${ev1_img.imgName}" align="center" width="60%" height="300px">
                     </div>
                            <%-- ${ev1.event_no }<br> --%>
                     <div class="text-area">
                        <h2>${ev1.event_type }</h2>
                        <br>
                        ◆<b>상세 내용 : </b>${ev1.event_content }◆<br>
                        ◆<b>이벤트 기간 : </b>${ev1.event_time }◆<br>
                     </div>
                  </div>
               </a>
            </div>
            <div class="right">
               <a href="http://localhost:8080/root/review/cafe?no=${ev2.cafe_no}">
                  <div class="event2">
                     <div class="ev">
                         <img src="${contextPath }/img/${ev2.cafe_no}/${ev2_img.imgName}" align="center" width="60%" height="300px">
                     </div>
                     <div class="text-area">   
                         <h2>${ev2.event_type }</h2>
                        <br>
                        ◆<b>상세 내용 : </b>${ev2.event_content }◆<br>
                        ◆<b>이벤트 기간 : </b>${ev2.event_time }◆<br>
                     </div>
                  </div>
               </a>
            </div>
         </div>
         <div class="bottom">
            <div class="left">
            <a href="http://localhost:8080/root/review/cafe?no=${ev3.cafe_no}">
               <div class="event3">
                  <div class="ev">
                      <img src="${contextPath }/img/${ev3.cafe_no}/${ev3_img.imgName}" align="center" width="60%" height="300px">
                  </div>
                  <div class="text-area">   
                     <h2>${ev3.event_type }</h2>
                     <br>
                     ◆<b>상세 내용 : </b>${ev3.event_content }◆<br>
                     ◆<b>이벤트 기간 : </b>${ev3.event_time }◆<br>
                  </div>
               </div>
            </a>
         </div>
         <div class="right">
            <a href="http://localhost:8080/root/review/cafe?no=${ev4.cafe_no}">
            <div class="event4">
               <div class="ev">
                   <img src="${contextPath }/img/${ev4.cafe_no}/${ev4_img.imgName}" align="center" width="60%" height="300px">
               </div>
               <div class="text-area">   
                  <h2>${ev4.event_type }</h2>
                  <br>
                  ◆<b>상세 내용 : </b>${ev4.event_content }◆<br>
                  ◆<b>이벤트 기간 : </b>${ev4.event_time }◆<br>
               </div>
            </div>
            </a>
         </div>
         </div>
      </div>

   <c:import url="../default/footer.jsp"/>
</body>
</html>