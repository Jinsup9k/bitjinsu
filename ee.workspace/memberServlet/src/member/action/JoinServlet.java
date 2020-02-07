package member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터
		request.setCharacterEncoding("UTF-8");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(request.getParameter("name"));
		memberDTO.setId(request.getParameter("id"));
		memberDTO.setPwd(request.getParameter("pwd"));
		memberDTO.setGender(request.getParameter("gender"));
		memberDTO.setEmail1(request.getParameter("email1"));
		memberDTO.setEmail2(request.getParameter("email2"));
		memberDTO.setTel1(request.getParameter("tel1"));
		memberDTO.setTel2(request.getParameter("tel2"));
		memberDTO.setTel3(request.getParameter("tel3"));
		memberDTO.setZipcode(request.getParameter("zipcode"));
		memberDTO.setAddr1(request.getParameter("addr1"));
		memberDTO.setAddr2(request.getParameter("addr2"));

		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		int succese = memberDAO.join(memberDTO);

		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (succese == 1) {
			out.println(memberDTO.getName() + "님 회원가입 성공");
		} else {
			out.println("회원가입 실패");
		}
		out.println("</body>");
		out.println("</html>");

	}

}
