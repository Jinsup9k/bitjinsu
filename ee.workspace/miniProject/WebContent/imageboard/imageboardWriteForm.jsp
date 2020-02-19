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
	margin: 20px;
}
</style>
</head>
<body>
	<form name="imageboardWriteForm" method="post" enctype="multipart/form-data" action="../imageboard/imageboardWrite.do">
		<table class="tb1">
			<tr>
				<td width="70" align="center">상품코드</td>
				<td><input type="text" name="imageId" id="imageId" size="40" value="img_">
					<div id="imageIdDiv"></div>
				</td>
			</tr>

			<tr>
				<td width="70" align="center">상품명</td>
				<td><input type="text" name="imageName" id="imageName" size="50" placeholder="상품명 입력">
					<div id="imageNameDiv"></div>
				</td>
			</tr>

			<tr>
				<td width="70" align="center">단가</td>
				<td><input type="text" name="imagePrice" id="imagePrice" size="30" placeholder="단가 입력">
					<div id="imagePriceDiv"></div>
				</td>
			</tr>

			<tr>
				<td width="70" align="center">갯수</td>
				<td><input type="text" name="imageQty" id="imageQty" size="30" placeholder="갯수 입력">
					<div id="imageQtyDiv"></div>
				</td>
			</tr>

			<tr>
				<td align="center" width="70">내용</td>
				<td><textarea name="imageContent" id="imageContent" rows="15" cols="50" placeholder="내용 입력"></textarea>
					<div id="imageContentDiv"></div>
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<input type="file" name="image1" id="image1" size="50">
					<div id="image1Div"></div>
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input id="imageboardWriteFormBtn" type="button" value="이미지등록">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$('#imageboardWriteFormBtn').click(function(){
	$('#imageIdDiv').empty();
	$('#imageNameDiv').empty();
	$('#imagePriceDiv').empty();
	$('#imageQtyDiv').empty();
	$('#imgaeContentDiv').empty();
	$('#image1Div').empty();
	
	if($('#imageId').val()=='img_' || $('#imageId').val()==''){
		$('#imageIdDiv').text('상품코드를 입력하세요');
		$('#imageIdDiv').css('color','red');
		$('#imageIdDiv').css('font-size','8pt');
		$('#imageIdDiv').css('font-weight','bold');
	}else if($('#imageName').val()==''){
		$('#imageNameDiv').text('상품명을 입력하세요');
		$('#imageNameDiv').css('color','red');
		$('#imageNameDiv').css('font-size','8pt');
		$('#imageNameDiv').css('font-weight','bold');
	}else if($('#imagePrice').val()==''){
		$('#imagePriceDiv').text('단가를 입력하세요');
		$('#imagePriceDiv').css('color','red');
		$('#imagePriceDiv').css('font-size','8pt');
		$('#imagePriceDiv').css('font-weight','bold');
	}else if($('#imageQty').val() == '' ){
		$('#imageQtyDiv').text('갯수를 입력하세요');
		$('#imageQtyDiv').css('color','red');
		$('#imageQtyDiv').css('font-size','8pt');
		$('#imageQtyDiv').css('font-weight','bold');
	}else if($('#imageContent').val() == ''){
		$('#imageContentDiv').text('내용을 입력하세요');
		$('#imageContentDiv').css('color','red');
		$('#imageContentDiv').css('font-size','8pt');
		$('#imageContentDiv').css('font-weight','bold');
	}else if($('#image1').val() == ''){
		$('#image1Div').text('이미지 파일이 없습니다');
		$('#image1Div').css('color','red');
		$('#image1Div').css('font-size','8pt');
		$('#image1Div').css('font-weight','bold');
	}else
		$('form[name=imageboardWriteForm]').submit();
	
});
</script>
</html>