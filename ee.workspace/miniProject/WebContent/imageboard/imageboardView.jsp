<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table>
	<tr>
		<td rowspan="4"><img width="80" height="80" src="../storage/${imageboardDTO.image1 }"></td>
		<td>${imageboardDTO.imageName }</td>
	</tr>
	<tr>
		<td>${imageboardDTO.imagePrice }</td>
	</tr>
	
	<tr>
		<td>${imageboardDTO.imageQty }</td>
	</tr>
	
	<tr>
		<td>${imageboardDTO.imagePrice* boardDTO.imageQty }
	</tr>
	
	<tr>
		<td colspan="2">${imageboardDTO.imageContent }</td>
	</tr>
</table>
<td><input type="button" value="목록" onclick="location.href=''"></td>
