<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style>
	.td1{
		text-align: center;
		width: 80px;
		height: 30px;
		}
	.tb{
		border-spacing: 0px;
		padding: 0px;		
		}
</style>
</head>
<body>
<h3>로그인</h3>
<form name="loginForm" method="post" action="../member/login.do">
<table border="1" class="tb">
	<tr>
		<td class="td1">아이디</td>
		<td style="width:180px">
			<input type="text" name="id">
		</td>
	</tr>
	<tr>
		<td class="td1">비밀번호</td>
		<td>
			<input type="password" name="pwd">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="로그인" onclick="checkLoginForm()">
			<input type="button" value="회원가입" onclick="javascript:location.href='../member/writeForm.do'">                                 
		</td>
	</tr>
</table>
</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>






