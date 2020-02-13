package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class WriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName((String)request.getParameter("name"));
		System.out.println((String)request.getParameter("name"));
		memberDTO.setId((String)request.getParameter("id"));
		memberDTO.setPwd((String)request.getParameter("pwd"));
		memberDTO.setGender((String)request.getParameter("gender"));
		memberDTO.setEmail1((String)request.getParameter("email1"));
		memberDTO.setEmail2((String)request.getParameter("email2"));
		memberDTO.setTel1((String)request.getParameter("tel1"));
		memberDTO.setTel2((String)request.getParameter("tel2"));
		memberDTO.setTel3((String)request.getParameter("tel3"));
		memberDTO.setZipcode((String)request.getParameter("zipcode"));
		memberDTO.setAddr1((String)request.getParameter("addr1"));
		memberDTO.setAddr2((String)request.getParameter("addr2"));
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		int su = memberDAO.write(memberDTO);
		
		//응답
		if(su == 1) {
			return "/member/writeOk.jsp";
		}else {
			return "/member/writeFail.jsp";			
		}
		
	}

}
