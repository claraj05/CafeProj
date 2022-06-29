<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">파일 업로드 하기</h1>
	
	<h3>multi file 업로드</h3>
	<form action="multi-file" method="post" enctype="multipart/form-data">
	
		파일 : <input type="file" name="multiFile" multiple> <br>
		파일 설명 : <input type="text" name="fileContent"><br>
		<input type="submit" value="제출">

	</form>

</body>
</html>