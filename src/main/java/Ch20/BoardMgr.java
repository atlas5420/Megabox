package Ch20;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;

public class BoardMgr {
	
	DBConnectionMgr pool = null;
	
	public BoardMgr() {
		try {
		pool = DBConnectionMgr.getInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getTotalCount(String keyField, String keyWord) {
		//검색했을 때 어떤 문자열이 포함된 게시물 가져오도록 String keyField, String keyWord
		//keyField = name, subject, content db에서는 열 이름임
		
		int total = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = pool.getConnection();
			
			if(keyWord.equals("null") || keyWord.equals("")) {
				//전체 게시물개수를 리턴
				pstmt = conn.prepareStatement("select count(*) from tblboard");
/* 
mysql> select count(*) from tblboard;
+----------+
| count(*) |
+----------+
|     1000 |
+----------+
1 row in set (0.00 sec)
 */
				
			}else {
				//전달받은 검색 정보를 만족하는 게시물개수를 select
				pstmt = conn.prepareStatement("select count(*) from tblboard where "+keyField+" like ? ");
				pstmt.setString(1, "%"+keyWord+"%");
			}
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				total=rs.getInt(1);	// |     1000 |
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn,  pstmt, rs);
		}
		return total;
	}
	
	public ArrayList<BoardBean> getBoardList(String keyField, String keyWord, int start, int end)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<BoardBean> blist = new ArrayList();
		
		try {
			conn=pool.getConnection();
			
			if(keyWord.equals("null") || keyWord.equals(""))
			{
				sql="select * from tblBoard order by ref desc, pos limit ?, ?";	//오름차순정렬, 답글고려o-reply페이지 구성시 수정완료
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,  start);
				pstmt.setInt(2, end);
			}
			else
			{
				//키워드 고려 검색
				sql="select * from tblBoard where " +keyField+" like ? ";
				sql+=" order by ref desc, pos limit ?, ?";	//오름차순정렬, 답글고려o-reply페이지 구성시 수정완료
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, "%"+keyWord+"%");
				pstmt.setInt(2,  start);
				pstmt.setInt(3, end);
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardBean bean = new BoardBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSubject(rs.getString("subject"));
				bean.setPos(rs.getInt("pos"));
				bean.setRef(rs.getInt("ref"));
				bean.setDepth(rs.getInt("depth"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setCount(rs.getInt("count"));
				blist.add(bean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn,  pstmt, rs);
		}
		return blist;
	}
	
	public void insertBoard(HttpServletRequest req, Part part)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String filename = null;
		int filesize = 0;
		
