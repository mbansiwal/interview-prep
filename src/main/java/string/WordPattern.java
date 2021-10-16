package string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern
 * 
 * Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", s = "dog dog dog dog"
Output: false

 * @author mbbansiw
 *
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        for(int i=0; i < words.length; ++i){
            String word = words[i];
            char pChar = pattern.charAt(i);
            if(!charMap.containsKey(pChar)){
                if(wordMap.containsKey(word)){
                    return false;
                } else{
                    charMap.put(pChar, word);
                    wordMap.put(word, pChar);
                }
            } else{
                if(!word.equals(charMap.get(pChar))){
                    return false;
                }
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		String pattern = "abba";
		String words = "dog cat cat dog";
		System.out.println(new WordPattern().wordPattern(pattern, words));
	}
}
