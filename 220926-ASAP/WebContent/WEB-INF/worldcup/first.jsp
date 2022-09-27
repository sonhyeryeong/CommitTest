<%  
response.setHeader("Cache-Control","no-store");  
response.setHeader("Pragma","no-cache");  
response.setDateHeader("Expires",0);  
if (request.getProtocol().equals("HTTP/1.1"))
        response.setHeader("Cache-Control", "no-cache");
%>  

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>first</title>
<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
  <script>
  /* ��ư�� Ŭ�� �̺�Ʈ�� �ش�. ��ư�� Ŭ���� ��, ��ư�� id�� �ֿܼ� ��µȴ�.  */
    $(document).ready(function(){
        $(".click-btn").on('click', function(e){
            console.log(e.target.value)
        });
    });
   
</script>
</head>
<body>

<!-- Ȧ���� ��  ¦���� �� ���� Ȯ���ϰ� �ؾ���.  -->
<form action="tournament.do" method="POST" onsubmit="return jbSubmit();">
	<!-- ¦���� �� -->
	<c:if test="${oddeven}">
		<c:forEach var ="i" begin="0" end="${question.size()-1}">
			<!-- ���� ��ư���� �� ���� ����� �� !! �̸��� name�̶�� ����Ʈ�� �Ѱ� �޾Ҵ�. -->
			<input type="radio" name="${name[i]}" class="click-btn" value="${question[i].question_id}" required="required"/>${question[i].question_text}
			<!-- ���� �� ���� ������.  -->
			<c:if test="${(i+1)%2==0}">
				<hr/>
			</c:if>
		</c:forEach>
	</c:if>
	<!-- Ȧ���� �� -->
	<c:if test="${!oddeven}">
		<c:forEach var ="i" begin="0" end="${question.size()-1}">
			<!-- ���� ��ư���� �� ���� ����� �� !! �̸��� name�̶�� ����Ʈ�� �Ѱ� �޾Ҵ�. -->
			<input type="radio" name="${name[i]}" class="click-btn" value="${question[i].question_id}" required="required"/>${question[i].question_text}
			<!-- ���� �� ���� ������.  -->
			<c:if test="${(i+1)%2==0}">
				<hr/>
			</c:if>
		</c:forEach>
		<p>������: "${walkOver.question_text}"</p>
		<input type="hidden" value="${walkOver.question_id }" name="walkOver"/>
	</c:if>
	<input type ="submit" value="����"/>
</form>

</body>
</html>