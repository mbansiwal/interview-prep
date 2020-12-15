package string;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code". Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * @author mbbansiw
 *
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordList) {
		int n = s.length();
		boolean[] table = new boolean[n + 1];
		table[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				String word = s.substring(j, i);
				if (table[j] && wordList.contains(word)) {
					table[i] = true;
					break;
				}
			}
		}
		return table[n];
	}
	
	public boolean wordBreak2(String s, List<String> wordList) {
		int n = s.length();
		boolean[] table = new boolean[n+1];
		table[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				String temp = s.substring(j, i);
				if(table[j] && wordList.contains(temp)) {
					table[i] = true;
				}
			}
		}
		return table[n];
	}
	

	public static void main(String[] args) {
		String str = "leetcode";
		List<String> wordDict = Arrays.asList("leet", "code");
		System.out.println(new WordBreak().wordBreak(str, wordDict));
		System.out.println(new WordBreak().wordBreak2(str, wordDict));
	}
}
