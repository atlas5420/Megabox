package Ch15;

import java.sql.*;

public class MemberDAO {
//DAO 디자인패턴?
	//멤버변수
	Connection conn=null;			//DB연결 객체 저장용
	PreparedStatement stmt = null;	//쿼리실행객체 저장용
	ResultSet rs = null;			//쿼리실행결과 저장용
	MemberDTO member = null;
	//기능구현
	//0) 연결
	public void ConnectDB() {
		try {
			//드라이브 메모리 적재
			String URL = "jdbc:mysql://localhost:3306/testdb";
			String ID = "root";
			String PW = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			//특정 URL로 JAVA_DB연결 -Connection클래스
			conn=DriverManager.getConnection(URL, ID, PW);
			System.out.println("DB연결 성공.....");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void SetDTO(MemberDTO dto) {
		this.member=dto;
	}
	//1) 삽입
	public int InsertMember()
	{
		int result = 0;
		try {
			String SQL = "INSERT INTO memberTbl values(?,?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(SQL);
			stmt.setString(1,  member.getUserid());
			stmt.setString(2, member.getPwd());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getPh1()+"-"+member.getPh2()+"-"+member.getPh3());
			stmt.setString(5,  member.getTel1()+"-"+member.getTel2()+"-"+member.getTel3());
			stmt.setString(6,  member.getEmail());
			stmt.setString(7,  member.getAddrnum());
			stmt.setString(8,  member.getAddr1());
			stmt.setString(9,  member.getAddr2());
			//SMS수신, 이메일 수신
			if(member.getSmsrecv()!=null) {
				stmt.setInt(10, 1);
			}else {
				stmt.setInt(10, 0);
			}
			if(member.getEmailrecv()!=null) {
				stmt.setInt(11, 1);
			}else {
				stmt.setInt(11, 0);
			}
			result = stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//2) 수정
	public int UpdateMember() //
	{
		int result = 0;
		//전달받은 userid와 일치하는 id가 DB내에 존재하는지 여부
		//존재한다면 DB내의 유저정보를 가져와서 화면에 출력
		//내용정보를 변경한 다음에 Update요청
		try {
			//update TABLE set 수정필드 where 조건부분
			String SQL = "UPDATE memberTbl set "
					+ "pwd=?, name=?, "
					+ "phone=?, tel=?, email=?, zipcode=?, addr1=?, addr2=?, "
					+ "smsrecv=?, emailrecv=? "
					+ "where userid='"+member.getUserid()+"'";
			
			stmt=conn.prepareStatement(SQL);
			
			//수정할 내용
			stmt.setString(1, member.getPwd());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPh1()+"-"+member.getPh2()+"-"+member.getPh3());
			stmt.setString(4,  member.getTel1()+"-"+member.getTel2()+"-"+member.getTel3());
			stmt.setString(5,  member.getEmail());
			stmt.setString(6,  member.getAddrnum());
			stmt.setString(7,  member.getAddr1());
			stmt.setString(8,  member.getAddr2());
			//SMS수신, 이메일 수신
			if(member.getSmsrecv()!=null) {
				stmt.setInt(9, 1);
			}else {
				stmt.setInt(9, 0);
			}
			if(member.getEmailrecv()!=null) {
				stmt.setInt(10, 1);
			}else {
				stmt.setInt(10, 0);
			}
			
			result = stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//3) 조회
	public MemberDTO SearchMember(String userid)
	{
		/* MemberDTO member=null; */
		try {
				stmt = conn.prepareStatement("select * from membertbl where userid='"+userid+"'");
				rs = stmt.executeQuery();
				while(rs.next())
				{
					//member객체 안의 요소에 db에 있는 요소를 넣어줌
					member=new MemberDTO();
					member.setUserid(rs.getString("userid"));
					member.setPwd(rs.getString("pwd"));
					member.setName(rs.getString("name"));
					String ph = rs.getString("phone");
					String tmp[] = ph.split("-"); //010-222-3333 -> [010, 222, 3333]
					member.setPh1(tmp[0]);
					member.setPh2(tmp[1]);
					member.setPh3(tmp[2]);
					String tel = rs.getString("tel");
					String tmp2[] = tel.split("-");
					member.setTel1(tmp2[0]);
					member.setTel2(tmp2[1]);
					member.setTel3(tmp2[2]);
					member.setEmail(rs.getString("email"));
					member.setAddrnum(rs.getString("zipcode"));
					member.setAddr1(rs.getString("addr1"));
					member.setAddr2(rs.getString("addr2"));
					if(rs.getInt("smsrecv")!=0)
					{
						member.setSmsrecv("on");
					}
					if(rs.getInt("emailrecv")!=0)
					{
						member.setEmailrecv("on");
					}
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return member; 
	}
	
	//4) 삭제
	public int DeleteMember()
	{
		int result = 0;
		try {
			//update TABLE set 수정필드 where 조건부분
			String SQL = "delete from membertbl where id=?";
			stmt=conn.prepareStatement(SQL);
			stmt.setString(1,  member.getUserid());
			stmt.setString(2, member.getPwd());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getPh1()+"-"+member.getPh2()+"-"+member.getPh3());
			stmt.setString(5,  member.getTel1()+"-"+member.getTel2()+"-"+member.getTel3());
			stmt.setString(6,  member.getEmail());
			stmt.setString(7,  member.getAddrnum());
			stmt.setString(8,  member.getAddr1());
			stmt.setString(9,  member.getAddr2());
			//SMS수신, 이메일 수신
			if(member.getSmsrecv()!=null) {
				stmt.setInt(10, 1);
			}else {
				stmt.setInt(10, 0);
			}
			if(member.getEmailrecv()!=null) {
				stmt.setInt(11, 1);
			}else {
				stmt.setInt(11, 0);
			}
			result = stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//
	public void Disconnect()
	{
		if(conn!=null) {
			try{conn.close();}catch(Exception e) {e.printStackTrace();}
		}
		if(stmt!=null) {
			try{stmt.close();}catch(Exception e) {e.printStackTrace();}
		}
		if(rs!=null) {
			try{rs.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
}
