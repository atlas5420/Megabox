package Ch17;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
/*3.0버전 : javax.servlet.http.HttpServlet;*/
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/C02DoGet.do")

public class C02DoGet extends HttpServlet {
	/* [서블릿 맵핑]
	 * 서블릿 맵핑명만 지정하는 방식
	 * @WebSErvlet("/맵핑명")
	 * public class C03DoPost extends HttpServlet{...}
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("userid"));
		System.out.println(req.getParameter("pwd"));
		PrintWriter out = resp.getWriter();	// 
		//jsp에서 out내장객체 사용하는 방법, servlet에선 이 문장을 써줘야함
		out.println("USERID : " + req.getParameter("userid"));
		out.println("PWD : " + req.getParameter("pwd"));
		
	}
	
	
}
