package dp.palindrom;

/**
 * https://leetcode.com/problems/palindrome-partitioning-iv/
 * Given a string s, return true if it is possible to split the string s into three non-empty palindromic substrings. Otherwise, return false.​​​​​

A string is said to be palindrome if it the same string when reversed.

 

Example 1:

Input: s = "abcbdd"
Output: true
Explanation: "abcbdd" = "a" + "bcb" + "dd", and all three substrings are palindromes.
Example 2:

Input: s = "bcbddxy"
Output: false
Explanation: s cannot be split into 3 palindromes.
 * @author Administrator
 *
 */
public class PalindromePartitioningIV {
	public boolean checkPartitioning(String s) {
		int n = s.length();
		if(n == 3) {
			return true;
		}
		boolean[][] table = new boolean[n][n];
		for(int i=0; i < n; ++i) {
			table[i][i] = true;
		}
		
		char[] str = s.toCharArray();
		for(int i=0; i < n-1; ++i) {
			table[i][i+1] = str[i] == str[i+1];
		}
		
		for(int l=2; l <= n; ++l) {
			for (int i = 0; i < n-l+1; i++) {
				int j = i + l -1;
				if(table[i+1][j-1] && str[i] == str[j])
				{
					table[i][j] = true;
				}
			}
		}
		
		for (int i = 1; i < n-1; i++) {
			for (int j = i; j < n-1; j++) {
				if(table[0][i-1] && table[i][j] && table[j+1][n-1]) {
					return true;
				}
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		
	}
}
