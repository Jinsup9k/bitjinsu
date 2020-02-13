<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<sql:update var="su" dataSource="jdbc/oracle">
	delete from usertable where id='${param.id }'
</sql:update>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
<c:if test="${su==1 }">삭제 완료</c:if>
<c:if test="${su==0 }">삭제 실패</c:if>
</body>
</html>