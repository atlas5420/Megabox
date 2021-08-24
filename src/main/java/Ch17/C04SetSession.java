package Ch17;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/C04SetSession.do")
public class C04SetSession extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		if(!userid.equals("") && !pwd.equals(""))
		{
			//세션 부여
			//받은 req를 dispatcher로 전달?
			System.out.println("올바른 ID/PW 입력, 세션부여합니다");
			
			//jsp에서는 내장객체로 session을 사용했지만 servlet에서는 직접 만들어서 사용
			//HttpSession클래스로..
			HttpSession session = req.getSession();
			session.setAttribute("idKey", userid);
			session.setMaxInactiveInterval(60*60*24);
			//RequestDispatcher클래스로 받은 req를 C04Main으로 전달
			RequestDispatcher disp = req.getRequestDispatcher("/Ch17JSP/C04Main.jsp");
			//forward방식으로 전달
			disp.forward(req,  resp);
		}
		else
		{
			//userid==null || pwd==null
			//다시입력 -> Login 이동
			System.out.println("ID/PW잘못입력!");
			//새로운 객체 생성? 새로운 req, resp 생성해서 전달
			resp.sendRedirect("/HTMLCSSJS/Ch17JSP/C04Login.jsp");
		}
	}
	/*
	 * [포워딩 페이지 구성]
	 * 요청과 응답에 대한 제어권을 다른 페이지로 넘기더라도
	 * 브라우저에 표시되는 주소가 유지되는 방식 현재 페이지의 요청과
	 * 응답의 정보에 대한 제거원만이 다른페이지로 넘어감 요청 정보와 응답 정보는 유지
	 * 
	 * [참고] [리다이렉트 방식(response내장 객체)] 
	 * 브라우저에 표시되는 주소가 바뀌는 방식 이동할 페이지로 요청과 응답 객체를 "새로"
	 * 생성하여 전송 response내장객체의 sendRedirect메서드를 사용
	 */
}
