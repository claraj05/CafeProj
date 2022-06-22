<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c"%>     
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	
<title>board/boardWriteForm</title>
<style>
table{
text-align:center;
width:80%;
margin:20px auto;
}
tr{
height:50px;
}
.title{
width:100%;
height:40px;
}
.content{
width:100%;
height:400px;
}
div{
text-align:center;
}
.cancleBu, .modifyBu{
width:80px;
height:30px;
}
.image1, .image2, .image3{
display:none;
}
#preview1:hover, #preview2:hover, #preview3:hover{
width:100%;
height:100%;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${contextPath }/resources/script/boardScript.js?v=4"></script>
<script>
function modifyCancle(){
	var check=confirm("취소하시겠습니까?")
	if(check){
		location.href="${contextPath}/board/boardList"
	}
}
</script>
</head>
<body>
	<c:import url="../default/header.jsp" />
	
	<h1 align="center">자유 게시판</h1>
	
	<form action="boardModify" method="post" enctype="multipart/form-data" name="boardModifyForm">
		<input type="hidden" name="write_no" value="${board.write_no }">
		<input type="hidden" name="imageFileName1" id="imageFileName1" value="${boardImage.imageFileName1 }">
		<input type="hidden" name="imageFileName2" id="imageFileName2" value="${boardImage.imageFileName2 }">
		<input type="hidden" name="imageFileName3" id="imageFileName3" value="${boardImage.imageFileName3 }">
		<input type="hidden" name="check1" id="check1" value="1">
		<input type="hidden" name="check2" id="check2" value="1">
		<input type="hidden" name="check3" id="check3" value="1">
		<table border="1">
			<tr>
				<td colspan="3"><input type="text" name="title" placeholder="제목" value="${board.title }" class="title"></td>
			</tr>
			<tr>
				<td colspan="3"><textarea name="content" placeholder="내용" class="content">${board.content }</textarea></td>
			</tr>
			<tr>
				<td>
					<c:if test="${boardImage.imageFileName1!=null }">
						<div id="image1">
							<img src="${contextPath}/board/download1?imageFileName1=${boardImage.imageFileName1}" id="preview1" width=100px height=100px>
							<input type="button" value="X" onclick="removePreImage1()">
						</div>
					</c:if>
					<c:if test="${boardImage.imageFileName1==null }">
						<div id="image1" class="image1">
							<img src="${contextPath}/board/download1?imageFileName1=${boardImage.imageFileName1}" id="preview1" width=100px height=100px>
							<input type="button" value="X" onclick="removePreImage1()">
						</div>
					</c:if>
				</td>
				
				<td>
					<c:if test="${boardImage.imageFileName2!=null }">
						<div id="image2">
							<img src="${contextPath}/board/download2?imageFileName2=${boardImage.imageFileName2}" id="preview2" width=100px height=100px>
							<input type="button" value="X" onclick="removePreImage2()">
						</div>
					</c:if>
					<c:if test="${boardImage.imageFileName2==null }">
						<div id="image2" class="image2">
							<img src="${contextPath}/board/download2?imageFileName2=${boardImage.imageFileName2}" id="preview2" width=100px height=100px>
							<input type="button" value="X" onclick="removePreImage2()">
						</div>
					</c:if>
				</td>
				
				<td>
					<c:if test="${boardImage.imageFileName3!=null }">
						<div id="image3">
							<img src="${contextPath}/board/download3?imageFileName3=${boardImage.imageFileName3}" id="preview3" width=100px height=100px>
							<input type="button" value="X" onclick="removePreImage3()">
						</div>
					</c:if>
					<c:if test="${boardImage.imageFileName3==null }">
						<div id="image3" class="image3">
							<img src="${contextPath}/board/download3?imageFileName3=${boardImage.imageFileName3}" id="preview3" width=100px height=100px>
							<input type="button" value="X" onclick="removePreImage3()">
						</div>
					</c:if>
				</td>			
			</tr>
			<tr>
				<td><input type="file" name="file1" onchange="readURL1(this)"></td>
				<td><input type="file" name="file2" onchange="readURL2(this)"></td>
				<td><input type="file" name="file3" onchange="readURL3(this)"></td>
			</tr>			
		</table>
		<div>
			<input type="button" value="취소" class="cancleBu" onclick="modifyCancle()">
			<input type="button" value="수정" class="modifyBu" onclick="checkBoardModify()">
		</div>
	</form>	
	
	<c:import url="../default/footer.jsp" />
	<script>
	function checkBoardModify(){
		   if(document.boardModifyForm.title.value==""){
		      alert("제목을 입력하세요")
		      document.boardModifyForm.title.focus()
		   }else if(document.boardModifyForm.content.value==""){
		      alert("내용을 입력하세요")
		      document.boardModifyForm.content.focus()
		   }else{
		      var check=confirm("수정하시겠습니까?")
		      if(check){
		         document.boardModifyForm.submit()
		         alert("수정되었습니다")
		      }
		   }
		}
	</script>
		<script type="text/javascript">
