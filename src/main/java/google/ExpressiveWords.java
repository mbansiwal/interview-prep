package google;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/expressive-words/
 * 
 * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy. 

 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 

Constraints:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters

 * @author Administrator
 *
 */
class RunLengthEncoding{
	private String key;
	private List<Integer> counts;
	public RunLengthEncoding(String str) {
		counts = new ArrayList<>();
		char[] arr = str.toCharArray();
		int prev = -1;
		StringBuilder sb = new StringBuilder();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if(i == n-1 || arr[i] != arr[i+1]) {
				sb.append(arr[i]);
				counts.add(i-prev);
				prev = i;
			}
		}
		key = sb.toString();
	}
	public String getKey() {
		return key;
	}
	
	public Integer getCount(int i) {
		return counts.get(i);
	}
	
    public int size(){
        return counts.size();
    }
}

public class ExpressiveWords {
	public int expressiveWords(String str, String[] words) {
		RunLengthEncoding keyRunLengthEncoding = new RunLengthEncoding(str);
		int ans = 0;
		for (String word : words) {
			if(checkIfMatch(keyRunLengthEncoding, word)) {
				ans++;
			}
		}
		return ans;
    }
	
	private boolean checkIfMatch(RunLengthEncoding keyRLE, String word) {
		RunLengthEncoding wordRLE = new RunLengthEncoding(word);
		if(!keyRLE.getKey().equals(wordRLE.getKey())) {
			return false;
		}
		
		for (int i = 0; i < wordRLE.size(); i++) {
			int c1 = keyRLE.getCount(i);
            int c2 = wordRLE.getCount(i);
			if((c1 < 3 && c1 != c2) || (c1 < c2)) {
				return false;
			}
		}
		return true;
	}
}
