<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style type="text/css">
</style>
</head>
<body>
	<h3>글쓰기</h3>
	<form id="boardWriteForm" action="boardWrite.jsp">
		<table border="1"cellspacing="0" cellpadding="5">
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="subject" id="subject" value="">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" id="content" value="" cols="30" rows="10"></textarea>
				</td>
			</tr>
			<tr>
        		<td colspan="2" align="center">
         			<input type="button" value="글작성" onclick="checkBoardWriteForm()">
          			<input type="reset" value="다시작성">
        		</td>
     		</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>