package Ch19;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/C04MultipartHeader")
@MultipartConfig
(
		fileSizeThreshold=1024*1024*10,	// 10MB
										// 업로드파일의 크기가 
										// 여기 설정한 용량을 초과하는경우
										// location에 지정한 경로로 파일저장
		
		maxFileSize=1024*1024*50,		// 50MB  // 파일1개당   최대 사이즈
		maxRequestSize=1024*1024*100	// 100MB // 요청패킷 최대 사이즈
		//location="c:\\upload"			// 파일저장위치 지정(생략)
)
public class C04MultipartHeader extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1
		File upDir = new File("c:\\UPLOAD");
		if(!upDir.exists())
			upDir.mkdirs();
		
		//2
		ArrayList<String> list = new ArrayList();
		String filename = null;
		for(Part part : req.getParts()) 
		{
			filename = getFileName(part);				//파일명추출
			list.add(filename);							//리스트추가
			part.write(upDir+File.separator+filename);	//업로드
			//리눅스 사용시에는 \\대신 //사용 -> File.separator파일의 구분자 사용해줌 
			
		}
		
		//5 - OUT VIEW
		req.setAttribute("list", list);
		//req.setAttribute(String arg0, Object arg1);
		getServletContext().getRequestDispatcher("/Ch19JSP/C06UploadFileOutput.jsp").forward(req, resp);
		
	}
	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String [] tokens = contentDisp.split(";");
		
		return tokens[2].substring(11,tokens[2].length()-1);
		
		/* substring()메서드
		 * Returns a string that is a substring of this string. Thesubstring begins with
		 * the character at the specified index andextends to the end of this string.
		 * Examples:
		 * 
		 * "unhappy".substring(2) returns "happy" "Harbison".substring(3) returns
		 * "bison" "emptiness".substring(9) returns "" (an empty string)
		 */
		
		
	}

}
