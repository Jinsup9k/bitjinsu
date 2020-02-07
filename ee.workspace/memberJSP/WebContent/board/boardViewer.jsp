<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>
<jsp:useBean id="boardDTO" class="board.bean.BoardDTO"/>
<%
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));
boardDTO = boardDAO.getBoard(seq);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardViewer</title>
</head>
<body>
<jsp:include page="../main/logo.jsp"/>
<h2>게시글</h2>
	<table border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
		<tr>
			<td colspan="3">
				<h3><%=boardDTO.getSubject()%></h3>
			</td>
		</tr>
		<tr>
			<td width="150">글번호: <%=boardDTO.getSeq() %></td>
			<td width="150">작성자: <%=boardDTO.getId() %></td>
			<td width="150">조회수: <%=boardDTO.getHit() %></td>
		</tr>
		<tr>
			<td colspan="3" height="200" valign="top">
				<pre><%=boardDTO.getContent() %></pre>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg %>'">
				<%if(session.getAttribute("memId").equals(boardDTO.getId())){ %>
					<input type="button" value="글수정" onclick="">
					<input type="button" value="글삭제" onclick=""> 
				<%} %>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>