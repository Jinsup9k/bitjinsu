<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberDAO" class="member.dao.MemberDAO"/>
<jsp:useBean id="memberDTO" class="member.bean.MemberDTO"/>
<%
// DATA
String id= (String)session.getAttribute("memId");
// DB
memberDTO = memberDAO.findMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<body>
	<form name="modifyForm" method="post" action="modify.jsp">
		<jsp:include page="../main/logo.jsp"/>
		<h2>회원정보수정</h2>
		<table border="1" cellspacing="0" cellpadding="5">
			<tr width="90">
				<td align="center">이름</td>
				<td><input type="text" name="name" value="<%=memberDTO.getName()%>"></td>
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td><input type="text" name="id" value="<%=memberDTO.getId()%>" readonly>
					<input type="button" value="중복체크" onclick="checkId()" disabled> 
					<input type="hidden" value=""></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>

			<tr>
				<td align="center">재확인</td>
				<td><input type="password" id="repwd"></td>
			</tr>
			<tr>
				<td align="center">성별</td>
				<td><input type="radio" name="gender" value="0">남
					<input type="radio" name="gender" value="1">여</td>
			</tr>
			<tr>
				<td align="center">이메일</td>
				<td><input type="text" name="email1" size="15" value="<%=memberDTO.getEmail1()%>"> @ 
					<input type="text" name="email2" list="email2" placeholder="직접입력">
					<datalist id="email2">
						<option value="gmail.com">
						<option value="naver.com">
						<option value="hanmail.com">
					</datalist></td>
			</tr>
			<tr>
				<td align="center">핸드폰</td>
				<td><select name="tel1" style="width: 60px;">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
				</select> - <input type="text" name="tel2" size="5" value="<%=memberDTO.getTel2()%>">
						  - <input type="text" name="tel3" size="5" value="<%=memberDTO.getTel3()%>"></td>
			</tr>
			<tr>
				<td align="center">주소</td>
				<td><input type="text" name="zipcode" id="zipcode" size="6" readonly value="<%=memberDTO.getZipcode()%>">
					<input type="button" value="우편번호검색" onclick="checkPost()"><br> 
					<input type="text" name="addr1" id="addr1" placeholder="주소" readonly value="<%=memberDTO.getAddr1()%>"><br>
					<input type="text" name="addr2" id="addr2" placeholder="상세 주소" value="<%=memberDTO.getAddr2()%>"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
				<input type="button" value="회원정보수정" onclick="javascript:checkModifyForm()">&emsp; 
				<input type="reset" value="다시작성"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
<script type="text/javascript">
window.onload=function(){
	document.modifyForm.gender[<%=memberDTO.getGender()%>].checked = true;
	document.modifyForm.email2.value = "<%=memberDTO.getEmail2()%>";
	document.modifyForm.tel1.value = "<%=memberDTO.getTel1()%>";
}
</script>
</html>