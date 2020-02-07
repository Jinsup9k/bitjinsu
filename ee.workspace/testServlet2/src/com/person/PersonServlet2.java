package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청
		String name = request.getParameter("name");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String color = request.getParameter("color");
		String[] hobby = request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");

		// 응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=\"text/css\">");
		if (color.equals("red")) {
			out.println("body{color:#ff0000}");
		} else if (color.equals("orange")) {
			out.println("body{color:#e57733}");
		} else if (color.equals("yellow")) {
			out.println("body{color:#ffe13c}");
		} else if (color.equals("green")) {
			out.println("body{color:#00ff00}");
		} else if (color.equals("blue")) {
			out.println("body{color:#0000ff}");
		}
		out.println(".backA:link {color: red; text-decoration: none; }");//a tag가처음 걸렸을때 
		out.println(".backA:visited {color: blue; text-decoration: none; }");//a tag를 클릭했을때
		out.println(".backA:hover {color: green; text-decoration: underline; }");//a tag에 마우스를 올렸을때
		out.println(".backA:active {color: magenta; text-decoration: none; }");//a tag를 누르고 있을때

		out.println("</style>");
		out.println("</head>");

		out.println("<body>");
		out.println("<ul>");
		out.println("<li>이름 : " + name + "<br><br>");

		out.print("<li>성별 : ");
		if (gender == 0) {
			out.print("남자" + "<br><br>");
		} else
			out.print("여자" + "<br><br>");
		out.println("");

		out.println("<li>색깔 : " + color + "<br><br>");

		out.print("<li>취미 : ");
		for (int i = 0; i < hobby.length; i++) {
			out.print(hobby[i] + " ");
		}
		out.println("<br><br>");

		out.print("<li>과목 : ");
		for (int i = 0; i < subject.length; i++) {
			out.print(subject[i] + " ");
		}
		out.println("");
		out.println("</ul>");
		out.println("<a class='backA' href='javascript:history.go(-1)'>뒤로</a>"); //링크 거는 a tag
		out.println("</body>");
		out.println("</html>");

	}

}
