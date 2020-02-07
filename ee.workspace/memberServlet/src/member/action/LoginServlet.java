package member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터
		// request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// db
		MemberDAO memberDAO = MemberDAO.getInstance();
		String name = memberDAO.login(id, pwd);
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<boby>");
		if (name == null) {
			out.println("아이디 또는 비밀번호가 맞지 않습니다.");
		} else {
			out.println(name + "님 환영합니다.");
		}
		out.println("</boby>");
		out.println("</html>");

	}

}
