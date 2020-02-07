<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.dao.MemberDAO"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="member.bean.MemberDTO"%>
<%
	//DATA
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	MemberDTO memberDTO = memberDAO.login(id, pwd);

	//email
	String email = memberDTO.getEmail1() + "@" + memberDTO.getEmail2();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인.jsp</title>
</head>
<body>
	<%
		if (memberDTO.getId()!=null) {
			//response.sendRedirect("loginOk.jsp?name=" + URLEncoder.encode(name, "UTF-8")+"&id="+URLEncoder.encode(id, "UTF-8"));

			//쿠키
			/* Cookie cookie = new Cookie("memName",name);
			cookie.setMaxAge(30*60);// 초단위
			response.addCookie(cookie); //클라이언트에 보내기
			
			Cookie cookie2 = new Cookie("memId",id);
			cookie2.setMaxAge(30*60);// 초단위
			response.addCookie(cookie2); //클라이언트에 보내기 */

			//세션
			//HttpSession session = request.getSession(); 내장객체 
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", email);

			response.sendRedirect("loginOk.jsp");
		} else {
			response.sendRedirect("loginFail.jsp");
		}
	%>
</body>
</html>