package Ch18.controller;

import java.util.ArrayList;

import Ch18.dao.MemberDAO;
import Ch18.vo.MemberVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSearchController implements Controller {
	MemberDAO dao = MemberDAO.getInstance();
	MemberVO member = null;
	public void SetVO(MemberVO vo) {
		this.member=vo;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
		System.out.println("---------------------------------");
		System.out.println("MemberSearchController의 처리중");
		System.out.println("---------------------------------");
		System.out.println("1) 파라미터 값 추출");
		
		//파라미터 정보 가져오기(클라이언트에서 요청한 정보?)
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		//DB정보 가져오기 > VO에 저장
		System.out.println("2)DB정보를 VO에 저장");
		ArrayList<MemberVO> list = dao.MemberSearch(userid);
		String dbid = null;
		String dbpwd = null;
		String dbname = null;
		String dbemail = null;
		
		for(int i=0;i<list.size();i++)
		{
			dbid = list.get(i).getUserid();
			dbpwd = list.get(i).getPwd();
			dbname = list.get(i).getName();
			dbemail = list.get(i).getEmail();
		}
		
		//Service 실행
//		System.out.println("4) Service 실행 -> MemberService의 MemberJoin()함수 실행");
//		MemberService service = MemberService.getInstance();
//		service.MemberSearch(member);
				
		//입력값 검증 : VO정보와 사용자 입력값 비교하기
		System.out.println("3) VO정보와 사용자 입력값 비교하기");
		if(!userid.equals(dbid) || !pwd.equals(dbpwd))
		{
			//다시 memberinsert로 이동(HttpUtil.java에서 처리)
			request.setAttribute("error",  "올바른 값이 입력되지 않았습니다");
			HttpUtil.forward(request, response, "/Ch18JSP/VIEW/memberSearch.jsp");
		}
		
		//결과를 화면으로 구현
		System.out.println("4) 결과페이지로 이동 -> HttpUtil.forward() 사용");
		request.setAttribute("userid",  userid);
		HttpUtil.forward(request, response, "/Ch18JSP/RESULT/memberSearchOutput.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
