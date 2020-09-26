import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateParser {
	public static void main(String[] args) {
		String template = "my tem {{obj1.key1}}, test {{obj1.key1}} :: {{obj1.key2}} and {{obj2.tst1}}";
		
		Pattern pattern = Pattern.compile("([{][{]([A-Za-z0-9.]*)[}][}])");
		
		Map<String, Map<String, String>> valueMap = new HashMap<>();
		Map<String, String> obj1Map = new HashMap<>();
		obj1Map.put("key1", "mytest1");
		obj1Map.put("key2", "mytest2");
		valueMap.put("obj1", obj1Map);
		
		Map<String, String> obj2Map = new HashMap<>();
		obj2Map.put("tst1", "testramd2");
		valueMap.put("obj2", obj2Map);

		Matcher matcher = pattern.matcher(template);
		StringBuffer result = new StringBuffer();
		while(matcher.find()) {
			String key = matcher.group(2);
			String[] keys = key.split("\\.");
			System.out.println(matcher.group(2));
			String replacement = valueMap.get(keys[0]).get(keys[1]);
			matcher.appendReplacement(result, replacement);
		}
		matcher.appendTail(result);
		System.out.println(result.toString());
	}
}
