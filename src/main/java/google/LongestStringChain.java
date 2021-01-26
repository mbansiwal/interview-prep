package google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-string-chain/
 * 
 * Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chain is "a","ba","bda","bdca".
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of English lowercase letters.

 * @author Administrator
 *
 */
public class LongestStringChain {
	public int longestStrChain(String[] words) {
        Arrays.sort(words, (a1, a2) -> a1.length() - a2.length());
        Map<String, Integer> wordCount = new HashMap<>();
        for(int i=0; i < words.length; ++i){
            wordCount.put(words[i], 1);
        }
        int max = 1;
        for(int i=0; i < words.length; ++i){
            String word = words[i];
            if(word.length() > 1){
                int currentMax = 0;
                for(int j=0; j < word.length(); ++j){
                    String partWord = new StringBuilder(word).deleteCharAt(j).toString();
                    if(wordCount.containsKey(partWord)){
                      currentMax = Math.max(currentMax, wordCount.get(partWord));  
                    }
                }
                wordCount.put(word, currentMax + 1);
                max = Math.max(max, wordCount.get(word));
            }
            
            
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
