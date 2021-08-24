package LMSLogin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class LectureRoom
{
	int RoomNum;			//강의장번호
	boolean state=false; 	//강의배정여부
	String Subject;			//강의과목

}
public class C01AdminMenu {
	
	//강의실 룸정보 저장(교수메뉴/학생메뉴에도 볼수있도록 static 표시)
//	ArrayList<LectureRoom> RoomList = new ArrayList();
	public static LectureRoom RoomList[][] = new LectureRoom[3][3];
	
	//절차지향 문법 적용 위해선 메서드 내에서 처리해야됨--!!!!
	public C01AdminMenu() {
		for(int i=0;i<RoomList.length;i++)
		{
			for(int j=0;j<RoomList[i].length;j++)
			{
				RoomList[i][j] = new LectureRoom();
				RoomList[i][j].RoomNum = Room[i][j];
			}
		}
	}
	//학생정보,교수정보 확인용
	C01StudentMenu S;
	C01TeacherMenu T;
	
	//생성자를 이용해서 Menu에 있는 학생메뉴객체주소와
	//교수메뉴객체주소를 각각 멤버변수에 삽입합니다
//	C01AdminMenu(C01TeacherMenu T, C01StudentMenu S) {
//		this.T = T;
//		this.S = S;
//	}
//	C01AdminMenu() {}
	
	int Room[][] = 
		{
				{101, 102, 103},
				{201, 202, 203},
				{301, 302, 303},
		};
	
	
	
