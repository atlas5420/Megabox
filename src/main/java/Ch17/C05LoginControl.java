package Ch17;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/C05LoginControl.do")
public class C05LoginControl extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1 파라미터 값 저장
		req.setCharacterEncoding("UTF-8");
		String userid = req.getParameter("userid");
		String pwd = req.getParameter("userpwd");
		
		//2 세션 부여(C05LoginProc.jsp참고)
		if(!userid.equals("") && !pwd.equals(""))
		{
			
			HttpSession session = req.getSession();
			session.setAttribute("idKey",  userid);
			session.setMaxInactiveInterval(60*60*24);
			System.out.println("사용자 ID/PW입력, 세션부여합니다.");
			//3 유저 메인페이지로 이동
			resp.sendRedirect("/Ch17JSP/test/C07LMSID저장/02users/C01Main.jsp");
			
		}
		else
		{
			System.out.println("ID/PW잘못입력!");
			resp.sendRedirect("/HTMLCSSJS/Ch17JSP/test/C07LMSID저장/C04Login.jsp");
		}
		
	}
	
}
