<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="fileUpload.jsp">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" id="subject" value=""></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" id="content" cols="30" rows="10">
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="file" name="upload1" size="50">
			</tr>
			<tr>
				<td colspan="2">
					<input type="file" name="upload2" size="50">
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="파일 업로드">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>