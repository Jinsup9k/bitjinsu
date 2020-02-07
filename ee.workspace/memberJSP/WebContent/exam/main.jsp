<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** include directive **</h3>
<%@ include file="today.jsp" %><br><br>

<h3>** include JSP tag **</h3>
<jsp:include page="image.jsp"/><br><br>

<% String name="사이다";%>
main.jsp name=<%=name %><br><br>

<h3>** 3초 뒤에 페이지 이동 ** </h3>
<% response.setHeader("Refresh","3;url=input.jsp"); %>



</body>
</html>