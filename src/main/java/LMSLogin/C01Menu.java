package LMSLogin;

import java.util.Scanner;

public class C01Menu {

	public static void main(String[] args) {
		C01TeacherMenu T = new C01TeacherMenu();
		C01StudentMenu S = new C01StudentMenu();
		C01AdminMenu A = new C01AdminMenu();
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		int no=0;
		
		//학생메뉴의 객체를 담아 교수메뉴에서 사용할 수 있게 연결(메서드로)
		T.setS(S);
		
		while(true)
		{
		System.out.println("------------ L  M  S -------------");
		System.out.println("1.교수 메뉴");
		System.out.println("2.학생 메뉴");
		System.out.println("3.관리자 메뉴");
		System.out.println("4.종료");
		System.out.println("------------ L  M  S -------------");
		System.out.print("입력 :");
		no = sc.nextInt();
		switch (no)
		{
			case 1:	
				T.run();			
				break;
			case 2:
				S.run();
				break;
			case 3:			
				A.run();
				break;
			case 4:
				System.out.println("종료 합니다");
				flag = true;
				break ;
			default:
				
		}	
		if(flag==true)
			break;
		
		}
		
		 
	}

}
