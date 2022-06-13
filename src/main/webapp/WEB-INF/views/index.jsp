<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<style type="text/css">
*{
margin : 0;
padding : 0;
}
.board_text  {
	
	text-align:center;
	margin: 0 auto;
	
}
.lefttop{
	float : left;
	border : 1px solid black;
	width : 50%;
	height : 400px;
}
.righttop{
	float : right;
	border : 1px solid red;
	width : 49%;
	height : 400px;
}

.bottom{
	clear : both;
	border : 1px solid blue;
	width : 100%;
	height : 400px;
}

</style>
</head>
<body>
	<c:import url="default/header.jsp"/>
	<div class="board_text">
		<div class="lefttop">
			<div class="recommend">
				 추천 카페 구역
			</div>
		</div>
		<div class="righttop">
			<div class="event">
				이벤트 구역
			</div>
		</div>
		<div class="bottom">
			<div class="boardList">
				게시판 리스트 구역
			</div>
		</div>
	</div>
	<c:import url="default/footer.jsp"/>

</body>
</html>