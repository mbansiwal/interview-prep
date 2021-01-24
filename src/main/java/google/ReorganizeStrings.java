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
	public String reorganizeString(String str) {
		Map<Character, MultiChar> frequency = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if(!frequency.containsKey(str.charAt(i))) {
				frequency.put(str.charAt(i), new MultiChar(str.charAt(i), 0));
			}
			frequency.get(str.charAt(i)).count++;
		}
		
		PriorityQueue<MultiChar> queue = new PriorityQueue<>((o1, o2)-> {
			if(o1.letter == o2.letter) {
				return o1.letter - o2.letter;
			}else {
				return o2.count - o1.count;
			}
		});
		
		int limit = (str.length() + 1)/2;
		for (MultiChar multiChar : frequency.values()) {
			if(multiChar.count > limit) {
				return "";
			}
			queue.add(multiChar);
		}
		
		StringBuilder sb = new StringBuilder();
		while(queue.size() >=2) {
            MultiChar ch1 = queue.poll();
            MultiChar ch2 = queue.poll();
            ch1.count--;
            ch2.count--;
			sb.append(ch1.letter);
			sb.append(ch2.letter);
            if(ch1.count > 0){
                queue.add(ch1);
            }
            if(ch2.count > 0){
                queue.add(ch2);
            }
		}
		
		if(!queue.isEmpty()) {
			sb.append(queue.poll().letter);
		}
		return sb.toString();
	}
}
