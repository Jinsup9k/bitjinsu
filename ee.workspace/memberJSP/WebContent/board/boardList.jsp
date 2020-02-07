<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List , board.bean.BoardDTO"%>
<%@page import="board.bean.BoardPaging"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>
<%
// data
request.setCharacterEncoding("UTF-8");
int pg = Integer.parseInt(request.getParameter("pg"));
// DB 1페이지당 5개씩
int endNumber = pg*5;
int startNumber = endNumber-4;
List<BoardDTO> list = boardDAO.boardList(startNumber, endNumber);
//세션
String id= (String)session.getAttribute("memId");
//페이징 처리
BoardPaging boardPaging = new BoardPaging();
int totalA = boardDAO.getBoardTotalA();
boardPaging.setCurrentPage(pg);
boardPaging.setPageBlock(3);
boardPaging.setPageSize(5);
boardPaging.setTotalA(totalA);

boardPaging.makePagingHTML();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
<style type="text/css">
.bottom{
	width: 600px;
}
.bottom1{
    float: left;
}
.bottom2{
    float: center;
    text-align: center;
}
.seq{
	float: left;
	width: 60px;
	text-align: center;
}
.subject{
	float: left;
	width: 300px;
}
.id{
	float: left;
	width: 100px;
	text-align: center;
}
.logtime{
	float: left;
	width: 200px;
	text-align: center;
}
.hit{
	float: left;
	width: 50px;
	text-align: center;
}
a:link { color: black; text-decoration: none; }
a:visited { color: black; text-decoration: none; }
a:hover { color: green; text-decoration: underline; cursor:pointer;}
a:active { color: black;}
#currentPaging {color: red; text-decoration: underline; }
</style>
</head>
<body>
	<table border="1" cellpadding="0" frame="hsides" rules="rows">
		<th class="seq">글 번호</th>
		<th class="subject">제목</th>
		<th class="id">작성자</th>
		<th class="logtime">작성일</th>
		<th class="hit">조회수</th>
	<%if(list!=null){ %>
		<%for(BoardDTO boardDTO : list){ %>
		<tr>
			<td class="seq"> 
				<%=boardDTO.getSeq() %>
			</td>		
			<td class="subject"> 
				<a href="javascript:void(0)" onclick="isLogin('<%=id%>',<%=boardDTO.getSeq()%>,<%=pg%>)">
					<%=boardDTO.getSubject() %>
				</a>
			</td>		
			<td class="id" > 
				<%=boardDTO.getId() %>
			</td>		
			<td class="logtime"> 
				<%=boardDTO.getLogtime() %>
			</td>		
			<td class="hit"> 
				<%=boardDTO.getHit() %>
			</td>				
		</tr>
		<%} %>
	<%} %>
	</table>
	<div class="bottom">
		<div class="bottom1"><jsp:include page="../main/logo.jsp"/></div>
		<div class="bottom2"><%=boardPaging.getPagingHTML() %></div>
	</div>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>