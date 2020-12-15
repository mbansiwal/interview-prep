package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-pattern
 * 
 * https://www.programcreek.com/2014/07/leetcode-word-pattern-ii-java/#:~:text=This%20is%20the%20extension%20problem,non%2Dempty%20substring%20in%20str.
 * 
 * The time complexity then is f(n) = n*(n-1)*... *1=n^n.
 *
 * @author mbbansiw
 *
 */
public class WordPatternII {
	public boolean wordPattern(String pattern, String str) {
		return wordPattern(pattern, str, 0, 0, new HashMap<>(), new HashSet<>());
    }
	
	public boolean wordPattern(String pattern, String str, int patternIndex, int strIndex, Map<Character, String> charMap, Set<String> wordSet) {
		if(patternIndex == pattern.length() && strIndex == str.length()) {
			return true;
		}
		
		if(patternIndex >= pattern.length() || strIndex >= str.length()) {
			return false;
		}
		char patternChar = pattern.charAt(patternIndex);
		for (int k = strIndex+1; k <= str.length(); k++) {
			String word = str.substring(strIndex, k);
			if(!charMap.containsKey(patternChar) && !wordSet.contains(word)) {
				charMap.put(patternChar, word);
				wordSet.add(word);
				if(wordPattern(pattern, str, patternIndex+1, k, charMap, wordSet)) {
					return true;
				}
				charMap.remove(patternChar);
				wordSet.remove(word);
			} else if(charMap.containsKey(patternChar) && word.equals(charMap.get(patternChar))){
				if(wordPattern(pattern, str, patternIndex+1, k, charMap, wordSet)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String pattern = "abba";
		String words = "dogcatcatdog";
		System.out.println(new WordPatternII().wordPattern(pattern, words));
	}
}
