
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
    
<%
request.setCharacterEncoding("UTF-8");
String realFolder = request.getServletContext().getRealPath("/storage");
System.out.println("실제폴더 = "+realFolder);

//업로드
MultipartRequest multi = new MultipartRequest(request
											, realFolder
											, 5*1024*1024
											, "UTF-8"
											, new DefaultFileRenamePolicy());//파일 재명명 해주는 역할
//데이터
String subject = multi.getParameter("subject");
String content = multi.getParameter("content");
		
String originalFileName1 = multi.getOriginalFileName("upload1");
String originalFileName2 = multi.getOriginalFileName("upload2");

String fileName1 = multi.getFilesystemName("upload1");
String fileName2 = multi.getFilesystemName("upload2");

File file1 = multi.getFile("upload1");
File file2 = multi.getFile("upload2");

long fileSize1= 0;
long fileSize2= 0;

if(file1!=null) fileSize1 = file1.length();
if(file2!=null) fileSize1 = file2.length();


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileupload.jsp</title>
</head>
<body>
<h3>파일이 업로드 되었습니다.</h3>
<ul>
	<li>제목 : <%=subject %><br></li>
	<li>내용 : <pre><%=content %></pre><br></li>
	<li>파일 : <a href="fileDownload.jsp?fileName=<%=URLEncoder.encode(originalFileName1,"UTF-8") %>"><%=originalFileName1 %></a><br></li>
	<li>파일 : <%=fileName1 %><br></li>
	<li>크기 : <%=fileSize1 %><br>
	-------------------------------------</li>
	<li>파일 : <a href="fileDownload.jsp?fileName=<%=URLEncoder.encode(originalFileName2,"UTF-8") %>"><%=originalFileName2 %></a><br></li>
	<li>파일 : <%=fileName2 %><br></li>
	<li>크기 : <%=fileSize2 %><br></li>
	
</ul>
</body>
</html>