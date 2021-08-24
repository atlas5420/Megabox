package Ch18.service;

import Ch18.dao.MemberDAO;
import Ch18.vo.MemberVO;

public class MemberService {
	
	//DB처리 객체 받아옴
	public MemberDAO dao = MemberDAO.getInstance();
	
	//싱글톤 패턴 구현
	private static MemberService service = new MemberService();
	private MemberService() {}
	public static MemberService getInstance() {
		return service;
	}
	
	public void MemberJoin(MemberVO member) {
		System.out.println("---------------------------------");
		System.out.println("MemberService의 MemberJoin() 메서드 사용");
		System.out.println("---------------------------------");
		System.out.println("DAO객체의 MemberJoin(member)메서드로 DB연결 후 회원정보 INSERT 처리");
		dao.MemberJoin(member);
		System.out.println("DAO객체의 MemberJoin(member)메서드로 DB연결 후 회원정보 INSERT 완료");
	}
	public void MemberUpdate(MemberVO member) {
		System.out.println("---------------------------------");
		System.out.println("MemberService의 MemberUpdate() 메서드 사용");
		System.out.println("---------------------------------");
		System.out.println("DAO객체의 MemberUpdate(member)메서드로 DB연결 후 회원정보 UPDATE 처리");
		dao.MemberUpdate(member);
		System.out.println("DAO객체의 MemberUpdate(member)메서드로 DB연결 후 회원정보 UPDATE 완료");
	}
	public void MemberSearch(MemberVO member) {
		System.out.println("---------------------------------");
		System.out.println("MemberService의 MemberUpdate() 메서드 사용");
		System.out.println("---------------------------------");
		System.out.println("DAO객체의 MemberUpdate(member)메서드로 DB연결 후 회원정보 Search 처리");
		dao.MemberSearch(member.getUserid());
		System.out.println("DAO객체의 MemberUpdate(member)메서드로 DB연결 후 회원정보 Search 완료");
	}
//	public void MemberDelete(String userid) {
//		
//	}
//	public ArrayList<MemberVO> MemberList(MemberVO member) {
//		
//	}
	
}
