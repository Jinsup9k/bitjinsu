package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.bean.MemberDTO;
import member.bean.PostDTO;

public class MemberDAO {
	private static MemberDAO instance;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private DataSource ds;
	
	public static MemberDAO getInstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}

	public MemberDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");//Tomcat의 경우
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean isexistId(String id) {
		boolean exist = false;
		String sql = "select * from member where id=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next())
				exist = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return exist;
	}

	public int join(MemberDTO memberDTO) {
		int succese = 0;
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());
			succese = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return succese;
	}

	public MemberDTO login(String id, String pwd) {
		MemberDTO memberDTO = null;
		String sql = "SELECT * from member where id = ? AND pwd= ? ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			rs.next();
			memberDTO = new MemberDTO();
			memberDTO.setName(rs.getString("name"));
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPwd(rs.getString("pwd"));
			memberDTO.setGender(rs.getString("gender"));
			memberDTO.setEmail1(rs.getString("email1")==null ? "":rs.getString("email1"));
			memberDTO.setEmail2(rs.getString("email2")==null ? "":rs.getString("email2"));
			memberDTO.setTel1(rs.getString("tel1")==null ? "":rs.getString("tel1"));
			memberDTO.setTel2(rs.getString("tel2")==null ? "":rs.getString("tel2"));
			memberDTO.setTel3(rs.getString("tel3")==null ? "":rs.getString("tel3"));
			memberDTO.setZipcode(rs.getString("zipcode")==null? "":rs.getString("zipcode"));
			memberDTO.setAddr1(rs.getString("addr1")==null? "":rs.getString("addr1"));
			memberDTO.setAddr2(rs.getString("addr2")==null? "":rs.getString("addr2"));
			memberDTO.setLogtime(rs.getString("logtime"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}
	public MemberDTO findMember(String id) {
		MemberDTO memberDTO = null;
		String sql="SELECT * FROM member WHERE id = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			memberDTO = new MemberDTO();
			memberDTO.setName(rs.getString("name"));
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPwd(rs.getString("pwd"));
			memberDTO.setGender(rs.getString("gender"));
			memberDTO.setEmail1(rs.getString("email1")==null ? "":rs.getString("email1"));
			memberDTO.setEmail2(rs.getString("email2")==null ? "":rs.getString("email2"));
			memberDTO.setTel1(rs.getString("tel1")==null ? "":rs.getString("tel1"));
			memberDTO.setTel2(rs.getString("tel2")==null ? "":rs.getString("tel2"));
			memberDTO.setTel3(rs.getString("tel3")==null ? "":rs.getString("tel3"));
			memberDTO.setZipcode(rs.getString("zipcode")==null? "":rs.getString("zipcode"));
			memberDTO.setAddr1(rs.getString("addr1")==null? "":rs.getString("addr1"));
			memberDTO.setAddr2(rs.getString("addr2")==null? "":rs.getString("addr2"));
			memberDTO.setLogtime(rs.getString("logtime"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}
	
	public void update(MemberDTO memberDTO) {
		String sql="UPDATE member SET name=?, pwd=?, gender=?, email1=?, email2=?, tel1=?,"
					+" tel2=?, tel3=?, zipcode=?, addr1=?, addr2=?, logtime=SYSDATE"
					+" WHERE id= ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getZipcode());
			pstmt.setString(10, memberDTO.getAddr1());
			pstmt.setString(11, memberDTO.getAddr2());
			pstmt.setString(12, memberDTO.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public List<PostDTO> post(PostDTO postDTO) {
		List<PostDTO> list = new ArrayList<PostDTO>();
		String sql = "SELECT * from newzipcode where sido like ? AND nvl(sigungu,'0') like ? AND roadname like ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+postDTO.getSido()+"%");
			pstmt.setString(2, "%"+postDTO.getSigungu()+"%");
			pstmt.setString(3, "%"+postDTO.getRoadname()+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostDTO postDTO2 = new PostDTO();
				postDTO2.setSido(rs.getString("sido"));
				postDTO2.setSigungu(rs.getString("sigungu")==null ? "":rs.getString("sigungu"));
				postDTO2.setYubmyundong(rs.getString("yubmyundong")==null ? "":rs.getString("yubmyundong"));
				postDTO2.setRoadname(rs.getString("roadname"));
				postDTO2.setRi(rs.getString("ri")==null ? "":rs.getString("ri"));
				postDTO2.setBuildingname(rs.getString("buildingname")==null ? "":rs.getString("buildingname"));
				postDTO2.setZipcode(rs.getString("zipcode"));
				
				list .add(postDTO2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
