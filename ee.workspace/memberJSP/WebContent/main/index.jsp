
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<jsp:include page="../main/logo.jsp"/>
<div align = "center">
<h3>*** main ***</h3>
<%if(session.getAttribute("memId")== null){ %>
<a href="../member/writeForm.jsp">회원가입</a><br>
<a href="../member/loginForm.jsp">로그인</a><br>
<%}else{ %>
<a href="../member/logout.jsp">로그아웃</a><br>
<a href="../member/modifyForm.jsp">회원정보수정</a><br>
<a href="../board/boardWriteForm.jsp">글쓰기</a><br>
<%} %>
<a href="../board/boardList.jsp?pg=1">목록</a><br>
</div>
</body>
</html>