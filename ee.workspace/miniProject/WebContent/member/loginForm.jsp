<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.td1{
		text-align: center;
		width: 80px;
		height: 30px;
		}
	.tb{
		height: 100px;
		border-spacing: 0px;
		padding: 0px;		
		}
	.loginFail{
		color: red;
		font-size: 9pt;
		font-weight: bold;
	}
	
</style>

<form name="loginForm" method="post" action="../member/login.do">
<table border="1" class="tb">
	<tr>
		<td class="td1">아이디</td>
		<td style="width:180px">
			<input type="text" name="id" id="loginId">
			<div id="loginIdDiv"></div>
		</td>
	</tr>
	<tr>
		<td class="td1">비밀번호</td>
		<td>
			<input type="password" name="pwd" id="loginPwd">
			<div id="loginPwdDiv"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<!-- <input type="button" value="로그인" onclick="checkLoginForm()"> -->
			<input id="loginFormBtn" type="button" value="로그인">
			<input type="button" value="회원가입" onclick="javascript:location.href='../member/writeForm.do'">
		<c:if test="${loginFail eq true }">
			<div class="loginFail">로그인에 실패 하셨습니다.</div>                                 
		</c:if>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>






