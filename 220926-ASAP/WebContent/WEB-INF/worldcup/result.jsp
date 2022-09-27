<%  
response.setHeader("Cache-Control","no-store");  
response.setHeader("Pragma","no-cache");  
response.setDateHeader("Expires",0);  
if (request.getProtocol().equals("HTTP/1.1"))
        response.setHeader("Cache-Control", "no-cache");
%>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<p>1위: "${one.question_text }</p>
	<p>2위: "${two.question_text }"</p>
	<p>3-4위: "${threeTofour[0].question_text }","${threeTofour[1].question_text }"</p>
	<p>5-8위: "${fourtoEight[0].question_text }","${fourtoEight[1].question_text }","${fourtoEight[2].question_text }","${fourtoEight[3].question_text }" </p>
	




</body>
</html>