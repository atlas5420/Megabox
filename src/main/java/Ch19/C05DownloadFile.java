package Ch19;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/C05DownloadFile")
public class C05DownloadFile extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1
		String UpDir = "c:\\UPLOAD";
		String filename = req.getParameter("filename");	
		String filepath = UpDir + File.separator+filename; //다운로드 예정인 파일경로
		
		//2
		byte [] buff = new byte[4096];
		
		//3 파일헤더 설정
		String mimeType = getServletContext().getMimeType(filepath);	//미리 정의해놓은 약속된 type
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
		
		//4 한글문자 깨짐방지 인코딩
		filename = URLEncoder.encode(filename, "utf-8").replaceAll("\\+","%20");
		//setHeader(String name, String value) : 지정된 이름과 값으로 응답 헤더 설정
		resp.setHeader("Content-Disposition", "attachment; fileName="+filename);
		//attachment 무조건 다운
		
		//5 파일쓰기
		FileInputStream instream = new FileInputStream(filepath);	//자바로 가져오기
		ServletOutputStream outstream = resp.getOutputStream();		//페이지로 전달하기
		
		int r = 0;
		while(r!=-1)
		{
			r = instream.read(buff, 0, buff.length);	// 버퍼 단위로 file내용을 읽어들여서 저장 , file 내용을 buff배열에 저장, byte 수를 리턴
			/* abstract int read() : 1btye를 읽어온다(0~255사이의 값), 더이상 읽어 올 데이터가 없으면 -1을 반환한다.
			 * abstract메서드라서 InputStrea의 자손들은 자신의 상황에 알맞게 구현해야한다.
			 */
			/* int read(byte[] b, int off, int len) : 최대 len개의 byte를 읽어서, 배열 b의 지정된 위치(off)부터 저장한다.
			 * 실제로 읽어 올 수 있는 데이터가 len개보다 적을 수 있다. 
			 */
			outstream.write(buff, 0, r);	//buff배열의 내용을 클라이언트에 전달
		}
		outstream.flush();
		outstream.close();
		instream.close();
	}
	
}
