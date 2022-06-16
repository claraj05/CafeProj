<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="write-container">
				<form action="/writeReview" method="POST">
					<div>
						<div class="text-editor-area">
							<textarea name="" id="" cols="30" rows="10"></textarea>
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