package google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rearrange-string-k-distance-apart
 * 
 * Given a non-empty string s and an integer k, rearrange the string such that
 * the same characters are at least distance k from each other.
 * 
 * All input strings are given in lowercase letters. If it is not possible to
 * rearrange the string, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: s = "aabbcc", k = 3 Output: "abcabc" Explanation: The same letters are
 * at least distance 3 from each other. Example 2:
 * 
 * Input: s = "aaabc", k = 3 Output: "" Explanation: It is not possible to
 * rearrange the string. Example 3:
 * 
 * Input: s = "aaadbbcc", k = 2 Output: "abacabcd" Explanation: The same letters
 * are at least distance 2 from each other.
 * 
 * @author Administrator
 *
 */

public class ReorganizeStringsKDistance {
	public String reorganizeString(String str, int k) {
		Map<Character, MultiChar> frequency = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (!frequency.containsKey(str.charAt(i))) {
				frequency.put(str.charAt(i), new MultiChar(str.charAt(i), 0));
			}
			frequency.get(str.charAt(i)).count++;
		}

		PriorityQueue<MultiChar> queue = new PriorityQueue<>((o1, o2) -> {
			if (o1.count == o2.count) {
				return o1.letter - o2.letter;
			} else {
				return o2.count - o1.count;
			}
		});

		for (MultiChar multiChar : frequency.values()) {
			queue.add(multiChar);
		}

		Queue<MultiChar> chars = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {

			MultiChar ch = queue.poll();
			ch.count--;
			sb.append(ch.letter);
			chars.add(ch);
			if (chars.size() >= k) {
				MultiChar temp = chars.poll();
				if (temp.count > 0) {
					queue.add(temp);
				}
			}
		}

		return sb.length() != str.length() ? "" : sb.toString();
	}

	public String reorganizeString2(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i=0; i < s.length(); ++i){
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0)+1);
        }
        
        PriorityQueue<MultiChar> queue = new PriorityQueue<>((o1, o2) -> {
			if (o1.count == o2.count) {
				return o1.letter - o2.letter;
			} else {
				return o2.count - o1.count;
			}});
        for(Map.Entry<Character, Integer> c1: countMap.entrySet()){
            queue.add(new MultiChar(c1.getKey(), c1.getValue()));
        }
        
        StringBuilder sb = new StringBuilder("");
        while(queue.size() >= k){
        	for(int i=0; i <k; ++i) {
        		MultiChar c1 = queue.poll();
        		sb.append(c1.letter);
        		c1.count--;
        		if(c1.count > 0){
                    queue.add(c1);
                }
        	}
        }
        while(!queue.isEmpty()){
            sb.append(queue.poll().letter);
        }
        return s.length() == sb.length() ? sb.toString(): "";
	}
	
	public static void main(String[] args) {
		String str = "aabbcc";
//		System.out.println(new ReorganizeStringsKDistance().reorganizeString(str,3));
		System.out.println(new ReorganizeStringsKDistance().reorganizeString("aabbccdd", 3));
		System.out.println(new ReorganizeStringsKDistance().reorganizeString2("aabbccdd", 3));
	}
}
