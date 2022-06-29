<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
<link rel ="stylesheet" type ="text/css" href = "../resources/css/member/joinForm.css?after5">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
   function daumPost() {
      new daum.Postcode({
         oncomplete: function(data) {
            // 도로명일 경우 R, 지번일 경우 J의 값을 가지고 있습니다
            var addr=""
            if(data.userSelectedType=='R') {
               addr = data.roadAddress    
            } else {
               addr = data.jibunAddress
            }
            $("#addr1").val(data.zonecode)
            $("#addr2").val(addr)
            $("#addr3").focus()
         }
      }).open();
   }
 
/* function register() {

   
}  */

function joinform_check()  {
   var name = document.getElementById("name");
   var code = document.getElementById("code");
   var id = document.getElementById("id");
   var pw = document.getElementById("pw");
   var addr = document.getElementById("addr");
   var repw  = document.getElementById("repw");
   var phone = document.getElementById("phone");
   var gender  = document.getElementById("gender");
    var birth = document.getElementById("birth");
   var email  = document.getElementById("email");
   var check  = document.getElementById("check");
   
   
   if(name.value == "") {
      alert("이름를 입력하세요!");
       document.writeForm.name.focus();       
   }  else if(id.value == "")  {
      alert("아이디를 입력하세요.");
      document.writeForm.id.focus(); 
   } else if(pw.value == "") {
      alert("비밀번호를 입력하세요..");
       document.writeForm.pw.focus();
   } else if(phone.value == "") {
      alert("전화번호를 입력해주세요.")
      document.writeForm.tel.focus();
   } else if(addr1.value == "") {
      alert("주소를 입력해주세요")
      document.writeForm.addr.focus();
   } else if(birth.value == "") {
      alert("생년월일을 입력해주세요")
      document.writeForm.birth.focus();
   } else if(email.value == "") {
      alert("이메일을 입력하세요.");
      document.writeForm.email.focus();
   } else if(check.value=="f"){
      alert("중복확인을 해주세요")
      document.writeForm.id.focus();
   } else if(pwcheck.value=="f") {
      alert("비밀번호확인을 해주세요")
      document.writeForm.repw.focus();
   } else { 
      document.writeForm.submit();
      alert("회원가입이 완료되었습니다. 홈페이지로 이동합니다.");
   }

}

function checkpw() {
   
   if(pw.value == "") {
      alert("비밀번호를 먼저 입력해주세요.")
      document.writeForm.pw.focus();
   } 
   else if(pw.value != repw.value) {
      alert("비밀번호가 일치 하지 않습니다");
      return false;
   } else {
      alert("비밀번호가 일치합니다");
      document.writeForm.pwcheck.value ="t";
      return true;
   }   
}

function checkId() {
   var writeForm = document.writeForm;
   var id = writeForm.id.value;
   if(id.length==0 || id=="") {
      alert("아이디를 입력해주세요.")
      writeForm.id.focus();
   } else {
      window.open("${contextPath}/member/checkId?id="+id,"","width=500, height=300");
   }
}

</script>
</head>
<body>
   <section class="writeForm">
      <form name="writeForm" action="joinForm" method="post">
      <h1>회원가입</h1>
       <input type="hidden" name="code" value="1">  
         <div class="int-area">
            <input type="text" name="name" id="name" width="20" autocomplete="off" required>
            <label for="name">USER_NAME</label>
         </div>
         <div class="int-area">
            <input type="text" name="id" id="id" width="20"  autocomplete="off" required>
            <label for="id">USER_ID</label>            
            <input type="hidden" id="check" name="check" value="f">
         </div>
            <input type="button" name="idDuplication" id="Duplication" onclick="checkId()" value="중복 확인">
         <div class="int-area">
            <input type="password" name="pw" id="pw" width="20" autocomplete="off" required>
            <label for="pw">password</label>
         </div>
         <div class="int-area">
            <input type="password" name="repw" id="repw" width="20" autocomplete="off" required>
            <label for="repw">password 확인</label>
            <input type="hidden" id="pwcheck" name="pwcheck" value="f">
         </div>
            <input type="button" id="repwbutton" onclick="checkpw()" value="비밀번호 확인">
            
         <div class="int-area">
            <input type="text" name="phone" id="phone" width="20" autocomplete="off" required>
            <label for="phone">tel</label>
         </div>
         
          <div class="gender"> 
             <label for="gender">성별</label>
            <input type="radio"  name="gender" value="man" checked >남자
            <input type="radio" name="gender" value="woman">여자
             </div> 
         
            <div class="int-area">
            <input type="text" id="addr1" name="addr1" placeholder="우편번호"    >
            <input type="text" id="addr2" name="addr2" placeholder="주소" readonly>
            <input type="text" id="addr3" name="addr3" placeholder="상세주소">
            <label for="addr">주소</label>
         </div>
            <input type="button"  id="daumPost2" onclick="daumPost()" value="우편번호 찾기">

         <div class="int-area">
               <input type="date"  name="birth" id="birth">
               <label for="birthdate">생년월일</label>         
         </div>
            
         <div class="int-area">
               <input type="text" name="email" id="email" width="20" maxlength="17" autocomplete="off" required>
               <label for="email">email</label>
               <select id = "domain" name = "domain" size = "1">
                  <option value = "none">----선택----</option>
                  <option value = "@naver.com">@naver.com</option>
                  <option value = "@daum.net">@daum.net</option>
                  <option value = "@gmail.com">@gmail.com</option>
               </select>
         </div>

         <!-- <input type="submit" value="회원가입"> -->
         <div class="btn-area">
         <input type="button"  onclick="joinform_check()" value="회원가입"> &nbsp; &nbsp; &nbsp;
         <a href="${contextPath }/member/login">로그인</a> &nbsp; &nbsp; &nbsp;
         <a href="${contextPath }/">메인화면</a> &nbsp; &nbsp; &nbsp;
         </div>
   </form>
   </section>
</body>
</html>