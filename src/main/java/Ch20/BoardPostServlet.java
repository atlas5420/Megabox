package Ch20;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/BoardPost")
@MultipartConfig
(
	fileSizeThreshold=1024*1024*10, 	//10MB
			// 업로드파일의 크기가 
			// 여기 설정한 용량을 초과하는경우
			// location에 지정한 경로로 파일저장
	maxFileSize = 1024*1024*50,			//50MB // 파일1개당   최대 사이즈
	maxRequestSize=1024*1024*100		//100MB // 요청패킷 최대 사이즈
			//location="c:\\upload"			// 파일저장위치 지정(생략)
)

public class BoardPostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardMgr bMgr = new BoardMgr();
		Part part = req.getPart("uploadFile");
		bMgr.insertBoard(req, part); 
		resp.sendRedirect("/HTMLCSSJS/Ch20JSP/List.jsp");
	}
	
}
