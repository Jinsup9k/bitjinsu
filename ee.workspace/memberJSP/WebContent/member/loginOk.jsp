<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = null;
String name = null;
//request.setCharacterEncoding("UTF-8");
//String name = request.getParameter("name");
//String id = request.getParameter("id");

//쿠키 -- 특정 쿠키를 얻지못하고 모든 쿠키를 얻어온다.
/* Cookie[] ar = request.getCookies();
if(ar!=null){
	for(int i = 0; i<ar.length; i++){
 		//String cookieName = ar[i].getName();
		//String cookieValue = ar[i].getValue();
		
		//System.out.println("쿠키명 = "+cookieName);
		//System.out.println("쿠키값 = "+cookieValue);
		//System.out.println("----------");
		 
		if(ar[i].getName().equals("memName"))
			name= ar[i].getValue();
		if(ar[i].getName().equals("memId"))
			id= ar[i].getValue();
		  
	}
} */

//세션
name = (String)session.getAttribute("memName");
id = (String)session.getAttribute("memId");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../main/logo.jsp"/>
<div align = "center">
<%=name %>님 로그인<br><br>
<input type="button" value="회원정보수정" onclick="location.href='modifyForm.jsp'">
<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
</div>
</body>
</html>