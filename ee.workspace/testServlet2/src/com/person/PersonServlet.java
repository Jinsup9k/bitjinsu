package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {
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

		out.println("</style>");
		out.println("</head>");

		out.println("<body>");

		out.println("&bull;이름 : " + name + "<br>");

		out.print("&bull;성별 : ");
		if (gender == 0) {
			out.print("남자" + "<br>");
		} else
			out.print("여자" + "<br>");
		out.println("");

		out.println("&bull;색깔 : " + color + "<br>");

		out.print("&bull;취미 : ");
		for (int i = 0; i < hobby.length; i++) {
			out.print(hobby[i] + " ");
		}
		out.println("<br>");

		out.print("&bull;과목 : ");
		for (int i = 0; i < subject.length; i++) {
			out.print(subject[i] + " ");
		}
		out.println("");

		out.println("</body>");
		out.println("</html>");

	}

}
