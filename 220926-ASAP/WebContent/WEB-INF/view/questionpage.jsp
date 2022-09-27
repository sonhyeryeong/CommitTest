<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문지</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
h1 {
	text-align: center;
	padding: 40px auto;
}
.question {
	text-align: center;
}
.choice {
	display: flex;
}
.leftchoice {
	/* magin: 0 auto; */
	/* float: left; */
	text-align: center;
}
.rightchoice {
	/* magin: 0 auto; */
	/* float: right; */
	text-align: center;
}
</style>
</head>
<body>
	<h1>주제주제</h1>
		<c:out value="아오"></c:out>
	<c:forEach var="question" items="${QuestionPage.question_context}">
		<p>${question}</p>
		<c:out value="${QuestionPage.question_context}">나와!</c:out>
	</c:forEach>
		<p class="question">이렇게 저렇게 질문하기 궁금궁금</p>
	<div class="choice">
		<div class="leftchoice">
			<p> 이렇게 저렇게 선택지1 </p>
		</div>
		<div class="rigthchoice">
			<p> 이렇게 저렇게 선택지2 </p>
		</div>
	</div>
</body>
</html>