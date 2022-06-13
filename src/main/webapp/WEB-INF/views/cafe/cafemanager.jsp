<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cafemanger.jsp</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function readURL(input) {
		var file = input.files[0] //파일 정보
		if(file != "" ) {
			var reader = new FileReader()
			reader.readAsDataURL(file) // 파일 정보 읽어오기
			reader.onload = function(e) {
				$("#preview").attr("src", e.target.result)
			}
		}
	}
</script>
</head>
<body>
	<h1 class="write_title">카페 추가하기 </h1>
	<div class="write">
		<div class="write_save">
			<form action="${contextPath }/cafe/writeSave" enctype="multipart/form-data" method="post">
				
<!--create table cafe(
 cafe_no number(30) primary key,  얘는 시퀀스로 입력받기 ㅇㅋ?
cafe_name varchar2(100) not null, 
location1 varchar2(20) not null, --@@동
location2 varchar2(100) not null, --상세주소
cafe_tel varchar2(20), 
menu varchar2(1000), --메뉴
kidszone number(10), --0: 정보없음/ 1 : 키즈존(전문) /2: 노키즈존 / 3:캐어키즈존 
petzone number(10), --0:정보없음/ 1: 펫존(애견카페o) / 2:노펫존 / 3:펫허용(애견카페x)
use_time varchar2(30), --오전 ~~:~~ ~ 오후 ~~:~~ 까지 포맷으로
imageFileName varchar2(1000) not null,
avg_star number(10,2), --평균 별점
logtime date default sysdate --등록일 mybatis.cafe있어?패키지
);음 mapping이 안된거야 그 mapper에서 Filemapper 내가 매퍼 만들게 -->
>
				<b>카페 이름 </b><br>
				<input type="text" name="cafe_name" size="50"><br>
				<b>카페 위치(서울 시 내 25구 중 알맞은 코드 입력) </b><br>
				<input type="text" name="location1" size="50"><br>
				<b>카페 상세주소 </b><br>
				<input type="text" name="location2" size="100"><br>
				<b>카페 연락처 </b><br>
				<input type="text" name="location2" size="100"><br>
				<b>카페 메뉴</b>
				<input type="text" name="menu" size="50"><br>
				<b>키즈존</b>
				<input type="radio" name="kidszone" value="0">정보없음
				<input type="radio" name="kidszone" value="1">키즈존(전문)
				<input type="radio" name="kidszone" value="2">노키즈존
				<input type="radio" name="kidszone" value="3">캐어키즈존<br>
				<b>팻존</b>
				<input type="radio" name="petzone" value="0">정보없음
				<input type="radio" name="petzone" value="1">펫존(애견카페O)
				<input type="radio" name="petzone" value="2">노펫존
				<input type="radio" name="petzone" value="3">펫허용(애견카페x)<br>
				<b>영업시간</b>
				<p>open<input type="time" name="starttime"></p>
				<p>close<input type="time" name="endtime"></p>
				
				<b>이미지 파일명</b>
				<input type="text" name="imageFileName" value="nan">
				
				
				<br>
				<b>파일 첨부 </b>
			<%-- 	<c:if test="${data.imageFileName == 'nan' }">
					<b>이미지가 없습니다</b>
				</c:if>
				<c:if test="${data.imageFileName != 'nan' }">
					<img src="${contextPath }/board/download?imageFileName=${data.imageFileName }"
						width="200px" height="200px">
				</c:if> --%>
				<input type="file" name="nan" onchange="readURL(this)">
				<img id="preview" src="#" width="100px" height="100px">
				<br>
				<input type="submit" value="업로드"> &nbsp;
			</form>
			<a href="${contextPath }/views">파일 보기</a>
		</div>
	</div>

</body>
</html>











