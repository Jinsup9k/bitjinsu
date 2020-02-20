<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form name="imageboardListForm" method="post" action="../imageboard/imageboardDelete.do">
<table>
  <tr>
    <th><input type="checkbox" id="checkAll"onclick="javascript:checkAll()">번호</th>
    <th>이미지</th>
    <th>상품명</th>
    <th>단가</th>
    <th>개수</th>
    <th>합계</th>
  </tr>
  <c:forEach var="imageboardDTO" items="${list }">
  <tr>
    <td align="center"><input type="checkbox" name="check" value="${imageboardDTO.seq }">${imageboardDTO.seq }</td>
    <td align="center">
    	<a href="#" onclick="location.href='../imageboard/imageboardView.do?seq=${imageboardDTO.seq}&pg=${pg }'">
    		<img width="80" height="80" src="../storage/${imageboardDTO.image1 }">
    	</a>
    </td>
    <td align="center">${imageboardDTO.imageName }</td>
    <td align="center">
    	<fmt:formatNumber pattern="#,###원">
    		${imageboardDTO.imagePrice }
    	</fmt:formatNumber>
    </td>
    <td align="center">${imageboardDTO.imageQty }</td>
    <td align="center">
    	<fmt:formatNumber pattern="#,###원">
    		${imageboardDTO.imagePrice * imageboardDTO.imageQty }
    	</fmt:formatNumber>
    </td>
  </tr>
  </c:forEach>
</table>
</form>
<input type="button" value="선택삭제" onclick="deleteCheck()">
<div  style="display:inline-block; width: 700px; text-align: center;">${paging }</div>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/board.js?ver=1"></script>