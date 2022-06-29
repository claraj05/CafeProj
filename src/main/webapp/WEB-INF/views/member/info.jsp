<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/info.jsp</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/member/info.css?after">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function checkModify(){
   var check=confirm("정말 수정하시겠습니까?")
   if(check){
      document.info.submit()
   }
}
</script>
</head>
<body>         
   <section class="info">
      <h1>회원 정보 수정</h1>
   <input type="hidden" name="id" value="${loginUser }">
   <form action="${contextPath }/member/modifyForm" name="info" method="post">
         <div class="int-area">
            <input type="text" name="name" value="${info.name }" width="20">
            <label for="name">이름</label>
         </div>
         
            
         <div class="int-area">
            <input type="text" name="id" value="${info.id }" width="20" readonly >
            <label for="id">아이디</label>   
         </div>   
      
         <div class="int-area">
            <input type="password" name="pw" value="${info.pw }" width="20">
            <label for="password">비밀번호</label>
         </div>
            
         <div class="int-area">
            <input type="text" name="phone" value="${info.phone }" width="20">
            <label for="phone">전화번호</label>
         </div>
      
      
      
         <div class="int-area">
            <input type="text" name="gender" value="${info.gender }" width="20">
            <label for="gender">성별 </label>
         </div>
      
         
   
         <div class="int-area">
            <input type="text" name="addr" value="${info.addr }" width="20">
            <label for="addr">주소</label>
         </div>
         
         <div class="int-area">
                  <input type="text" name="birth" value="${info.birth }" width="20">
            <label for="birth">생일</label>
           </div>
   
      
      
         
         <div class="int-area">
            <input type="text" name="email" value="${info.email }" width="20">
            <input type="text" name="domain" value="${info.domain }">
            <label for="email">이메일</label>
         </div>
         
         <div class="btn-area">
         <input type="button" value="정보수정" onclick="checkModify()">
         <a href="${contextPath }/">메인화면</a>
         </div>
   </form>
   </section>
</body>
</html>