<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="get" action="result.jsp">
<table border="1" cellspacing="0" cellpadding= "10">
		<tr>
			<td>X</td>
			<td><input type="text" name="x" size="10"></td>
		</tr>
		<tr>
			<td>Y</td>
			<td><input type="text" name="y" size="10"></td>
		</tr>
		<tr>
			<td colspan="2" align ="center">
			<input type="submit" value="계산">&emsp;
			<input type="reset" value= "취소"></td>
		</tr>
</table>
</form>

</body>
</html>