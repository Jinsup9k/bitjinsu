<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginOk</title>
</head>
<body>
<jsp:include page="../main/logo.jsp"/>
${sessionScope.memName }님 로그인<br><br>
<input type="button" value="로그아웃" onclick="location.href='/mvcMember/member/logout.do'">
<input type="button" value="회원정보수정" onclick="location.href='modifyForm.jsp'">
</body>
</html>




































