package LMSLogin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class C01Student
{
	String stdId;
	String stdName;
	String stdAddr;
	String stdPhone;
	ArrayList<String> Subject = new ArrayList();	//수강신청과목 저장
}

public class C01StudentMenu {
	
	public static ArrayList<C01Student> Stdlist = new ArrayList();
	int Curidx;	// 현재 로그인한 학생 idx 저장  
	
	Scanner sc = new Scanner(System.in);
	int no=0;
	
//	C01TeacherMenu T;
//	void setT(C01TeacherMenu T) 
//	{
//		this.T = T;
//	}
	void run() {
		while(true)
		{
		System.out.println("------------ 학생메뉴 -------------");
		System.out.println("1.계정 등록");
		System.out.println("2.로그  인");
		System.out.println("3.로그 아웃");
		System.out.println("4.내 강의실");
		System.out.println("5.수강 신청");
		System.out.println("6.신청 취소");
		System.out.println("7.정보 수정");
		System.out.println("8.계정 삭제");
		System.out.println("9.종료");
		System.out.println("------------ 학생메뉴 -------------");
		System.out.print("입력 :");
		try {
		no = sc.nextInt();
		switch(no)
		{
		case 1:
			//C01StudentMenu객체를 만들고 
			//각정보 입력한 후
			//ArrayList에 추가합니다
			sc.nextLine();
			C01Student newstd = new C01Student();
			System.out.print("ID입력 : ");
			newstd.stdId = sc.nextLine();
			System.out.print("Name : ");
			newstd.stdName = sc.nextLine();
			System.out.print("Addr : ");
			newstd.stdAddr = sc.nextLine();
			System.out.print("Phone : ");
			newstd.stdPhone = sc.nextLine();
			
			Stdlist.add(newstd);
			System.out.println("등록완료!");
			break;
		case 2:
			//로그인
			//ArrayList에 해당 stdId가 있는 idx를 CurIdx에 저장
			sc.nextLine();
			System.out.print("ID입력 : ");
			String ID = sc.nextLine();
			//중복은 생각하지 말고(중복제거하려면 set, map사용해야함)
			boolean flag = false;
			for(int i = 0; i<Stdlist.size();i++) {
				if(ID.equals(Stdlist.get(i).stdId))
				{
					Curidx = i;
					flag = true;
					break;
				}
				
			}
			if(flag==true)
			{
				System.out.println("로그인 성공");
			}
			else
			{
				System.out.println("로그인 실패");
			}
			break;
		case 3:
			//로그아웃
			//CurIdx 에 9999값 넣음
			System.out.println(Stdlist.get(Curidx).stdName+" 님 로그아웃~");
			Curidx = 9999;
			
			break;
		case 4:
			//내가 신청한 과목 정보 출력(여러 과목일수 있음)
//			for(int i=0;i<Stdlist.get(Curidx).Subject.size();i++) {
//				System.out.println(Stdlist.get(Curidx).Subject.get(i));	
//			}
			
			C01Student cur1 = Stdlist.get(Curidx);
			System.out.println("----수강신청과목 LIST----");
			for(int i = 0; i<cur1.Subject.size();i++)
			{
				System.out.println((i+1)+"번째: "+cur1.Subject.get(i));
			}
			//내가 신청한 과목의 강의실 정보 출력
			
			break;
		case 5:
			//수강가능 과목 출력
			boolean flag2 = false;
			for(int i = 0; i<C01TeacherMenu.Tchlist.size();i++) {
				System.out.println((i+1)+" " + C01TeacherMenu.Tchlist.get(i).Subject
						+ " " +C01TeacherMenu.Tchlist.get(i).name + "\n"
						);
			}
			System.out.print("신청과목명 입력 : ");
			sc.nextLine();
			String sub = sc.nextLine(); //신청할 과목명 입력
			
			for(int i = 0; i<C01TeacherMenu.Tchlist.size();i++) {
				//입력한 값과 교수님의 강의 값을 비교하여 같으면
				if(sub.equals(C01TeacherMenu.Tchlist.get(i).Subject))
				{
					//나의 객체 위치 가져와서 몇개 수강과목신청했는지?
//					int size=Stdlist.get(Curidx).Subject.size(); 
					Stdlist.get(Curidx).Subject.add(sub);
					System.out.println("수강신청완료");
					flag2 = true;
					break;
				}
			}
			if(flag2==false)
			{
				System.out.println("해당 과목은 존재하지 않습니다.");
			}
			//CurIdx에 있는 학생 정보객체에 과목을 입력받아 저장
			
			break;
		case 6:
			sc.nextLine();
			boolean flag1 = false;
			C01Student cur = Stdlist.get(Curidx);
			System.out.println("----수강신청과목 LIST----");
			for(int i = 0; i<cur.Subject.size();i++)
			{
				System.out.println((i+1)+" "+cur.Subject.get(i));
			}
			System.out.println("취소과목입력 : ");
			String rm = sc.nextLine();
			for(int i = 0; i<cur.Subject.size();i++)
			{
				if(rm.equals(cur.Subject.get(i)))
						{
							cur.Subject.remove(i);
							System.out.println("취소 완료!");
							flag1 = true;
							break;
						}
			}
			if(flag1==false)
			{
				System.out.println(rm+" 과목 수강취소 실패");
			}
			//신청 취소할 과목을 입력받아
			//동일한 과목이 있다면 삭제(NULL값 입력)
			
			
			break;
		case 7:
			//학생정보를 수정
			if(Curidx == 9999)
			{
				System.out.println("로그인 하세요");
			}
			else
			{
				System.out.println("1 Login ID  : " +Stdlist.get(Curidx).stdId);
				System.out.println("2 Name		: " +Stdlist.get(Curidx).stdName);
				System.out.println("3 Addr 		: " +Stdlist.get(Curidx).stdAddr);
				System.out.println("4 Phone 	: " +Stdlist.get(Curidx).stdPhone);
				System.out.print("수정할 정보 번호 입력 : ");
				int num = sc.nextInt();
				sc.nextLine();
				switch(num)
				{
				case 1:
					System.out.print("변경 ID 입력 : ");
					String tmpID = sc.nextLine();
					Stdlist.get(Curidx).stdId = tmpID;
					System.out.println("ID변경 완료");
					break;
				case 2:
					System.out.print("변경 이름 입력 : ");
					String tmpName = sc.nextLine();
					Stdlist.get(Curidx).stdName = tmpName;
					System.out.println("이름 변경 완료");
					break;
				case 3:
					System.out.print("변경 주소 입력 : ");
					String tmpAddr = sc.nextLine();
					Stdlist.get(Curidx).stdAddr = tmpAddr;
					System.out.println("주소 변경 완료");
					break;
				case 4:
					System.out.print("변경 연락처 입력 : ");
					String tmpPhone = sc.nextLine();
					Stdlist.get(Curidx).stdPhone = tmpPhone;
					System.out.println("번호 변경 완료");
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
				}
				
			}
			break;
		case 8:
			//계정삭제
			//현재 CurIdx 를 리스트에서 제거 
			if(Curidx == 9999)
			{
				System.out.println("로그인 하세요");
			}
			else
			{
				System.out.println("정말 삭제할 건가요?(Y/N)");
				String tmp=sc.nextLine();
				if(tmp.charAt(0)=='Y'||tmp.charAt(0)=='y')
				{
					Stdlist.remove(Curidx);
					System.out.println("계정삭제 성공!");
				}
				else
				{
					System.out.println("계정 삭제 취소");
				}
			}
			break;
		case 9:
			//종료
			return ;
		default :
			//잘못입력 다시
			System.out.println("잘못 입력했습니다. 1~9번까지 다시 입력해주세요");
		}
		} catch (InputMismatchException e) {
			sc = new Scanner(System.in);
			System.out.println("잘못 입력했습니다. 1~9번까지 다시 입력해주세요");;
		}
		
		
		}	
		
	}
}
