package Ch13;

import java.util.*;

public class ProdRepository {

	public static ArrayList<Product> list = new ArrayList(); //Product를 저장하기 위함
	public static Map<String, ArrayList<Product>> map = new HashMap();
					//유저id, 제품value를 리스트형태로 저장
	//static으로 선언되어서 프로그램이 꺼지기 전까지 데이터가 남아있음(session이 꺼져도)
	//session객체 대신 application객체를 사용하면 static사용하지 않아도 됨.
	
	public ProdRepository() {}
	
	public void addProduct(String userid, Product prod)
	{
		list.add(prod); //책정보(책이름/출판사/가격)을 list에 추가
		map.put(userid,  list);
		System.out.println("계정명 : " + userid + ", 추가한 책 개수 : " + list.size());
		System.out.println("MAP에 추가된 계정 : " + map.size());
	}
	
	public Map<String, ArrayList<Product>> getMap()
	{
		return map;
	}
	
}
