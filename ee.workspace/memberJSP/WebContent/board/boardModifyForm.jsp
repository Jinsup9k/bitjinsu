<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));
String subject = request.getParameter("subject");
String content = request.getParameter("content");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글수</h3>
	<form id="boardModifyForm" method="post" action="boardModify.jsp">
	<input type="hidden" name="seq" value="<%=seq %>">
	<input type="hidden" name="pg" value="<%=pg %>">
	<input type="hidden" name="subject" value="<%=subject %>">
	<input type="hidden" name="content" value="<%=content %>">
		<table border="1"cellspacing="0" cellpadding="5">
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="subject" id="subject" value="<%=subject%>">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" id="content" cols="30" rows="10" value=""><%=content%></textarea>
				</td>
			</tr>
			<tr>
        		<td colspan="2" align="center">
         			<input type="button" value="글작성" onclick="checkBoardModifyForm()">
          			<input type="reset" value="다시작성">
        		</td>
     		</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>