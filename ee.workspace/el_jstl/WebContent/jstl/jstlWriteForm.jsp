<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlWriteForm</title>
</head>
<body>
	<form name="writeForm" method="post" action="jstlWrite.jsp">
		<h2>회원가입</h2>
		<table border="1" >
			<tr>
				<td align="center">이름</td>
				<td>
					<input type="text" name="name" placeholder="이름 입력">
				</td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td>
					<input type="text" name="id" id="id" placeholder="아이디 입력">
				</td>
			</tr>

			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>

			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="회원가입">&emsp; 
					<input type="reset" value="다시작성">&emsp;
					<input type="button" value="목록" onclick="location.href='jstlList.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>