<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchView</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/cafe/cafeSearch.css?after3">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#tot").click(function(){
		if(this.checked){
			$("input#r1").prop("disabled",true);
			$("input#r2").prop("disabled",true);
			$("input#r3").prop("disabled",true);
			$("input#r4").prop("disabled",true);
			$("input#r5").prop("disabled",true);
			$("input#r6").prop("disabled",true);
			$("input#r7").prop("disabled",true);
			$("input#r8").prop("disabled",true);
			$("input#r9").prop("disabled",true);
			$("input#r10").prop("disabled",true);
			$("input#r11").prop("disabled",true);
			$("input#r12").prop("disabled",true);
			$("input#r13").prop("disabled",true);
			$("input#r14").prop("disabled",true);
			$("input#r15").prop("disabled",true);
			$("input#r16").prop("disabled",true);
			$("input#r17").prop("disabled",true);
			$("input#r18").prop("disabled",true);
			$("input#r19").prop("disabled",true);
			$("input#r20").prop("disabled",true);
			$("input#r21").prop("disabled",true);
			$("input#r22").prop("disabled",true);
			$("input#r23").prop("disabled",true);
			$("input#r24").prop("disabled",true);
			$("input#r25").prop("disabled",true);
			
			$("input#r1").prop("checked",true);
			$("input#r2").prop("checked",true);
			$("input#r3").prop("checked",true);
			$("input#r4").prop("checked",true);
			$("input#r5").prop("checked",true);
			$("input#r6").prop("checked",true);
			$("input#r7").prop("checked",true);
			$("input#r8").prop("checked",true);
			$("input#r9").prop("checked",true);
			$("input#r10").prop("checked",true);
			$("input#r11").prop("checked",true);
			$("input#r12").prop("checked",true);
			$("input#r13").prop("checked",true);
			$("input#r14").prop("checked",true);
			$("input#r15").prop("checked",true);
			$("input#r16").prop("checked",true);
			$("input#r17").prop("checked",true);
			$("input#r18").prop("checked",true);
			$("input#r19").prop("checked",true);
			$("input#r20").prop("checked",true);
			$("input#r21").prop("checked",true);
			$("input#r22").prop("checked",true);
			$("input#r23").prop("checked",true);
			$("input#r24").prop("checked",true);
			$("input#r25").prop("checked",true);
			
		}else{
			$("input#r1").prop("disabled",false);
			$("input#r2").prop("disabled",false);
			$("input#r3").prop("disabled",false);
			$("input#r4").prop("disabled",false);
			$("input#r5").prop("disabled",false);
			$("input#r6").prop("disabled",false);
			$("input#r7").prop("disabled",false);
			$("input#r8").prop("disabled",false);
			$("input#r9").prop("disabled",false);
			$("input#r10").prop("disabled",false);
			$("input#r11").prop("disabled",false);
			$("input#r12").prop("disabled",false);
			$("input#r13").prop("disabled",false);
			$("input#r14").prop("disabled",false);
			$("input#r15").prop("disabled",false);
			$("input#r16").prop("disabled",false);
			$("input#r17").prop("disabled",false);
			$("input#r18").prop("disabled",false);
			$("input#r19").prop("disabled",false);
			$("input#r20").prop("disabled",false);
			$("input#r21").prop("disabled",false);
			$("input#r22").prop("disabled",false);
			$("input#r23").prop("disabled",false);
			$("input#r24").prop("disabled",false);
			$("input#r25").prop("disabled",false);
			
			$("input#r1").prop("checked",false);
			$("input#r2").prop("checked",false);
			$("input#r3").prop("checked",false);
			$("input#r4").prop("checked",false);
			$("input#r5").prop("checked",false);
			$("input#r6").prop("checked",false);
			$("input#r7").prop("checked",false);
			$("input#r8").prop("checked",false);
			$("input#r9").prop("checked",false);
			$("input#r10").prop("checked",false);
			$("input#r11").prop("checked",false);
			$("input#r12").prop("checked",false);
			$("input#r13").prop("checked",false);
			$("input#r14").prop("checked",false);
			$("input#r15").prop("checked",false);
			$("input#r16").prop("checked",false);
			$("input#r17").prop("checked",false);
			$("input#r18").prop("checked",false);
			$("input#r19").prop("checked",false);
			$("input#r20").prop("checked",false);
			$("input#r21").prop("checked",false);
			$("input#r22").prop("checked",false);
			$("input#r23").prop("checked",false);
			$("input#r24").prop("checked",false);
			$("input#r25").prop("checked",false);
		}
	});
});
</script>

