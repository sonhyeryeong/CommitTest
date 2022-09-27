<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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


<!--마지막 결승임.   -->
<form action="result.do" method="POST" onsubmit="return jbSubmit();">
	<!-- 짝수일 때 -->
	<c:if test="${oddeven}">
			<!-- 라디오 버튼으로 두 개씩 묶어야 함 !! 이름을 name이라는 리스트로 넘겨 받았다. -->
			<input type="radio" name="${name[0]}" class="click-btn" value="${question[0].question_id}" required="required"/>${question[0].question_text}
			<input type="radio" name="${name[0]}" class="click-btn" value="${question[1].question_id}" required="required"/>${question[1].question_text}
			<!-- 질문 두 개씩 나눈다.  -->
				<hr/>
	</c:if>
	<input type ="submit" value="제출"/>
</form>
</body>
</html>