function readURL1(input){ //미리보기 기능
	   var file=input.files[0] //파일 정보
	   if(file!=""){ //파일 등록o
	      var reader=new FileReader()
	      reader.readAsDataURL(file) //파일 정보 읽어오기
	      reader.onload=function(e){ //읽기에 성공하면 결과 표시 
	         $("#preview1").attr("src", e.target.result)
	         $("#image1").removeClass("image1")
	         $("#check1").attr("value","1")
	   	}	
	   }
	}
	function readURL2(input){ //미리보기 기능
	   var file=input.files[0] //파일 정보
	   if(file!=""){ //파일 등록o
	      var reader=new FileReader()
	      reader.readAsDataURL(file) //파일 정보 읽어오기
	      reader.onload=function(e){ //읽기에 성공하면 결과 표시 
	         $("#preview2").attr("src", e.target.result)
	         $("#image2").removeClass("image2")
	         $("#check2").attr("value","1")
	      }
	   }
	}
	function readURL3(input){ //미리보기 기능
	   var file=input.files[0] //파일 정보
	   if(file!=""){ //파일 등록o
	      var reader=new FileReader()
	      reader.readAsDataURL(file) //파일 정보 읽어오기
	      reader.onload=function(e){ //읽기에 성공하면 결과 표시 
	         $("#preview3").attr("src", e.target.result)
	         $("#image3").removeClass("image3")
	         $("#check3").attr("value","1")
	      }
	   }
	}
	function checkBoardWrite(){
	   if(document.boardWriteForm.title.value==""){
	      alert("제목을 입력하세요")
	      document.boardWriteForm.title.focus()
	   }else if(document.boardWriteForm.content.value==""){
	      alert("내용을 입력하세요")
	      document.boardWriteForm.content.focus()
	   }else{
	      document.boardWriteForm.submit()
	      alert("등록되었습니다")
	   }
	}
	function checkBoardModify(){
	   if(document.boardModifyForm.title.value==""){
	      alert("제목을 입력하세요")
	      document.boardModifyForm.title.focus()
	   }else if(document.boardModifyForm.content.value==""){
	      alert("내용을 입력하세요")
	      document.boardModifyForm.content.focus()
	   }else{
	      var check=confirm("수정하시겠습니까?")
	      if(check){
	         document.boardModifyForm.submit()
	         alert("수정되었습니다")
	      }
	   }
	}
	function removePreImage1(){
	   $("#image1").addClass("image1")
	   $("#check1").attr("value","0")
	}
	function removePreImage2(){
	   $("#image2").addClass("image2")
	   $("#check2").attr("value","0")
	}
	function removePreImage3(){
	   $("#image3").addClass("image3")
	   $("#check3").attr("value","0")
	}
</script>
</body>
</html>





