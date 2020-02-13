<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlResult</title>
</head>
<body>
	<fmt:requestEncoding value="UTF-8" />
	이 름 : ${param.name }
	<br>
	<br> 
	나 이 : ${param.age }살
	<c:if test="${param.age>=19 }">*성인</c:if>
	<c:if test="${param.age<19 }">*청소년</c:if>
	<br>
	<br> 
	색 깔 : 
	<c:choose>
		<c:when test="${param.color eq 'red' }">빨강</c:when>
		<c:when test="${param.color eq 'orange' }">주황</c:when>
		<c:when test="${param.color eq 'yellow' }">노랑</c:when>
		<c:when test="${param.color eq 'green' }">초록</c:when>
		<c:when test="${param.color eq 'blue' }">파랑</c:when>
		<c:otherwise>왜 선택안해?</c:otherwise>
	</c:choose>
	<br>
	<br> 
	취 미 :
<%-- 	${paramValues.['hobby'][0] } --%>
	<c:forEach var="data" items="${paramValues.hobby }" varStatus="i">
		${data }&emsp;
	</c:forEach> 
	<br>
	<br>
</body>
</html>