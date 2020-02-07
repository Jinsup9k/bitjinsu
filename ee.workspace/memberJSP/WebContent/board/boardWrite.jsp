<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="boardDTO" class="board.bean.BoardDTO"/>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>
<%
//데이터
//boardDTO.setId((String)session.getAttribute("memId"));
//boardDTO.setName((String)session.getAttribute("memName"));
//boardDTO.setEmail((String)session.getAttribute("memEmail"));
//boardDTO.setSubject(request.getParameter("subject"));
//boardDTO.setContent(request.getParameter("content"));
Map<String,String> map = new HashMap<String, String>();
map.put("id",(String)session.getAttribute("memId"));
map.put("name",(String)session.getAttribute("memName"));
map.put("email",(String)session.getAttribute("memEmail"));
map.put("subject",request.getParameter("subject"));
map.put("content",request.getParameter("content"));
//DB
boardDAO.boardWrite(map);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script type="text/javascript">
window.onload=function(){
	alert("작성 완료.");
	location.href='boardList.jsp?pg=1';
}
</script>
</html>