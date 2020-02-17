<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>imageboardWriteForm</title>
<style type="text/css">
.tb1{
	width: 400px;
	height: 150px;
	border:solid;
}
</style>
</head>
<body>
	<form name="imageboardWriteForm" method="post" enctype="multipart/form-data" action="imageboard.do">
		<table class="tb1">
			<tr>
				<td width="70" align="center">상품코드</td>
				<td><input type="text" name="imageId" size="40" value="img_"></td>
			</tr>

			<tr>
				<td width="70" align="center">상품명</td>
				<td><input type="text" name="imageName" size="50" placeholder="상품명 입력"></td>
			</tr>

			<tr>
				<td width="70" align="center">단가</td>
				<td><input type="text" name="imagePrice" size="30" placeholder="단가 입력"></td>
			</tr>

			<tr>
				<td width="70" align="center">갯수</td>
				<td><input type="text" name="imageQty" size="30" placeholder="갯수 입력"></td>
			</tr>


			<tr>
				<td align="center" width="70">내용</td>
				<td><textarea name="imageContent" rows="15" cols="50" placeholder="내용 입력"></textarea></td>
			</tr>

			<tr>
				<td colspan="2">
					<input type="file" name="image1" size="50">
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input type="button" value="이미지 등록" onclick="location.href='checkImageboardWriteForm'"> 
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
function checkWriteForm(){
if(document.imageboardWriteForm.name.value=="")
	alert("이름을 입력하세요");
else if(document.imageboardWriteForm.id.value=="")
	alert("아이디를 입력하세요");
else if(document.imageboardWriteForm.pwd.value=="")
else if(document.getElementById("pwd").value=="")	
	alert("비밀번호를 입력하세요");
else if(document.imageboardWriteForm.pwd.value != document.writeForm.repwd.value)
	alert("비밀번호가 맞지 않습니다");
else if(document.imageboardWriteForm.id.value != document.writeForm.check.value)
	alert("중복체크 하세요");
else
	document.imageboardWriteForm.submit();
}
</script>
</html>