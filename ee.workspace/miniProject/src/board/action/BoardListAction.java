package board.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//데이터
		HttpSession session = request.getSession();

		int pg = Integer.parseInt(request.getParameter("pg"));
		request.setAttribute("pg", pg);
		
		//DB - 1페이지당 5개씩
		BoardDAO boardDAO = BoardDAO.getInstance();
		int endNum = pg*5;
		int startNum = endNum-4;
		
		List<BoardDTO> list = boardDAO.boardList(startNum, endNum);

		//페이징 처리
		BoardPaging boardPaging = new BoardPaging();
		int totalA = boardDAO.getBoardTotalA(); //총글수
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);

		StringBuffer paging = boardPaging.makePagingHTML();
		request.setAttribute("paging", paging);

		//조회수 - 새로고침 방지
		if(session.getAttribute("memId")!=null){
			Cookie cookie = new Cookie("memHit", "0");
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);
		}
		request.setAttribute("list", list);
		request.setAttribute("display", "/board/boardList.jsp");
		return "/main/index.jsp";
	}

}
