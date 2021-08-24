package Ch19;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/C01MultipartHeader")
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
public class C01MultipartHeader extends HttpServlet{
//configuration : 구성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Part Interface
		//Part인터페이스는 multipart/form-data POST 요청으로 수신받는 form아이템이나
		//하나의 Part를 나타낸다
		
		for(Part part : req.getParts())
		{
			 System.out.println("--------------------------");
			 System.out.println("HTML폼태그이름 : "+ part.getName());
			 System.out.println("파일사이즈 :  " + part.getSize()+"Byte");
			 for(String name : part.getHeaderNames())
			 {
				 System.out.println("헤더이름 : " + name);
				 System.out.println("헤더값 : " + part.getHeader(name));
			 }
			 System.out.println("--------------------------");
		}
		/*--------------------------
		HTML폼태그이름 : TESTFORM
		파일사이즈 :  410Byte
		헤더이름 : content-disposition
		헤더값 : form-data; name="TESTFORM"; filename="chrome.VisualElementsManifest.xml"
		헤더이름 : content-type
		헤더값 : text/xml
		--------------------------*/
	}
}
