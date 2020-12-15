package string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern
 * 
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
