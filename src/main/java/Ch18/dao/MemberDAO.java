package Ch18.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Ch18.vo.MemberVO;

public class MemberDAO {
	
	DBConnectionMgr pool = DBConnectionMgr.getInstance();
	//싱글턴패턴
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance()
	{
		return instance;
	}
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void MemberJoin(MemberVO member) {
		try
		{
			conn = pool.getConnection();
			pstmt = conn.prepareStatement("insert into membertbl values(?,?,?,?)");	//전달할 SQL 지정
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			int result = pstmt.executeUpdate();
			System.out.println("쿼리 전송이후 변화된 행의 수 : " + result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt);
		}
	}
	public ArrayList<MemberVO> MemberSearch(String userid)
	{
		MemberVO bean = null;
		ArrayList<MemberVO> list = new ArrayList();
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement("select * from membertbl where id='"+userid+"'");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				bean = new MemberVO();
				bean.setUserid(rs.getString("userid"));
				bean.setPwd(rs.getString("pwd"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		return list;
	}
	
	public void MemberUpdate(MemberVO member) {
		try
		{
			conn = pool.getConnection();
			pstmt = conn.prepareStatement("update membertbl set pwd=?, name=?, email=? where userid=?");	//전달할 SQL 지정
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getUserid());
			int result = pstmt.executeUpdate();
			System.out.println("쿼리 전송이후 변화된 행의 수 : " + result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt);
		}
	}
//	public void MemberDelete() {
//		
//	}
//	public void MemberList() {
//		
//	}
}
