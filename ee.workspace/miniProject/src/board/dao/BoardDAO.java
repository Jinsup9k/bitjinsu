package board.dao;

import java.io.IOException;
import java.io.Reader;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance;
	private SqlSessionFactory sqlSessionFactory;

	public static BoardDAO getInstance() {
		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

	public BoardDAO() {
		String resource = "mybatis-config.xml";

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void boardWrite(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite", map);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<BoardDTO> boardList(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map);

		sqlSession.close();

		return list;
	}

	public BoardDTO getBoard(int seq) {
		BoardDTO boardDTO = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);

		sqlSession.close();

		return boardDTO;
	}

	public int getBoardTotalA() {
		int totalA = 0;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		totalA = sqlSession.selectOne("boardSQL.getBoardTotalA");

		sqlSession.close();

		return totalA;
	}

	public void boardModify(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.boardModify", map);
		
		sqlSession.commit();
		sqlSession.close();
	}

	public void boardHit(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.boardHit",seq);
		sqlSession.commit();
		sqlSession.close();
	}

	public void boardReply(Map<String, String> map) {		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//원글
		BoardDTO pDTO = getBoard(Integer.parseInt(map.get("pseq")));
		
		//글순서
		sqlSession.update("boardSQL.boardReply1", pDTO);
		
		//답글쓰기
		map.put("ref", pDTO.getRef()+"");
		map.put("lev", pDTO.getLev()+1+"");
		map.put("step", pDTO.getStep()+1+"");
		sqlSession.insert("boardSQL.boardReply2", map);
		
		//답글수
		sqlSession.update("boardSQL.boardReply3", pDTO);
		
		
		sqlSession.commit();
		sqlSession.close();
	}

	public void boardDelete(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.selectOne("boardSQL.boardDelete", seq);
		
		sqlSession.commit();
		sqlSession.close();
	}
}
