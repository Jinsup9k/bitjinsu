package imageboard.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import imageboard.bean.ImageboardDTO;
import imageboard.bean.ImageboardPaging;
import imageboard.dao.ImageboardDAO;

public class ImageboardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		HttpSession session = request.getSession();
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		request.setAttribute("pg", pg);
		//db
		int endNum = pg*3;
		int startNum = endNum-2;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("endNum",Integer.toString(endNum));
		map.put("startNum",Integer.toString(startNum));
		
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		List<ImageboardDTO> list = imageboardDAO.imageboardList(map);
		
		//페이징
		ImageboardPaging imageboardPaging = new ImageboardPaging();
		int totalA = imageboardDAO.getBoardTotalA(); //총글수
		imageboardPaging.setCurrentPage(pg);
		imageboardPaging.setPageBlock(3);
		imageboardPaging.setPageSize(5);
		imageboardPaging.setTotalA(totalA);
		
		StringBuffer paging = imageboardPaging.makePagingHTML();
		request.setAttribute("paging", paging);
		
		request.setAttribute("list", list);
		request.setAttribute("display", "/imageboard/imageboardList.jsp");
		return "/main/index.jsp";		
	}

}