</head>
<body>
<c:import url="../default/header.jsp"/>
		
		<div class="filter_title">
			<h1>?????? ?????? ??????</h1>
		</div>
		<div class="cafeAll">
			<a href="${contextPath}/cafe/cafeAllList">?????? ?????? ?????????</a>
		</div>
		<br>
	<div class="search_area">
		<form action="searchResult" method="get" id="searchForm" name="searchForm">
			<div class="search_ctn">
				<div class="search_loc">
					<div class="search_title">
						<ul>
							<li>&lt;?????? ???????????? ??????&gt;</li>
						</ul>
					</div>
					<ul class="search_total">
						<li><input type="checkbox" id="tot" name="location1" value="0">&nbsp;?????? ??????</li>
					</ul>
							<br>
					
					<ul class="search_l1">
						<li><input type="checkbox" id="r1" name="location1" value="1" />
							<label for="l1">?????????</label></li>
						<li><input type="checkbox" id="r2" name="location1" value="2" />
							<label for="l2">?????????</label></li>
						<li><input type="checkbox" id="r3" name="location1" value="3" />
							<label for="l3">?????????</label></li>
						<li><input type="checkbox" id="r4" name="location1" value="4" />
							<label for="l4">?????????</label></li>
						<li><input type="checkbox" id="r5" name="location1" value="5" />
							<label for="l5">?????????</label></li>
					</ul>
					<ul class="search_l2">
						<li><input type="checkbox" id="r6" name="location1" value="6" />
							<label for="l6">?????????</label></li>
						<li><input type="checkbox" id="r7" name="location1" value="7" />
							<label for="l7">?????????</label></li>
						<li><input type="checkbox" id="r8" name="location1" value="8" />
							<label for="l8">?????????</label></li>
						<li><input type="checkbox" id="r9" name="location1" value="9" />
							<label for="l9">?????????</label></li>
						<li><input type="checkbox" id="r10" name="location1" value="10" />
							<label for="l10">?????????</label></li>
					</ul>
					<ul class="search_l3">
						<li><input type="checkbox" id="r11" name="location1" value="11" />
							<label for="l11">????????????</label></li>
						<li><input type="checkbox" id="r12" name="location1" value="12" />
							<label for="l12">?????????</label></li>
						<li><input type="checkbox" id="r13" name="location1" value="13" />
							<label for="l13">?????????</label></li>
						<li><input type="checkbox" id="r14" name="location1" value="14" />
							<label for="l14">????????????</label></li>
						<li><input type="checkbox" id="r15" name="location1" value="15" />
							<label for="l15">?????????</label></li>
					</ul>
					<ul class="search_l4">
						<li><input type="checkbox" id="r16" name="location1" value="16" />
							<label for="l16">?????????</label></li>
						<li><input type="checkbox" id="r17" name="location1" value="17" />
							<label for="l17">?????????</label></li>
						<li><input type="checkbox" id="r18" name="location1" value="18" />
							<label for="l18">?????????</label></li>
						<li><input type="checkbox" id="r19" name="location1" value="19" />
							<label for="l19">?????????</label></li>
						<li><input type="checkbox" id="r20" name="location1" value="20" />
							<label for="l20">????????????</label></li>
					</ul>
					<ul class="search_l5">
						<li><input type="checkbox" id="r21" name="location1" value="21" />
							<label for="l21">?????????</label></li>
						<li><input type="checkbox" id="r22" name="location1" value="22" />
							<label for="l22">?????????</label></li>
						<li><input type="checkbox" id="r23" name="location1" value="23" />
							<label for="l23">?????????</label></li>
						<li><input type="checkbox" id="r24" name="location1" value="24" />
							<label for="l24">??????</label></li>
						<li><input type="checkbox" id="r25" name="location1" value="25" />
							<label for="l25">?????????</label></li>
					</ul>
				</div>
				<div class="search_zone">
					<div class="search_kids">
						<div class="search_title">
							<ul>
								<li>&lt;????????? ??????&gt;</li>
							</ul>
						</div>
						<ul class="search_z1">
							<li><input type="radio" id="k0" name="kidszone" value="0" checked />
								<label for="k0">??????</label></li>
							<li><input type="radio" id="k1" name="kidszone" value="1" />
								<label for="k1">??????????????????</label></li>
							<li><input type="radio" id="k2" name="kidszone" value="2" />
								<label for="k2">????????????</label></li>
							<li><input type="radio" id="k3" name="kidszone" value="3" />
								<label for="k3">???????????????</label></li>
						</ul>
					</div>
					<div class="search_pet">
						<div class="search_title">
							<ul>
								<li>&lt;?????? ??????&gt;</li>
							</ul>
						</div>
						<ul class="search_z2">
							<li><input type="radio" id="p0" name="petzone" value="0" checked/>
								<label for="p0">??????</label></li>
							<li><input type="radio" id="p1" name="petzone" value="1" />
								<label for="p1">???????????????</label></li>
							<li><input type="radio" id="p2" name="petzone" value="2" />
								<label for="p2">?????????</label></li>
							<li><input type="radio" id="p3" name="petzone" value="3" />
								<label for="p3">??? ?????? ?????? ??????</label></li>
						</ul>
					</div>
				</div>
				<div class="search_star">
					<ul>
						<li class="search_title">&lt;?????? ?????? ??? ??????&gt;</li>
					</ul>
					<ul class="search_s">
						<li><input type="checkbox" id="s1" name="star" value="1"> On</li>
						<li><input type="hidden" id="s0" name="star" value="0"></li>
					</ul>
				</div>
			</div>
					 <br>
					 <input class="fbutton" type="button" value="??????" onclick="locationChk()">
		</form>
	</div>
<c:import url="../default/footer.jsp"/>
<script>
function locationChk(){
	   if($("input:checkbox[name='location1']").is(":checked")==false){
	      alert("????????? ????????? ????????? ???????????????(?????? 1?????? ?????? ?????? ??????")
	   }else{
	      document.searchForm.submit()
	   }
	}
</script>
</body>
</html>