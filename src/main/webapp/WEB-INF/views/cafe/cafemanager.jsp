<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cafemanger.jsp</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/cafe/cafemanager.css">
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
		<div class="write_save"> <!-- enctype ="application/x-www-form-urlencoded"  -->
			<form action="http://localhost:8080/root/cafe/writeSave" enctype="multipart/form-data" method="post">
			
				<div class="int-area">
				<label for="cafe_name">카페 이름 </label>
				<input type="hidden" name="cafe_no" value="1">				
				<input type="text" name="cafe_name" size="50"><br>
				</div>
				<div class="int-area">
				<label for="cafe_name">카페 위치(서울 시 내 25구 중 알맞은 코드 입력)</label>
				<select id = "location1" name = "location1" size = "1">
						<option value = "0">----선택----</option>
						<option value = "1">강남구</option>
						<option value = "2">강동구</option>
						<option value = "3">강북구</option>
						<option value = "4">강서구</option>
						<option value = "5">관악구</option>
						<option value = "6">광진구</option>
						<option value = "7">구로구</option>
						<option value = "8">금천구</option>
						<option value = "9">노원구</option>
						<option value = "10">도봉구</option>
						<option value = "11">동대문구</option>
						<option value = "12">동작구</option>
						<option value = "13">마포구</option>
						<option value = "14">서대문구</option>
						<option value = "15">서초구</option>
						<option value = "16">성동구</option>
						<option value = "17">성북구</option>
						<option value = "18">송파구</option>
						<option value = "19">양천구</option>
						<option value = "20">영등포구</option>
						<option value = "21">용산구</option>
						<option value = "22">은평구</option>
						<option value = "23">종로구</option>
						<option value = "24">중구</option>
						<option value = "25">중랑구</option>
					</select>
				<!-- <input type="text" name="location1" size="50"><br> -->
				</div>
				
				<div class="int-area">
				<label for="cafe_name">카페 상세주소 </label>
				<input type="text" name="location2" size="100"><br>
				</div>
				
				<div class="int-area">
				<label for="cafe_name">카페 연락처</label>
				<input type="text" name="cafe_tel" size="100"><br>
				</div>
				<div class="int-area">
				<label for="cafe_name">카페 메뉴</label>
				<input type="text" name="menu" size="50"><br>
				</div>
				
				<div class="button-area">
				<label for="cafe_name">키즈존</label>
				<input type="radio" name="kidszone" value="0">정보없음
				<input type="radio" name="kidszone" value="1">키즈존(전문)
				<input type="radio" name="kidszone" value="2">노키즈존
				<input type="radio" name="kidszone" value="3">캐어키즈존<br>
				</div>
				
				<div class="button-area">
				<label for="cafe_name">팻존</label>
				<input type="radio" name="petzone" value="0">정보없음
				<input type="radio" name="petzone" value="1">펫존(애견카페O)
				<input type="radio" name="petzone" value="2">노펫존
				<input type="radio" name="petzone" value="3">펫허용(애견카페x)<br>
				</div>
				
				<div class="int-area">
				<label for="cafe_name">영업 시간 </label>
				<input type="text" name="use_time"><br>
				<!-- <p>open<input type="time" name="starttime"></p>
				<p>close<input type="time" name="endtime"></p> -->
	 			<br>
	 			</div>
	 			
	 			<div class="int-area">
				<label for="file">파일 첨부</label>
				파일 : <input type="file" name="multiFiles" multiple> <br>
				파일 설명 : <input type="text" name="imgContent"><br>
				<img id="preview" src="#" width="100px" height="100px">
				<br>
				</div>
				
				<div class="btn-area">
				<input type="submit" value="업로드"> &nbsp;
				</div>
			</form>
		</div>
	</div>

</body>
</html>











