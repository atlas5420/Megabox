package Ch18.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("리스트 출력");
	}
}
