package Ch13;
import java.util.*;

public class C01SetMain {
	public static void main(String[] args) {
		Set<String> set = new HashSet();
		
		set.add("JAVA");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("ABCD");
		set.add("JAVA"); //기존데이터 삭제 새로운 데이터로
		
		
		System.out.println("저장된 데이터 개수 : " + set.size());
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext())
		{
			String str = iter.next();
			System.out.println(str);
			
		}
		
		set.remove("ABCD");
		System.out.println("-----------------------");
		Iterator<String> iter2 = set.iterator();
		while(iter2.hasNext())
		{
			String str2 = iter2.next();
			System.out.println(str2);
		}
		System.out.println("-----------------------");
		set.clear(); //전체 제거
		
		set.add("clear");
		Iterator<String> iter3 = set.iterator();
		while(iter3.hasNext())
		{
			String str2 = iter3.next();
			System.out.println(str2);
		}
		
	}
}
