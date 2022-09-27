<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
h1 {
	text-align: center;
	margin: 200px 0 20px 0;
}
.signupbox {
	border: 1px solid black;
	width: 600px;
	height: 300px;
	text-align: center;
	margin: 0px auto;
	padding : 70px 0 0 0;
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
	<h1>회원가입</h1>
	<div class="signupbox">
		<form action="${request.getContextPath()}mainpage.jsp">
			<label class="alignCenter">아이디    <input type="text" name="id" /></label> 
			<label class="alignCenter">비밀번호   <input type="text" name="password" /></label>
			<label class="alignCenter">비밀번호 확인   <input type="text" name="confirmpassword" /></label>
			<label class="alignCenter">닉네임   <input type="text" name="nickname" /></label>
		<!-- 	<input type="submit" class="alignCenter" value = "회원가입" onclick="alert()"/> -->
			<button type="submit" id="btnchk" class="alignCenter" value = "회원가입" >회원가입</button>
		</form>
	</div>
</body>
<script>
/* function alert(){
     alert("회원가입 성공! 로그인 창으로 이동합니다. ");
     location.href  ="${request.getContextPath()}mainpage.jsp";
} */
let elem = document.getElementById("btnchk");
elem.addEventListener("click", function (e) {
	e.preventDefault(); // 기본으로 설정된 eventlistener는 동작 x(ex.자동으로 submit 발생)
	e.stopPropagation(); // event가 전달
	
	/* 클릭을 했을 때 , 회원가입이 성공했는지 아닌지를 받아야한다.*/
	/* 성공 - 로그인창으로 이동
	실패시 - 다시 해야함  */
	
	let what= document.getElementsByName("id");
	alert("회원가입 성공! 로그인 창으로 이동합니다.");
	location.href="${request.getContextPath()}loginForm.jsp";
	
		
});

</script>

</html>