package google;

import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 * 
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

 * @author Administrator
 *
 */
public class BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
        
    }
    
    private String build(String S){
        Stack<Character> stack = new Stack<>();
        for(Character ch: S.toCharArray()){
            if(ch != '#'){
                stack.add(ch);
            } else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        return String.valueOf(stack);
    }
}
