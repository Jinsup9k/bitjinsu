<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.net.URLEncoder" %>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%
//데이터
String fileName = request.getParameter("fileName");
String realFolder = request.getServletContext().getRealPath("/storage");

//다운로드 받을 파일 생성
File file = new File(realFolder, fileName);
fileName = URLEncoder.encode(fileName,"UTF-8").replace("+", " ");

response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
response.setHeader("Content-Length", file.length()+"");

out.clear();
out = pageContext.pushBody();

BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

int size = (int)file.length();
byte[] b = new byte[size];
bis.read(b,0,size);
bos.write(b);

bis.close();
bos.close();
%>