<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/writePage.css?after3" rel="stylesheet"
   type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="header-container">
                ${cafe_name} 에 대한 솔직한 리뷰를 써주세요.
            </div>

            <div class="write-container">
                <form action="http://localhost:8080/root/review/writeReview" method="POST"
                    enctype="multipart/form-data">
                    
                    
                    <div class="text-container">
                        <div class="grade-area">
                            <h3>평점 : <input type="text" name="grade" id="grade" value="" hidden></h3>
                            <button type="button" value="1" class="grade-btn">
                                <span class="material-symbols-outlined">
                                    sentiment_extremely_dissatisfied
                                </span>
                            </button>
                            <button type="button" value="2" class="grade-btn">
                                <span value="2" class="material-symbols-outlined">
                                    sentiment_dissatisfied
                                </span>
                            </button>
                            <button type="button" value="3" class="grade-btn">
                                <span value="3" class="material-symbols-outlined">
                                    sentiment_neutral
                                </span>
                            </button>
                            <button type="button" value="4" class="grade-btn">
                                <span value="4" class="material-symbols-outlined">
                                    mood
                                 </span>
                            </button>
                            <button type="button" value="5" class="grade-btn">
                                <span value="5" class="material-symbols-outlined">
                                    sentiment_very_satisfied
                                </span>
                            </button>
                        </div>
                        <div class="text-editor-area">
                            <textarea name="content" id="" cols="30" rows="10" placeholder="${loginUser} 님의 리뷰를 써주세요!"></textarea>
                            <!-- <span></span> / <span></span> -->
                        </div>
                    </div>
                    
                    <input name="cafeNo" value="${cafe_no}" style="display:none">
                    <input name="id" value="${loginUser}" style="display:none">
               <div class="fileImage-container">
                  <div class="fileImage-area">
                     <input multiple="multiple" type="file" name="files">
                  </div>
               </div>
               <div class="btn-area">
                        <a href="http://localhost:8080/root/review/cafe?no=${cafe_no}"><div id="cancle">취소</div></a>
                        <button id="save">리뷰 올리기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/resources/script/grade.js?v=1"></script>
    <script src="img.js"></script>
</body>
</html>