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
	border-bottom: solid;
}
.middle{
	height: 700px;
}

.left{
	width: 240px;
	border-right: solid;
	border-color: blue;
	vertical-align: top;
	text-align: center;
}
.body{
	vertical-align: top;
}
.bottom{
	height:5%;
}
</style>
</head>
<body>
<table class="tb">
	<tr>
		<td class="top" colspan="2"><jsp:include page="../template/top.jsp"></jsp:include></td>
	</tr>

	<tr class="middle">
		<td class="left">
			<jsp:include page="../template/left.jsp"/>
		</td>
		<td class="body"><jsp:include page="${display }"></jsp:include></td>
	</tr>

	<tr>
		<td class="bottom" colspan="2"><jsp:include page="../template/bottom.jsp"></jsp:include></td>
	</tr>
</table>
</body>
</html>