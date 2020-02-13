<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:query var="rs" dataSource="jdbc/oracle">
	select * from usertable
</sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlList</title>
</head>
<body>
	<table border="1">
		<tr>
		<c:forEach var="columnName" items="${rs.columnNames }">
			<td width="100" align="center">${columnName }</td>	
		</c:forEach>
			<td width="150" align="center">비고</td>
		</tr>
<!-- 필드 -->		
		<tr>
	<c:forEach var="row" items="${rs.rowsByIndex }">
		<tr>	
		<c:forEach var="col" items="${row }">
			<td align="center" >${col }</td>	
		</c:forEach>
			<td align="center">
				<input type="submit" value="수정" onclick="location.href='jstlModifyForm.jsp?id=${row[1] }'">
				<input type="button" value="삭제" onclick="location.href='jstlDelete.jsp?id=${row[1] }'">
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>