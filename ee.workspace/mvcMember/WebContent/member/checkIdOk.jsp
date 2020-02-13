<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${param.id }는(은) 사용 가능<br><br>
	<input type="button" value="사용하기" onclick="checkIdClose('${param.id }')">
</body>
<script src="../js/member.js"></script>
</html>