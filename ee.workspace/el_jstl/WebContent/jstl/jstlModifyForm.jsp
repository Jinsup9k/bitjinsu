<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<sql:query dataSource="jdbc/oracle" var="rs">
	select * from usertable where id = '${param.id }'
</sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<body>
	<form name="writeForm" method="post" action="jstlModify.jsp">
		<h2>회원정보수정</h2>
		<table border="1" >
			<tr>
				<td align="center">이름</td>
				<td>
					<input type="text" name="name" value="${rs.rows[0].name }">
				</td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td>
					<input type="text" name="id" id="id" value="${param.id }" readonly>
				</td>
			</tr>

			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>

			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="회원정보수정">&emsp; 
					<input type="reset" value="다시작성">&emsp;
				</td>
			</tr>
		</table>
	</form>
</body>
</html>