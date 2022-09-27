<%  
response.setHeader("Cache-Control","no-store");  
response.setHeader("Pragma","no-cache");  
response.setDateHeader("Expires",0);  
if (request.getProtocol().equals("HTTP/1.1"))
        response.setHeader("Cache-Control", "no-cache");
%>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>second</title>
<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
  <script>
  /* 버튼에 클릭 이벤트를 준다. 버튼을 클릭할 때, 버튼의 id가 콘솔에 출력된다.  */
    $(document).ready(function(){
        $(".click-btn").on('click', function(e){
            console.log(e.target.value)
        });
    });
   
</script>
</head>
<body>
<form action="third.do" method="POST" onsubmit="return jbSubmit();">
	<!-- 짝수일 때 -->
	<c:if test="${oddeven}">
		<c:forEach var ="i" begin="0" end="${question.size()-1}">
			<!-- 라디오 버튼으로 두 개씩 묶어야 함 !! 이름을 name이라는 리스트로 넘겨 받았다. -->
			<input type="radio" name="${name[i]}" class="click-btn" value="${question[i].question_id}" required="required"/>${question[i].question_text}
			<!-- 질문 두 개씩 나눈다.  -->
			<c:if test="${(i+1)%2==0}">
				<hr/>
			</c:if>
		</c:forEach>
	</c:if>
	<!-- 홀수일 때 -->
	<c:if test="${!oddeven}">
		<c:forEach var ="i" begin="0" end="${question.size()-1}">
			<!-- 라디오 버튼으로 두 개씩 묶어야 함 !! 이름을 name이라는 리스트로 넘겨 받았다. -->
			<input type="radio" name="${name[i]}" class="click-btn" value="${question[i].question_id}" required="required"/>${question[i].question_text}
			<!-- 질문 두 개씩 나눈다.  -->
			<c:if test="${(i+1)%2==0}">
				<hr/>
			</c:if>
		</c:forEach>
		<p>부전승: "${walkOver.question_text}"</p>
		<input type="hidden" value="${walkOver.question_id }" name="walkOver"/>
	</c:if>
	<input type ="submit" value="제출"/>
</form>
</body>
</html>