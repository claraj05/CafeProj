<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/findIdForm</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/member/findPwForm.css?after3">
<script>
function findPw(){
   if("${pw}"=="1"){
      alert("비밀번호가 존재하지 않습니다")
   }
}
function check(){
   if(document.findPwForm.id.value==""){
      alert("아이디를 입력해주세요")
      findPwForm.id.focus()
   }else if(findPwForm.name.value==""){
      alert("이름을 입력해주세요")
      findPwForm.name.focus()
   }else if(findPwForm.birth.value==""){
      alert("생년월일을 입력해주세요")
      findPwForm.birth.focus()
   }
   else{
      findPwForm.submit()
   }
}
</script>
</head>
<body onload="findPw()">
   <section class="findPwForm2">
   <form action="findPw" method="post" name="findPwForm">
   <h1>비밀번호 찾기</h1>
      
      <div class="int-area">
            <input type="text" name="id" autocomplete="off" required>
            <label for="id">id</label>
      </div>
      
      <div class="int-area">
         <input type="text" name="name" autocomplete="off" required>
         <label for="name">name</label>
      </div>
      
      <div class="int-area">
         <input type="date" name="birth"> 
         <label for="date">date</label>
      </div>
      
      <div class="caption">
      <input type="button" value="비밀번호 검색" onclick="check()">
   
      <input type="button" value="로그인" onclick="location.href='${contextPath}/member/login'">
      
      <input type="button" value="아이디 찾기" onclick="location.href='${contextPath}/member/findIdForm'">
      
      <a href="${contextPath }/">메인화면</a>
      </div>
   </form>
   </section>
</body>
</html>