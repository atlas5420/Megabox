package Ch18.controller;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{

	HashMap<String, Controller> list = null;	//Key : URL주소 저장, Value : 기능별(De, In, Se, Update)Controller객체들을 저장
	
	@Override
	public void init() throws ServletException {
		System.out.println("---------------------------------");
		System.out.println("FrontController의 init() 메서드 실행!");
		System.out.println("---------------------------------");
		list = new HashMap();
		list.put("/HTMLCSSJS/Ch18JSP/VIEW/memberInsert.do",  new MemberInsertController());
		list.put("/HTMLCSSJS/Ch18JSP/VIEW/memberSearch.do",  new MemberSearchController());
		list.put("/HTMLCSSJS/Ch18JSP/VIEW/memberUpdate.do",  new MemberUpdateController());
		list.put("/HTMLCSSJS/Ch18JSP/VIEW/memberDelete.do",  new MemberDeleteController());
		list.put("/HTMLCSSJS/memberList.do",  new MemberListController());
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---------------------------------");
		System.out.println("FrontController의 service() 메서드 실행!");
		System.out.println("---------------------------------");
		System.out.println("1. 클라이언트의 Action URL경로를 받아 해당 기능 처리 객체의 execute() 실행");
		String URL = request.getRequestURI();	//action경로 받아옴
		System.out.println("URL : " + URL);
		Controller controller = list.get(URL); //Map에서 해당 action경로에 대한 기능객체를 가져옴
		controller.execute(request, response);	//해당기능객체를 실행
		
	}


	
}
