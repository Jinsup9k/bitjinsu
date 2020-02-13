<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tb{
	width:100%;
	height:700px;
}
.top{
	height:20%;
	text-align: center;
}
.left{
	width: 20%;
	height:70%;
}
.body{
	width:80%;
	height: 70%;
}
.bottom{
	height:10%;
}
</style>
</head>
<body>
<table class="tb" border="1">
	<tr>
		<td class="top" colspan="2"><jsp:include page="../template/top.jsp"></jsp:include></td>
	</tr>

	<tr>
		<td class="left"><jsp:include page="../template/left.jsp"></jsp:include></td>
		<td class="body"><jsp:include page="../template/body.jsp"></jsp:include></td>
	</tr>

	<tr>
		<td class="bottom" colspan="2"><jsp:include page="../template/bottom.jsp"></jsp:include></td>
	</tr>
</table>
</body>
</html>