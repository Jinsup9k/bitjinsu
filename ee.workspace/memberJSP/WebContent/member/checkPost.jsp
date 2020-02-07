<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.PostDTO"%>
<%@page import="java.util.List"%>
<%
//DATA
PostDTO postDTO = new PostDTO();
request.setCharacterEncoding("UTF-8");

if(request.getParameter("sido")!= null &&
	request.getParameter("sido") !=""){
	postDTO.setSido(request.getParameter("sido"));
}
postDTO.setSigungu(request.getParameter("sigungu"));
if(request.getParameter("roadname") != null&&
	request.getParameter("roadname") !=""){
	postDTO.setRoadname(request.getParameter("roadname"));
}
//DB
MemberDAO memberDAO = MemberDAO.getInstance();
List<PostDTO> list = memberDAO.post(postDTO);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/member.css">
</head>
<body>
	<form method="post" action="checkPost.jsp">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<td align="center">시,도</td>
				<td size="15"><select name="sido">
						<option value="서울">서울</option>
						<option value="인천">인천</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="울산">울산</option>
						<option value="세종">세종</option>
						<option value="광주">광주</option>
						<option value="경기">경기</option>
						<option value="강원">강원</option>
						<option value="전남">전남</option>
						<option value="전북">전북</option>
						<option value="경남">경남</option>
						<option value="경북">경북</option>
						<option value="충남">충남</option>
						<option value="충북">충북</option>
						<option value="부산">부산</option>
						<option value="제주">제주</option>
				</select></td>
				<td align="center" width="60">시,군,구</td>
				<td><input type="text" name="sigungu"></td>
			</tr>
			<tr>
				<td align="center">도로명</td>
				<td colspan="3"><input type="text" name="roadname"> <input
					type="submit" value="검색"></td>
			</tr>
			<tr>
				<td align="center">우편변호</td>
				<td align="center" colspan="3">주소</td>
			</tr>
			<%for(PostDTO dto : list) {
				String zipcode = dto.getZipcode();
				String address=dto.getSido()+" "+
								dto.getSigungu()+" "+
								dto.getYubmyundong()+" "+
								dto.getRi()+" "+
								dto.getRoadname()+" "+
								dto.getBuildingname();%>
			<tr>
				<td align="center"><%= zipcode%></td>
				<td colspan="3"><a class="addressA" href="#"
					onclick="checkPostClose('<%=zipcode%>','<%=address%>')"><%=address%></a></td>
			</tr>
			<%} %>
		</table>
	</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>







