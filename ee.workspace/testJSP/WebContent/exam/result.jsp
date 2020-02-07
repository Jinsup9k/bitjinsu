<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int x= Integer.parseInt(request.getParameter("x"));
int y= Integer.parseInt(request.getParameter("y"));%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=x %> + <%=y %> = <%=x+y %><br><br>
<%=x %> - <%=y %> = <%=x-y %><br><br>
<%=x %> * <%=y %> = <%=x*y %><br><br>
<%=x %> / <%=y %> = <%=1.0*x/y %><br><br>

</body>
</html>