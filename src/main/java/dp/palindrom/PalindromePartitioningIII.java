package dp.palindrom;

/**
 * https://leetcode.com/problems/palindrome-partitioning-iii/
 * 
 * You are given a string s containing lowercase letters and an integer k. You need to :

First, change some characters of s to other lowercase English letters.
Then divide s into k non-empty disjoint substrings such that each substring is a palindrome.
Return the minimal number of characters that you need to change to divide the string.

 

Example 1:

Input: s = "abc", k = 2
Output: 1
Explanation: You can split the string into "ab" and "c", and change 1 character in "ab" to make it palindrome.
Example 2:

Input: s = "aabbc", k = 3
Output: 0
Explanation: You can split the string into "aa", "bb" and "c", all of them are palindrome.
Example 3:

Input: s = "leetcode", k = 8
Output: 0

 * @author Administrator
 *
 */
//Not a right answer failing for some use cases
public class PalindromePartitioningIII {
	public int palindromePartition(String s, int k) {
        int n = s.length();
        if(k >= n){
            return 0;
        }
        
        int[][] table = new int[n][n];
        char[] str = s.toCharArray();
        for(int l=2; l <= n; ++l){
            for(int i=0; i < n - l + 1; ++i){
                int j = i + l -1;
                if(isPalindrome(str, i , j)){
                    table[i][j] = 0;
                } else{
                    int min = Integer.MAX_VALUE;
                    for(int m=i; m < j; ++m){
                        min = Math.min(min, table[i][m]+table[m+1][j]);
                    }
                    
                    table[i][j] = 1 + min;
                }
            }
        }
        System.out.println(table[0][k-1]);
        int partitions = table[0][n-1] > 0 ? table[0][n-1]+1:0;
        return partitions >= k?partitions-k:0;
    }
    
    private boolean isPalindrome(char[] str, int start, int end){
        while(start < end){
            if(str[start] != str[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
	public static void main(String[] args) {
		System.out.println(new PalindromePartitioningIII().palindromePartition("abc", 2));
		System.out.println(new PalindromePartitioningIII().palindromePartition("aabbc", 3));
		System.out.println(new PalindromePartitioningIII().palindromePartition("leetcode", 8));
		System.out.println(new PalindromePartitioningIII().palindromePartition("tcymekt", 4));
	}
}
