package board.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		//조회수 - 새로고침 방지
		BoardDAO boardDAO = BoardDAO.getInstance();
		Cookie[] ar = request.getCookies();
		if(ar!=null){
			for(int i=0; i<ar.length; i++){
				if(ar[i].getName().equals("memHit")){
					boardDAO.boardHit(seq);//조회수 증가
					ar[i].setMaxAge(0);
					response.addCookie(ar[i]);
				}
			}
		}

		//DB
		BoardDTO boardDTO = boardDAO.getBoard(seq);
		
		request.setAttribute("pg", pg);
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("display", "/board/boardView.jsp");
		return "/main/index.jsp";
	}

}
