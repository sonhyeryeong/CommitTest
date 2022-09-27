<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
body {
	color: #555;
	background: #eeeeee;
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

h1 {
	padding: 50px 0;
	font-weight: 400;
	text-align: center;
}

p {
	margin: 0 0 20px;
	line-height: 1.5;
}

.main {
	min-width: 320px;
	max-width: 800px;
	padding: 50px;
	margin: 0 auto;
	background: #ffffff;
}

section {
	display: none;
	padding: 20px 0 0;
	border-top: 1px solid #ddd;
}

/*라디오버튼 숨김*/
input {
	display: none;
}

label {
	display: inline-block;
	/* width: 50%; */
	margin: 0 0 -1px;
	padding: 15px 25px;
	font-weight: 600;
	text-align: center;
	color: #bbb;
	border: 1px solid transparent;
}


label:hover {
	color: #2e9cdf;
	cursor: pointer;
}

/*input 클릭시, label 스타일*/
input:checked+label {
	color: #555;
	border: 1px solid #ddd;
	border-top: 2px solid #2e9cdf;
	border-bottom: 1px solid #ffffff;
}

#tab1:checked ~ #content1,
#tab1:checked ~ #content2,
#tab1:checked ~ #content3,
#tab1:checked ~ #content4,
#tab2:checked ~ #content5,
#tab2:checked ~ #content6,
#tab2:checked ~ #content7,
#tab2:checked ~ #content8 {
	display: block;
}

.alignCenter {
   display : block;
   margin: 12px auto;
}
/* .tabmenu {
	display: flex;
} */
</style>
</head>
<body>
<h1>xxx님의 마이페이지</h1>
	<div class="main">
		<!-- <div class="tabmenu"> -->
			<input id="tab1" type="radio" name="tabs" checked><!--디폴트 메뉴-->
			<label for="tab1">★☆★☆★나로인해 만들어진 퀴즈☆★☆★☆</label> 
			<input id="tab2" type="radio" name="tabs">
			<label for="tab2">★☆★☆★내가 풀었던 상대방의 퀴즈☆★☆★☆</label>
		<!-- </div> -->
		
		<section id="content1">
			<label class="alignCenter">x번 퀴즈 => MBTI 검사<a href="checkResult.jsp">결과확인하기</a></label>
		</section>

		<section id="content2">
			<label class="alignCenter">x번 퀴즈 => MBTI 검사<a href="myMbti">결과확인하기</a></label>
		</section>
		
		<section id="content3">
			<label class="alignCenter">x번 퀴즈 => MBTI 검사<a href="myMbti">결과확인하기</a></label>
		</section>

		<section id="content4">
			<label class="alignCenter">x번 퀴즈 => MBTI 검사<a href="myMbti">결과확인하기</a></label>
		</section>
		
		<section id="content5">
			<label class="alignCenter">x번 퀴즈 => xxx님의 MBTI 검사<a href="yourMbti">결과확인하기</a></label>
		</section>

		<section id="content6">
			<label class="alignCenter">x번 퀴즈 => xxx님의MBTI 검사<a href="yourmyMbti">결과확인하기</a></label>
		</section>
		
		<section id="content7">
			<label class="alignCenter">x번 퀴즈 => xxx님의 MBTI 검사<a href="yourmyMbti">결과확인하기</a></label>
		</section>

		<section id="content8">
			<label class="alignCenter">x번 퀴즈 => xxx님의 MBTI 검사<a href="yourmyMbti">결과확인하기</a></label>
		</section>

	</div>
</body>
</html>