	Scanner sc = new Scanner(System.in);
	int no=0;
	int Curidx=9999;
	void run() {
		while(true)
		{
		System.out.println("------------ Admin메뉴 -------------");
		System.out.println("1.관리자 로그인");
		System.out.println("2.가입교수 리스트");
		System.out.println("3.가입학생 리스트");
		System.out.println("4.가능강의 리스트");
		System.out.println("5.수강학생 리스트"); //S
		System.out.println("6.강의실 리스트");		
		System.out.println("7.강의실 배정");
		System.out.println("8.교수 계정삭제");
		System.out.println("9.학생 계정삭제");
		System.out.println("10.종료");
		System.out.println("------------ Admin메뉴 -------------");
		System.out.print("입력 :");
		
		try 
		{
		no = sc.nextInt();
		switch(no)
			{
			case 1:
				//로그인
				sc.nextLine();
				System.out.print("관리자 ID 입력 : ");
				String ID = sc.nextLine();
				
				
			case 2:
				for(int i=0;i<C01TeacherMenu.Tchlist.size();i++)
				{
					System.out.println((i+1)+" "+C01TeacherMenu.Tchlist.get(i).name);
				}
				//가입교수 리스트(교수명)
				//현재 저장된 교수 정보가 출력됩니다(교수정보 전체출력)
				
				break;
			case 3:
				for(int i=0;i<C01StudentMenu.Stdlist.size();i++)
				{
					System.out.println((i+1)+" "+C01StudentMenu.Stdlist.get(i).stdName);
				}
				
				//가입학생 리스트
				//현재 저장된 학생 정보가 출력됩니다
				break;
			case 4:
				for(int i=0;i<C01TeacherMenu.Tchlist.size();i++)
				{
					System.out.println((i+1)+" "+C01TeacherMenu.Tchlist.get(i).name);
					System.out.println(" "+C01TeacherMenu.Tchlist.get(i).Subject);
				}
				//가능강의 리스트
				//현재 가능한 강의정보가 출력됩니다
				break;
			case 5:
				System.out.println("-----수강신청 학생 리스트-----");
				for(int i=0;i<C01StudentMenu.Stdlist.size();i++)
				{
					C01Student std = C01StudentMenu.Stdlist.get(i);
					if(std.Subject.size()!=0)
					{
						for(int j=0;j<std.Subject.size();j++)
						{
							System.out.print("이름 : " + std.stdName);
							System.out.println(" 신청과목 : "+ std.Subject.get(j));
						}
					}
				}
				//수강학생 리스트 
				//현재 수강신청한 학생정보가 출력됩니다 
				break;
			case 6:
				//강의실 리스트
				//전체 강의장 번호와 
				//수업배정반의 강의장과
				//잔여 강의장을 출력합니다
				System.out.println("--- 강의장 배치상태 ---");
				for(int i = 0; i<RoomList.length;i++)
				{
					for(int j=0; j<RoomList[i].length;j++)
					{
						System.out.print(RoomList[i][j].RoomNum+":"+RoomList[i][j].state+"\t");
					}
					System.out.println();
				}
				break;
			case 7:
				//강의실 배정
				//배정받은 강의실 정보 출력 합니다
				//교수 수업정보 먼저 출력
				//입력값받기(수업명 / 호실번호)
				//수업명 == 교수수업명 일치하면
				//LectureRoom의 해당 입력한 room 번호와 일치한 위치에 수업명 삽입
				sc.nextLine();
				System.out.println("--- 수업 과목명 ---");
				for(int i=0;i<C01TeacherMenu.Tchlist.size();i++)
				{
					System.out.print((i+1)+" "+C01TeacherMenu.Tchlist.get(i).name);
					System.out.println(" "+C01TeacherMenu.Tchlist.get(i).Subject);
				}
				System.out.println("--- 강의장 배치상태 ---");
				for(int i = 0; i<RoomList.length;i++)
				{
					for(int j=0; j<RoomList[i].length;j++)
					{
						System.out.print(RoomList[i][j].RoomNum+":"+RoomList[i][j].state+"\t");
					}
					System.out.println();
				}
				System.out.print("배치 과목명 : ");
				String Sub=sc.nextLine(); //강의장등록 과목명
				System.out.print("호실 입력 : ");
				int roomnum=sc.nextInt(); //호실번호
				
				//과목명 검증??
				boolean ok = false;
				for(int i=0;i<C01TeacherMenu.Tchlist.size();i++)
				{
					if(Sub.equals(C01TeacherMenu.Tchlist.get(i).Subject))
					{
						ok=true;
						break;
					}
				}
				if(ok==true)
				{
					
				}
				
				if(ok!=true)
				{
					break;
				}
				//LectureRoom에 등록
				boolean flag = false;
				for(int i = 0; i<RoomList.length;i++)
				{
					for(int j=0; j<RoomList[i].length;j++)
					{
						if(roomnum==RoomList[i][j].RoomNum)
						{
							RoomList[i][j].state=true;
							RoomList[i][j].Subject=Sub;
							flag = true;
							break;
						}
					}
					System.out.println();
					if(flag==true)
						break;
				}
				break;
			case 8:
				sc.nextLine();
				System.out.println("관리자 권한으로 삭제할 교수 ID 입력 : ");
				String RTid = sc.nextLine();
				for(int i = 0; i<C01TeacherMenu.Tchlist.size(); i++) {
					if(RTid.equals(C01TeacherMenu.Tchlist.get(i).TID))
					{
						System.out.println("ID 삭제 완료");
						System.out.println("삭제된 ID : " + C01TeacherMenu.Tchlist.get(i).TID);
						C01TeacherMenu.Tchlist.remove(i);
						break;
					}
					else {
						System.out.println("동일한 ID가 없습니다. 다시 입력하세요");
						continue;
					}
				}
				//교수ID를 입력받아 해당ID를  리스트에서 삭제합니다
				break;
			case 9:
				//학생ID를 입력받아 해당ID를  리스트에서 삭제합니다
				sc.nextLine();
				System.out.println("관리자 권한으로 삭제할 학생 ID 입력 : ");
				String RSid = sc.nextLine();
				for(int i=0; i<C01StudentMenu.Stdlist.size();i++) {
					if(RSid.equals(C01StudentMenu.Stdlist.get(i).stdId))
					{
						System.out.println("ID 삭제 완료");
						System.out.println("삭제된 ID : " + C01StudentMenu.Stdlist.get(i).stdId);
						C01StudentMenu.Stdlist.remove(i);
						break;
					}
					else {
						System.out.println("동일한 ID가 없습니다. 다시 입력하세요");
						continue;
					}
				}
				break;
			case 10:
				//Main 메뉴로 돌아갑니다
				return ;
			default :
				//잘못입력 다시
				System.out.println("잘못 입력했습니다. 1~10번까지 다시 입력해주세요");
							
			}
		} catch (InputMismatchException e) {
			sc = new Scanner(System.in);
			System.out.println("잘못 입력했습니다. 1~10번까지 다시 입력해주세요");
		}
			
		
		}	

	}
}
