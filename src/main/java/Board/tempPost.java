package Board;

import java.sql.*;
public class tempPost {
	
	
	public static void main(String[] args) {
		DBConnectionMgr pool=DBConnectionMgr.getInstance();
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql=null;
		try {
			conn=pool.getConnection();
			for(int i=1;i<=1000;i++)
			{
			sql="insert into boardtbl(region,theater,divi,subject,content,regdate)";
			sql+=" values('서울','서울상암','공지','알림','안녕하세요',now());";
			pstmt=conn.prepareStatement(sql);
			pstmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
