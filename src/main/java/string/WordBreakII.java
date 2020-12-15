package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-break-ii/
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * 
 * Input: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output: [ "cats and dog", "cat sand dog" ] Example 2:
 * 
 * Input: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen",
 * "pine", "pineapple"] Output: [ "pine apple pen apple", "pineapple pen apple",
 * "pine applepen apple" ] Explanation: Note that you are allowed to reuse a
 * dictionary word. Example 3:
 * 
 * Input: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: []
 * 
 * 
 * @author mbbansiw
 *
 */
public class WordBreakII {
	public List<String> wordBreak(String s, List<String> wordDict) {
		Integer max = 0;
		for (String word : wordDict) {
			max = Math.max(max, word.length());
		}
		return wordBreak(s, wordDict, 0, max, new HashMap<>());
	}

	public List<String> wordBreak(String s, List<String> wordDict, int start, int max, Map<Integer, List<String>> dp) {
		if (start == s.length()) {
			return Collections.singletonList("");
		}

		if (dp.containsKey(start)) {
			return dp.get(start);
		}
		List<String> words = new ArrayList<>();
		for (int i = start; i < s.length() && i < start + max; ++i) {
			String newWord = s.substring(start, i + 1);
			if (!wordDict.contains(newWord)) {
				continue;
			}
			List<String> childWords = wordBreak(s, wordDict, i + 1, max, dp);
			for (String word : childWords) {
				String space = word.length() > 0 ? " " : "";
				words.add(newWord + space + word);
			}
		}
		dp.put(start, words);
		return words;
	}

	public static void main(String[] args) {
		String str = "catsanddog";
		List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");

		System.out.println(new WordBreakII().wordBreak(str, dict));
	}
}
