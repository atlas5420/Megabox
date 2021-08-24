package Ch16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class stdDAO {
	private DBConnectionMgr pool = null;
	public stdDAO() 
	{
		pool = DBConnectionMgr.getInstance();	
		//db관리 객체 담아오기(static_싱글턴패턴으로 선언되어있어서 이름으로 가져오기 가능)
	}
	
	public ArrayList<stdDTO> select()
	{
		Connection conn=null;
		PreparedStatement stmt = null;	
		ResultSet rs = null;	//조회
		stdDTO bean = null;
		ArrayList<stdDTO> stdlist = new ArrayList();
		try {
			conn = pool.getConnection();
			stmt = conn.prepareStatement("select * from stdtbl");
			rs = stmt.executeQuery();	//select명령어 > excuteQuery
			while(rs.next())
			{
				bean = new stdDTO();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setAddr(rs.getString("addr"));
				stdlist.add(bean);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally
		{
			pool.freeConnection(conn, stmt, rs);
		}
		return stdlist;
	}
	
	public int insert(int id, String name, String addr)
	{
		Connection conn=null;
		PreparedStatement pstmt = null;
		int result = 0;
		try 
		{
			//연결 객체 Pool 통해 가져오기
			conn = pool.getConnection();
			//연결 객체로 쿼리객체 만들고 insert SQL 등록
			pstmt = conn.prepareStatement("insert into stdtbl values(?, ?, ?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			//연결 객체로 쿼리실행 후 결과값 받아오기
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원제거
			pool.freeConnection(conn, pstmt);
		}
		//결과값 호출했던 위치로 리턴
		return result;
	}
	
	public int update(int id, String name, String addr) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		int result = 0;
		try 
		{
			//Pool안에서 DB연결객체 가져옴
			conn = pool.getConnection();
			
			//연결객체를 통해 쿼리객체 생성
			pstmt = conn.prepareStatement("update stdtbl set name=?, addr=? where id=?");
			
			//update stdtbl set 수정필드 where 조건부분
			pstmt.setString(1,  name);
			pstmt.setString(2,  addr);
			pstmt.setInt(3,  id);
			
			//SQL 등록 후 실행
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원제거
			pool.freeConnection(conn, pstmt);
		}
		//결과 값 (정수값)을 리턴
		return result;
	}
	public int delete(int id) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		int result = 0;
		try 
		{
			//Pool안에서 DB연결객체 가져옴
			conn = pool.getConnection();
			
			//연결객체를 통해 쿼리객체 생성
			pstmt = conn.prepareStatement("delete from stdtbl where id=?");
			pstmt.setInt(1,  id);
			
			//SQL 등록 후 실행
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원제거
			pool.freeConnection(conn, pstmt);
		}
		//결과 값 (정수값)을 리턴
		return result;
	}
	
}
