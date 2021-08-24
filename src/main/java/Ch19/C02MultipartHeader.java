package Ch19;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/C02MultipartHeader")
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
public class C02MultipartHeader extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Part Interface
		//Part인터페이스는 multipart/form-data POST 요청으로 수신받는 form아이템이나
		//하나의 Part를 나타낸다
		String files[] = new String[4];
		int i=0;
		for(Part part : req.getParts())
		{
			
			 System.out.println("--------------------------");
			 System.out.println("HTML폼태그이름 : "+part.getName());
			 System.out.println("파일사이즈 :  " + part.getSize()+"Byte");
			 for(String name : part.getHeaderNames())
			 {
				 System.out.println("헤더이름 : " + name);
				 System.out.println("헤더값 : " + part.getHeader(name));
			 }
			 files[i] = getFileName(part);
			 System.out.println("--------------------------");
			 i++;
		}
		System.out.println("파일명 추출하기------------------");
		
		req.setAttribute("filename0", files[0]);
		req.setAttribute("filename1", files[1]);
		req.setAttribute("filename2", files[2]);
		req.setAttribute("filename3", files[3]);
		
		getServletContext().getRequestDispatcher("/Ch19JSP/C04UploadFileOutput.jsp").forward(req, resp);
		//req.setAttribute("filename", filename);
		//forward(req에 "filename", resp에 filename)
		
	}

	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("content-disposition 헤더 : " + contentDisp);
		String [] tokens = contentDisp.split(";");
		//[form-data,name="TESTFORM4",filename="Packman.map]
		//System.out.println("tokens[0] : " + tokens[0]); //form-data
		//System.out.println("tokens[1] : " + tokens[1]); //formname
		//System.out.println("FileName : " + tokens[2]); //여기가 파일명!
		//System.out.println("Filename : " + tokens[2].substring(11,tokens[2].length()-1));
		
		return tokens[2].substring(11,tokens[2].length()-1);
	}
	/*
	 * -------------------------- 
	 * HTML폼태그이름 : TESTFORM4 
	 * 파일사이즈 : 686984Byte 
	 * 헤더이름 : content-disposition 
	 * 헤더값 : form-data; name="TESTFORM4"; filename="IT_바탕화면.jpg"
	 * 헤더이름 : content-type 
	 * 헤더값 : image/jpeg content-disposition 
	 * 헤더 : form-data; name="TESTFORM4"; filename="IT_바탕화면.jpg" 
	 * -------------------------- 파일명추출하기
	 * ------------------
	 */
	
	
	
	

}
