<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#topDiv a:link{ color: black; text-decoration: none;}
#topDiv a:visited{ color: black; text-decoration: none;}
#topDiv a:hover{ color: blue; text-decoration: none;}
#topDiv a:active{ color: black; text-decoration: none;}
</style>

<h3><jsp:include page="../main/logo.jsp"/>MVC를 이용한 미니 프로젝트</h3>

<div id="topDiv">
<c:if test="${sessionScope.memId ne null }">
	<a href="../board/boardWriteForm.do">글쓰기</a>&emsp;
</c:if>
	<a href="../board/boardList.do?pg=1">목록</a>&emsp;
<c:if test="${sessionScope.memId ne null && memId eq '111' }">
	<a href="../imageboard/imageboardWriteForm.do">이미지등록</a>&emsp;
</c:if>
	<a href="">이미지목록</a><br>
</div>