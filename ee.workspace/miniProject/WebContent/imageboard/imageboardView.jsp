<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table>
	<tr>
		<td rowspan="4"><img width="150" height="150" src="../storage/${imageboardDTO.image1 }"></td>
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
<div><input type="button" value="목록" onclick="location.href='imageboardList.do?pg=${pg}'"></div>
