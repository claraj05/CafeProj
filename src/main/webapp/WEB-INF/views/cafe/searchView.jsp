<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchView</title>
<style>
	.search_ctn{
		margin : 0 auto;
		text-align : center;
	}
</style>
</head>
<body>
<c:import url="../default/header.jsp"/>
	<div class="search_area">
		<form action="cafeAllList" method="get" id="cafeAllListForm">
			<input type="submit" value="전체카페보기">
		</form>
		<form action="searchResult" method="get" id="searchForm">
			<div class="search_ctn">
				<div class="search_loc">
					<ul>
						<li class="search_li">세부 지역2(서울시 25구) :</li>
					</ul>
					
					<ul>
						<li><input type="checkbox" id="r1" name="location1" value="1" />
							<label for="l1">강남구</label></li>
						<li><input type="checkbox" id="r2" name="location1" value="2" />
							<label for="l2">강동구</label></li>
						<li><input type="checkbox" id="r3" name="location1" value="3" />
							<label for="l3">강북구</label></li>
						<li><input type="checkbox" id="r4" name="location1" value="4" />
							<label for="l4">강서구</label></li>
						<li><input type="checkbox" id="r5" name="location1" value="5" />
							<label for="l5">관악구</label></li>
					</ul>
					<ul>
						<li><input type="checkbox" id="r6" name="location1" value="6" />
							<label for="l6">광진구</label></li>
						<li><input type="checkbox" id="r7" name="location1" value="7" />
							<label for="l7">구로구</label></li>
						<li><input type="checkbox" id="r8" name="location1" value="8" />
							<label for="l8">금천구</label></li>
						<li><input type="checkbox" id="r9" name="location1" value="9" />
							<label for="l9">노원구</label></li>
						<li><input type="checkbox" id="r10" name="location1" value="10" />
							<label for="l10">도봉구</label></li>
					</ul>
					<ul>
						<li><input type="checkbox" id="r11" name="location1" value="11" />
							<label for="l11">동대문구</label></li>
						<li><input type="checkbox" id="r12" name="location1" value="12" />
							<label for="l12">동작구</label></li>
						<li><input type="checkbox" id="r13" name="location1" value="13" />
							<label for="l13">마포구</label></li>
						<li><input type="checkbox" id="r14" name="location1" value="14" />
							<label for="l14">서대문구</label></li>
						<li><input type="checkbox" id="r15" name="location1" value="15" />
							<label for="l15">서초구</label></li>
					</ul>
					<ul>
						<li><input type="checkbox" id="r16" name="location1" value="16" />
							<label for="l16">성동구</label></li>
						<li><input type="checkbox" id="r17" name="location1" value="17" />
							<label for="l17">성북구</label></li>
						<li><input type="checkbox" id="r18" name="location1" value="18" />
							<label for="l18">송파구</label></li>
						<li><input type="checkbox" id="r19" name="location1" value="19" />
							<label for="l19">양천구</label></li>
						<li><input type="checkbox" id="r20" name="location1" value="20" />
							<label for="l20">영등포구</label></li>
					</ul>
					<ul>
						<li><input type="checkbox" id="r21" name="location1" value="21" />
							<label for="l21">용산구</label></li>
						<li><input type="checkbox" id="r22" name="location1" value="22" />
							<label for="l22">은평구</label></li>
						<li><input type="checkbox" id="r23" name="location1" value="23" />
							<label for="l23">종로구</label></li>
						<li><input type="checkbox" id="r24" name="location1" value="24" />
							<label for="l24">중구</label></li>
						<li><input type="checkbox" id="r25" name="location1" value="25" />
							<label for="l25">중랑구</label></li>
					</ul>
				</div>
				<div class="search_zone">
					<ul>
						<li class="search_li">키즈존 여부 : </li>
					</ul>
					<ul>
						<li><input type="radio" id="k0" name="kidszone" value="0" checked />
							<label for="k0">무관</label></li>
						<li><input type="radio" id="k1" name="kidszone" value="1" />
							<label for="k1">키즈존(전문키즈카페)</label></li>
						<li><input type="radio" id="k2" name="kidszone" value="2" />
							<label for="k2">노키즈존</label></li>
						<li><input type="radio" id="k3" name="kidszone" value="3" />
							<label for="k3">캐어키즈존</label></li>
					</ul>
					<ul>
						<li class="search_li">펫존 여부 : </li>
					</ul>
					<ul>
						<li><input type="radio" id="p0" name="petzone" value="0" checked/>
							<label for="p0">무관</label></li>
						<li><input type="radio" id="p1" name="petzone" value="1" />
							<label for="p1">펫존(전문펫카페)</label></li>
						<li><input type="radio" id="p2" name="petzone" value="2" />
							<label for="p2">노펫존</label></li>
						<li><input type="radio" id="p3" name="petzone" value="3" />
							<label for="p3">펫허용(전문펫카페x)</label></li>
					</ul>
					<ul>
						<li class="search_star">별점 높은 순 정렬</li>
					</ul>
					<ul>
						<li><input type="hidden" id="s0" name="star" value="0"></li>
						<li><input type="radio" id="s1" name="star" value="1"></li>
					</ul>
				</div>
			</div>
					 <br>
					 <input type="submit" value="전송">
		</form>
	</div>
<c:import url="../default/footer.jsp"/>

</body>
</html>