package Ch17;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


@WebServlet("/Servlet01")
public class C01Servlet extends HttpServlet {
/*3.0버전 : javax.servlet.http.HttpServlet;*/
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Service메서드 호출!!wer");
		
	}

	@Override
	public void destroy() {
		System.out.println("destroy메서드 호출!");

	}

	@Override
	public void init() throws ServletException {
		System.out.println("init메서드 호출!");

	}
	
}
