<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlInput</title>
</head>
<body>
<form method="post" action="jstlResult.jsp">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<td align="center" width="70">이름</td>
				<td width="350"><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td align="center" width="70">나이</td>
				<td width="350"><input type="text" name="age"></td>
			</tr>
			
			<tr>
				<td align="center">색깔</td>
				<td><select name="color">
						<option value="red">빨강</option>
						<option value="orange">주황</option>
						<option value="yellow">노랑</option>
						<option value="green">초록</option>
						<option value="blue">파랑</option>
				</select></td>
			</tr>
			
			<tr>
				<td align="center" height="40">취미</td>
				<td align="center"><input type="checkbox" name="hobby"
					value="독서"> 독서 <input type="checkbox" name="hobby"
					value="영화"> 영화 <input type="checkbox" name="hobby"
					value="음악"> 음악 <input type="checkbox" name="hobby"
					value="게임"> 게임 <input type="checkbox" name="hobby"
					value="쇼핑"> 쇼핑</td>
			</tr>
	
			<tr>
				<td align="center" colspan="2"><input type="submit"
					value="SEND"> <input type="reset" value="CANCLE"></td>
			</tr>

		</table>
	</form>
</body>
</html>