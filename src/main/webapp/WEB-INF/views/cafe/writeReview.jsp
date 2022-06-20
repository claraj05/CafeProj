<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="header-container">
                ${id} 에 대한 솔직한 리뷰를 써주세요.
            </div>

            <div class="write-container">
                <form action="http://localhost:8080/root/review/writeReview" method="POST"
                    enctype="multipart/form-data">
                    <input name="cafeNo" value="2" style="display:none">
                    <input name="id" value="donghyeon" style="display:none">
                    <div class="fileImage-add-area">
                        <input type="text" name="grade">
                    </div>
                    <div>
                        <div class="text-editor-area">
                            <textarea name="content" id="" cols="30" rows="10"></textarea>
                            <span></span> / <span></span>
                        </div>

                        <div class="fileImage-add-area">
                            <input type="file" name="files">
                        </div>
                    </div>

                    <div class="btn-area">
                        <button id="cancle">취소</button>
                        <button id="save">리뷰 올리기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>