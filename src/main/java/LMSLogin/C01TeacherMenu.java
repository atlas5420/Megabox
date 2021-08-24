package LMSLogin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class C01Teacher
{
	String TID;
	String name;
	String Subject;
	String Email;
}

public class C01TeacherMenu {
//public static으로 Stdlist를 선언하지 않았을 경우1
	//출석부용
	//학생메뉴객체 안의 Stdlist를 이용하기 위한 참조변수
	C01StudentMenu S;
	void setS(C01StudentMenu S) {
		this.S = S;
	}
	//생성자를 이용해서 메인메뉴에서 만든 학생객체의 주소를 받아
	//S에 저장 
	C01TeacherMenu(C01StudentMenu stu){
		this.S=stu;
	}
	C01TeacherMenu() {}
	
//public static으로 Stdlist를 선언했을 경우2
	public static ArrayList<C01Teacher> Tchlist = new ArrayList();
	int Curidx;	// 현재 로그인한 교수 Idx 저장
	
	Scanner sc = new Scanner(System.in);
	int no;
	
	void run() {
		while(true)
		{
		System.out.println("------------ 교수메뉴 -------------");
		System.out.println("1.교수 가입");
		System.out.println("2.로그  인");
		System.out.println("3.로그 아웃");
		System.out.println("4.출 석 부 ");
		System.out.println("5.정보 변경");
		System.out.println("6.계정 삭제");
		System.out.println("7.종료");
		System.out.println("------------ 교수메뉴 -------------");
		System.out.print("입력 :");
		
		try {
			no = sc.nextInt();
			switch(no)
			{
			case 1:
				//계정 가입
				//C01Teacher객체 만들고 각멤버에 값 넣어서 
				//(교수ID , 교수이름 , 교수과목, 이메일주소)
				//ArrayList에 저장 
				sc.nextLine();
				C01Teacher newT = new C01Teacher();
				System.out.print("ID입력 : ");
				newT.TID = sc.nextLine();
				System.out.print("Name : ");
				newT.name = sc.nextLine();
				System.out.print("Subject : ");
				newT.Subject = sc.nextLine();
				System.out.print("Email : ");
				newT.Email = sc.nextLine();
				
				Tchlist.add(newT);
				System.out.println("등록완료!");
				break;
			case 2:
				//로그인
				//ArrayList에 해당 TId가 있는 idx를 CurIdx에 저장
				sc.nextLine();
				System.out.print("ID입력 : ");
				String ID = sc.nextLine();
				boolean flag = false;
				for(int i=0;i<Tchlist.size();i++) {
					if(ID.equals(Tchlist.get(i).TID)) {
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
				System.out.println(Tchlist.get(Curidx).name+"님 로그아웃!");
				Curidx=9999;
				break;
			case 4:
				//출석부
				//S안에 있는 내용 참고해서 idx에 있는 교수과목과 동일한
				//과목을 듣는 학생리스트를 출력 
	//			for(int i=0;i<5;i++) {
					//if(S.stu.Subject[i]==Tchlist.get(i)) {
	//					System.out.println(S.stu.Subject[i]);
	//				}
	//			}
				
	//			for(int i = 0; i<Tchlist.size();i++) {
	//				//idx에 있는 교수과목과 동일한 과목을 듣는가?
	//				if(C01StudentMenu.Stdlist.get(i).Subject.equals(Tchlist.get(i).Subject))
	//				{
	//					//학생리스트 출력
	//					System.out.println(C01StudentMenu.Stdlist.get(i).stdName);
	//				}
	//				else
	//				{
	//					System.out.println("듣는 학생이 없음");
	//				}
	//			}
				if(Curidx==9999)
				{
					System.out.println("로그인 하세요");
				}
				else
				{
					System.out.println("-----출석부 LIST-----");
					C01Teacher ME = Tchlist.get(Curidx);
					
					for(int i=0;i<S.Stdlist.size();i++)
					{
						//학생이 여러과목을 들을 수 있음>반복문 한번더
						for(int j=0;j<S.Stdlist.get(i).Subject.size();j++)
						{
							if(ME.Subject.equals(S.Stdlist.get(i).Subject.get(j)))
							{
								System.out.println((i+1)+" "+S.Stdlist.get(i).stdName);
								break; //한 한생과 비교가 끝났으면 다음 학생으로 넘어가기 위해 안쪽 반복문(j) 탈출 
							}
						}
						
					}
					
				}
				break;
			case 5:
				//정보변경
				//해당 idx에 있는 정보 변경
				int num=0;
				if(Curidx==9999) {
					System.out.println("로그아웃 상태입니다 로그인하세요");
				}
				else
				{
					System.out.println("1 ID 	: "+Tchlist.get(Curidx).TID);
					System.out.println("2 이름 	: "+Tchlist.get(Curidx).name);
					System.out.println("3 과목 	: "+Tchlist.get(Curidx).Subject);
					System.out.println("4 EMAIL : "+Tchlist.get(Curidx).Email);
					System.out.print("수정할 정보 번호 입력 : ");
					num = sc.nextInt();
					sc.nextLine();
					switch(num)
					{
					case 1:
						System.out.print("변경 ID 입력 : ");
						String tmpID = sc.nextLine();
						Tchlist.get(Curidx).TID = tmpID;
						System.out.println("ID변경 완료");
						break;
					case 2:
						System.out.print("변경 이름 입력 : ");
						String tmpName = sc.nextLine();
						Tchlist.get(Curidx).name = tmpName;
						System.out.println("이름 변경 완료");
						break;
					case 3:
						System.out.print("변경 과목 입력 : ");
						String tmpSubject = sc.nextLine();
						Tchlist.get(Curidx).Subject = tmpSubject;
						System.out.println("과목 변경 완료");
						break;
					case 4:
						System.out.print("변경 Email 입력 : ");
						String tmpEmail = sc.nextLine();
						Tchlist.get(Curidx).Email = tmpEmail;
						System.out.println("Email변경 완료");
						break;
					default:
						System.out.println("잘못 입력하셨습니다.");
					}
				}
				break;
			case 6:
				//계정삭제
				//해당 idx에 있는 정보 삭제 
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
						Tchlist.remove(Curidx);
						System.out.println("계정삭제 성공!");
					}
					else
					{
						System.out.println("계정 삭제 취소");
					}
				}
				break;
			case 7:
				//종료
				return ;
			default :
				System.out.println("잘못 입력했습니다. 1~7번까지 입력해주세요");
			}
		} catch (InputMismatchException e) {
			sc = new Scanner(System.in);
			System.out.println("잘못 입력했습니다. 1~7번까지 입력해주세요");
		}
		
		}
	}
}
