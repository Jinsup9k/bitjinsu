package imageboard.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO {
	private static ImageboardDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public static ImageboardDAO getInstance() {
		if (instance == null) {
			synchronized (ImageboardDAO.class) {
				instance = new ImageboardDAO();
			}
		}
		return instance;
	}
	
	public ImageboardDAO() {
		String resource = "mybatis-config.xml";

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void imageboardWrite(ImageboardDTO imageboardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("imageboardSQL.imageboardWrite",imageboardDTO);
		sqlSession.commit();
		sqlSession.close();

	}

	public List<ImageboardDTO> imageboardList(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ImageboardDTO> list = sqlSession.selectList("imageboardSQL.imageboardList", map);

		sqlSession.close();

		return list;
	}

	public int getBoardTotalA() {
		int totalA = 0;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		totalA = sqlSession.selectOne("imageboardSQL.getImageboardTotalA");

		sqlSession.close();

		return totalA;
	}

	public ImageboardDTO getImageboard(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ImageboardDTO imageboardDTO = sqlSession.selectOne("imageboardSQL.getImageboard", seq);
        System.out.println("dao"+imageboardDTO.getImage1());
		sqlSession.close();

		return imageboardDTO;
	}

	public void imageboardDelete(String[] seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
//		for(int i = 0; i<seq.length;i++) {
//			sqlSession.delete("imageboardSQL.imageboardDelete",Integer.parseInt(seq[i]));
//		}
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put("array", seq);
		sqlSession.delete("imageboardSQL.imageboardDelete2",map);
		
		sqlSession.commit();
		sqlSession.close();
		
	}
}
