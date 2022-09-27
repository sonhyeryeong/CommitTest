<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<style type="text/css">
* {
   margin: 0;
   padding: 0;
}
h1 {
   text-align: center;
   margin: 200px 0 20px 0;
}
.loginbox {
   border: 1px solid black;
   width: 600px;
   height: 240px;
   text-align: center;
   margin: 0px auto;
}
.alignCenter {
   display : block;
   margin: 20px auto;
}
button {
   padding: 0 100px;
}
</style>
</head>
<body>
   <h1>Login</h1>
   <div class="loginbox">
      <form action="login.do"  method="post">
         <label class="alignCenter">아이디    <input type="text" name="id" value="${param.id}"/></label> 
         <c:if test="${errors.id}">ID를 입력하세요 </c:if>
         <label class="alignCenter">비밀번호   <input type="password" name="password" /></label>
         <c:if test="${errors.password}">암호를 입력하세요 </c:if>
         <input type = "button"  value="회원가입" id = "btnchk" class="alignCenter" onclick="location.href='join.do'">  </button>
      <input type="submit" class="alignCenter" value = "로그인"/>
      </form>
   </div>
</body>

</html>