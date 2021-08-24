package Ch17;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class C06Servlet extends HttpServlet{
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Service메서드 호출!");
		PrintWriter out = arg1.getWriter();
		out.println("Hello Servlet TEST!!");
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
