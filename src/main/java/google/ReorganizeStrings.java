package google;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/
 * 
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].

 * @author Administrator
 *
 */
class MultiChar {
    int count;
    char letter;
    MultiChar(char ch, int ct) {
        count = ct;
        letter = ch;
    }
}

public class ReorganizeStrings {
	public String reorganizeString(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i=0; i < s.length(); ++i){
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0)+1);
        }
        
        PriorityQueue<MultiChar> queue = new PriorityQueue<>((c1, c2) -> c2.count - c1.count);
        int limit = (s.length() + 1)/2;
        for(Map.Entry<Character, Integer> c1: countMap.entrySet()){
            if(c1.getValue() > limit){
                return "";
            }
            queue.add(new MultiChar(c1.getKey(), c1.getValue()));
        }
        
        StringBuilder sb = new StringBuilder("");
        while(queue.size() >= 2){
        	MultiChar c1 = queue.poll();
            MultiChar c2 = queue.poll();
            c1.count--;
            c2.count--;
            sb.append(c1.letter);
            sb.append(c2.letter);
            if(c1.count > 0){
                queue.add(c1);
            }
            if(c2.count > 0){
                queue.add(c2);
            }
        }
        if(!queue.isEmpty()){
            sb.append(queue.poll().letter);
        }
        return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new ReorganizeStrings().reorganizeString("abb"));
	}
}