		try {

			conn = pool.getConnection();
			//1. ref 값 구하기(처음게시되는 글은 num==ref)
			sql="select max(num) from tblboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int ref=1;
			if(rs.next())	//게시물이 하나이상 있다면?!
				ref=rs.getInt(1) + 1;
			
			//2. 업로드
			File file = new File("c:\\UPLOAD");
			if(!file.exists())	//존재하지 않는다면
				file.mkdirs();  //파일생성, mkdirs는 필요하면 부모 디렉토리까지 생성.
			
			//3. 파일이름 추출
			filename = getFileName(part);
			
			//4. 업로드
			if(!filename.equals(""))	//파일이 등록되어 있다면
			{
				part.write("c:\\UPLOAD"+File.separator+filename);
				filesize=(int)part.getSize();
			}
			else
			{
				filename="파일없음";
			}
			
			//5. DB 내용 INSERT	//ref부모게시글의 번호, 답변글의 부모로부터 상대위치 pos, depth는 답변글을 달았을 때 몇번째 디렉토리위치인가? ,regdate등록날짜.. 
			sql="insert into tblboard(name,content,subject,ref,pos,depth,regdate,pass,count,ip,filename,filesize)";
			sql+=" values(?,?,?,?,0,0,now(),?,0,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, req.getParameter("name"));
			pstmt.setString(2, req.getParameter("content"));
			pstmt.setString(3, req.getParameter("subject"));
			pstmt.setInt(4, ref);
			pstmt.setString(5, req.getParameter("pass"));
			pstmt.setString(6, req.getParameter("ip"));
			pstmt.setString(7, filename);
			pstmt.setInt(8, filesize);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}
			
	}
	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String [] tokens = contentDisp.split(";");
		
		return tokens[2].substring(11,tokens[2].length()-1);
		
		/* substring()메서드
		 * Returns a string that is a substring of this string. 
		 * Thesubstring begins with
		 * the character at the specified index andextends
		 * to the end of this string.
		 * 
		 * Examples:
		 * 
		 * "unhappy".substring(2) returns "happy"
		 * "Harbison".substring(3) returns
		 * "bison" "emptiness".substring(9) returns "" (an empty string)
		 */
	}
	
	public void upCount(int num)	//게시물 번호를 받아서
	{
		Connection conn= null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn = pool.getConnection();
			sql = "update tblBoard set count=count+1 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt);
		}
	}
	
	public BoardBean getBoard(int num)
	{
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BoardBean bean = new BoardBean();
		try {
			conn = pool.getConnection();
			sql = "select * from tblBoard where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSubject(rs.getString("subject"));
				bean.setContent(rs.getString("content"));
				bean.setPos(rs.getInt("pos"));
				bean.setRef(rs.getInt("ref"));
				bean.setDepth(rs.getInt("depth"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setPass(rs.getString("pass"));
				bean.setCount(rs.getInt("count"));
				bean.setFilename(rs.getString("filename"));
				bean.setFilesize(rs.getInt("filesize"));
				bean.setIp(rs.getString("ip"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		return bean;
	}
	
	public void updateBoard(BoardBean bean) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn=pool.getConnection();
			sql="update tblBoard set name=?, subject=?, content=? where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getSubject());
			pstmt.setString(3, bean.getContent());
			pstmt.setInt(4, bean.getNum());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt);
		}
	}
	
	//답변글들 pos값 1씩 증가
	public void replyUpBoard(int ref, int pos)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = pool.getConnection();
			sql = "update tblboard set pos=pos+1 where ref=? and pos > ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, pos);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt);
		}
	}
	
	public void replyBoard(BoardBean bean)
	{
		Connection conn=null;
		PreparedStatement pstmt = null;
		String sql=null;
		
		try {
			conn=pool.getConnection();
			sql="insert into tblboard(name,content,subject,ref,pos,depth,regdate,pass,count,ip)";
			sql+=" value(?,?,?,?,?,?,now(),?,0,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getContent());
			pstmt.setString(3, bean.getSubject());
			pstmt.setInt(4, bean.getRef());
			//pos(pos 1증가)
			pstmt.setInt(5, bean.getPos()+1);
			
			//depth(부모글로부터의 level)
			pstmt.setInt(6, bean.getDepth()+1);
			pstmt.setString(7, bean.getPass());
			pstmt.setString(8, bean.getIp());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt);
		}
	}
	
	public void deleteBoard(int num, int ref, int pos)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = pool.getConnection();
			
			if(pos==0) {
			//1 첨부파일 삭제
			sql = "select filename from tblboard where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next() && !rs.getString(1).equals("파일없음"))	//검색된 내용이 있고, 파일이름도 있을 때
			{
				File file = new File("c:\\UPLOAD"+File.separator+rs.getString(1));
				if(file.exists()) //파일이 존재한다면 boolean
				{
					if(file.isFile())	//파일이 일반파일이라면(디렉토리x) boolean
					{
						file.delete();	//파일 삭제
					}
				}
			}
					
			//2 게시글 삭제(답변글 포함)
			
			//만약 pos==0이라면 ref로 답변글까지 모두삭제
				sql = "delete from tblboard where ref=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.executeUpdate();
				System.out.println("pos: "+pos);
			}
			else{
				System.out.println("pos: "+pos);
			//만약 pos>0이라면 해당 num의 답변글만 삭제
				sql = "delete from tblboard where num=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}
	}
	
	public void downLoad(HttpServletRequest req, HttpServletResponse resp, 
			JspWriter out, PageContext pageContext)
	{
		try {
			
		//1 파일이름 받아오기
		String filename = req.getParameter("filename");

		//2 파일헤더 설정
		String mimeType = req.getServletContext().getMimeType(filename);	//미리 정의해놓은 약속된 type
		//https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types
		/* [MIME타입]
		 * MIME 타입이란 클라이언트에게 전송된 문서의 다양성을 알려주기 위한 메커니즘
		 * 
		 *  웹에서 파일의 확장자는 별 의미가 없습니다. 
		 *  그러므로, 각 문서와 함께 올바른 MIME 타입을 전송하도록, 
		 *  서버가 정확히 설정하는 것이 중요
		 * 
		 * 브라우저들은 리소스를 내려받았을 때
		 * 해야 할 기본 동작이 무엇인지를 결정하기 위해 대게 MIME 타입을 사용
		 * 
		 * 특정 서브타입이 없는 텍스트 문서들에 대해서는 
		 * text/plain가 사용되어야 합니다. 
		 * 특정 혹은 알려진 서브타입이 없는 이진 문서에 대해서는 유사하게, 
		 * application/octet-stream이 사용되어야 합니다.
		 */
		if(mimeType==null) {
			mimeType = "application/octet-stream";
		}
		resp.setContentType(mimeType);
		
		//3 한글문자 깨짐방지 인코딩
		filename = URLEncoder.encode(filename, "utf-8").replaceAll("\\+","%20");
		//setHeader(String name, String value) : 지정된 이름과 값으로 응답 헤더 설정
		resp.setHeader("Content-Disposition", "attachment; fileName="+filename);
		//attachment 무조건 다운

		//4 버퍼 공간 + 스트림생성
		byte[] buff = new byte[4096];
		FileInputStream instream = new FileInputStream("c:\\UPLOAD"+File.separator+filename);
		ServletOutputStream outstream = resp.getOutputStream();
		
		out.clear();					//클라이언트 웹브라우저 버퍼 공간 초기화(하는 이유?)
		out=pageContext.pushBody();	//JSP페이지 대한 정보 저장
		//제대로 다운받을 수 있도록 데이터 초기화 기본값 지정
		
		int read=0;
		while(true) {
			read = instream.read(buff, 0, buff.length);	//UPLOAD폴더의 파일을 서버로 읽어옴 buff저장
			if(read==-1) {
				break;
			}else {
			outstream.write(buff,0,read);	//클라이언트로 읽어들인 Buff안의 데이터를 전달
			}
		}
		outstream.flush();
		outstream.close();
		instream.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
