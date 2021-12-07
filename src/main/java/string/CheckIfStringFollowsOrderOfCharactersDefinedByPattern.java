package string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/check-if-string-follows-order-of-characters-defined-by-a-pattern-or-not-set-3/
 * 
 * Verify whether a long text is following the order rule defined in order
 * string. For example the order string is "abcd", which means "a" can't appear
 * at any position after "b", "c" and "d" in the text, "b" can't appear at any
 * position after "c" and "d" in the text and "c" can't appear at any position
 * after "d" in the text. if the text is "axubbxcxbxd", then the text didn't
 * follow the rule, since "b" appears after "c" in substring "cxb".
 * 
 * The character in order and text string is 8-bit ASCII. And there won't be
 * repeating characters.
 * 
 * 
 * boolean isCorrectOrder(String text, String orderText)
 * 
 */
public class CheckIfStringFollowsOrderOfCharactersDefinedByPattern {
	static boolean isCorrectOrder(String text, String orderText)
	{
		if(orderText == null || orderText.length() == 0 || text == null ||  text.length() == 0) {
			return true;
		}
		
		char[] orderArr = orderText.toCharArray();
		char[] textArr = text.toCharArray();
		
		Map<Character, Integer> orderSet = new HashMap<>();
		
		for (int index = 0; index < orderArr.length; index++) {
			orderSet.put(orderArr[index], index);
		}
		
		int prevOrderIndex = 0; 
		int orderIndex = 0;
		for (int i = 0; i < textArr.length; i++) {
			if(orderSet.containsKey(textArr[i])) {
				prevOrderIndex = orderIndex;
				orderIndex = orderSet.get(textArr[i]);
				
				if(orderIndex < prevOrderIndex) {
					return false;
				}
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		 System.out.println(isCorrectOrder("axubbxcxbxd", "abcd"));
		 System.out.println(isCorrectOrder("bbxcxd", "abcd"));
		 System.out.println(isCorrectOrder("bd", "abcd"));
		 System.out.println(isCorrectOrder("xxxx", "abcd"));
	}
}
