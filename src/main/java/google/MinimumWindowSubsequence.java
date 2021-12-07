package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-window-subsequence/
 * 
 * Given strings S and T, find the minimum (contiguous) substring W of S, so
 * that T is a subsequence of W.
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "". If there are multiple such minimum-length windows, return
 * the one with the left-most starting index.
 * 
 * Example 1:
 * 
 * Input: S = "abcdebdde", T = "bde" Output: "bcde" Explanation: "bcde" is the
 * answer because it occurs before "bdde" which has the same length. "deb" is
 * not a smaller window because the elements of T in the window must occur in
 * order.
 * 
 * @author Administrator
 *
 */
public class MinimumWindowSubsequence {
	public String minWindow2Pract(String str, String pattern) {
		int k = pattern.length();
		int j=0;
		int min = Integer.MAX_VALUE;
		String window = "";
		for(int i=0; i < str.length(); ++i) {
			if(str.charAt(i) == pattern.charAt(j)) {
				j++;
				if(j == k) {
					int end = i + 1;
					--j;
					while(j >=0) {
						if(pattern.charAt(j) == str.charAt(i)) {
							--j;
						}
						--i;
					}
					++i;
					++j;
					
					if(end - i < min) {
						min = end - i;
						window = str.substring(i, end);
					}
				}
			}
			
		}
		return window;
	}
	public String minWindow(String str, String pattern) {
		int N = str.length();
		int[] last = new int[26];
		int[][] nxt = new int[N][26];
		Arrays.fill(last, -1);

		for (int i = N - 1; i >= 0; --i) {
			last[str.charAt(i) - 'a'] = i;
			for (int k = 0; k < 26; ++k) {
				nxt[i][k] = last[k];
			}
		}

		List<int[]> windows = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			if (str.charAt(i) == pattern.charAt(0))
				windows.add(new int[] { i, i });
		}
		for (int j = 1; j < pattern.length(); ++j) {
			int letterIndex = pattern.charAt(j) - 'a';
			for (int[] window : windows) {
				if (window[1] < N - 1 && nxt[window[1] + 1][letterIndex] >= 0) {
					window[1] = nxt[window[1] + 1][letterIndex];
				} else {
					window[0] = window[1] = -1;
					break;
				}
			}
		}

		int[] ans = { -1, str.length() };
		for (int[] window : windows) {
			if (window[0] == -1)
				break;
			if (window[1] - window[0] < ans[1] - ans[0]) {
				ans = window;
			}

		}
		return ans[0] >= 0 ? str.substring(ans[0], ans[1] + 1) : "";
	}
	
	 public String minWindow2(String S, String T) {
	        String window = "";
	        int j = 0, min = S.length() + 1;
	        for (int i = 0; i < S.length(); i++) {
	            if (S.charAt(i) == T.charAt(j)) {
	                j++;
	                if (j == T.length()) {
	                    int end = i + 1;
	                    j--;
	                    while (j >= 0) {
	                        if (S.charAt(i) == T.charAt(j)) j--;
	                        i--;
	                    }
	                    j++;
	                    i++;
	                    if (end - i < min) {
	                        min = end - i;
	                        window = S.substring(i, end);
	                    }
	                }
	            }
	        }
	        return window;
	    }
	 
	 public static void main(String[] args) {
		String S = "abcdebdde", T = "bde";
		System.out.println(new MinimumWindowSubsequence().minWindow2(S, T));
		System.out.println(new MinimumWindowSubsequence().minWindow2Pract(S, T));
	}
}
