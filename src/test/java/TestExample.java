import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class TestExample {
	static class Name{
		int number;
		String name;

		public Name(String name, int number) {
			this.name = name;
			this.number = number;
		}
	}
	
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("Key1", "Value1");
		map.put("Key2", "Value2");
		
		List<Name> list1 = new ArrayList<>();
		list1.add(new Name("name1", 1));
		list1.add(new Name("name2", 2));
		list1.add(new Name("name3", 3));
		List<Name> list2 = new ArrayList<>();
		list2.add(new Name("name1", 3));
		list2.add(new Name("name2", 4));

		int sum = list1.stream().reduce(0, (a,b) -> a + b.number, Integer::sum);
		System.out.println(sum);
		int sum2 =  Stream.of(list1, list2).flatMap(x -> x.stream()).reduce(0, (a,b)-> a + b.number, Integer::sum);
		System.out.println(sum2);
	}
}
