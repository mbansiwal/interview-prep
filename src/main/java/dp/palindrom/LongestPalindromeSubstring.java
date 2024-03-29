package dp.palindrom;

import java.util.Arrays;

public class LongestPalindromeSubstring {
	void printSubStr( char[] str, int low, int high )
	{
	    for( int i = low; i <= high; ++i )
	     {
	    	System.out.println(str[i]);
	     }
	}
	 
	// This function prints the longest palindrome substring
	// of str[].
	// It also returns the length of the longest palindrome
	static int longestPalSubstr( char[] str )
	{
	    int n = str.length; // get length of input string
	 
	    // table[i][j] will be false if substring str[i..j]
	    // is not palindrome.
	    // Else table[i][j] will be true
	    boolean[][] table = new boolean[n][n];
	 
	    // All substrings of length 1 are palindromes
	    int maxLength = 1;
	    for (int i = 0; i < n; ++i)
	    {
	    	table[i][i] = true;
	    }
	 
	    // check for sub-string of length 2.
	    int start = 0;
	    for (int i = 0; i < n-1; ++i)
	    {
	        if (str[i] == str[i+1])
	        {
	            table[i][i+1] = true;
	            start = i;
	            maxLength = 2;
	        }
	    }
	 
	    // Check for lengths greater than 2. k is length
	    // of substring
	    for (int l = 3; l <= n; ++l)
	    {
	        // Fix the starting index
			for (int i = 0; i < n - l + 1; ++i)
	        {
	            // Get the ending index of substring from
	            // starting index i and length k
	            int j = i + l - 1;
	 
	            // checking for sub-string from ith index to
	            // jth index iff str[i+1] to str[j-1] is a
	            // palindrome
	            if (table[i+1][j-1] && str[i] == str[j])
	            {
	                table[i][j] = true;
	 
	                if (l > maxLength)
	                {
	                    start = i;
	                    maxLength = l;
	                }
	            }
	        }
	    }
	 
	    System.out.println("Longest palindrome substring is: ");
		System.out.println(Arrays.toString(str).substring(start));
//	    printSubStr( str, start, start + maxLength - 1 );
	 
	    return maxLength; // return length of LPS
	}
	 
	// Driver program to test above functions
	public static void main(String[] args) 
	{
		char str1[] = "ccbc".toCharArray();
	    System.out.println("\nLength is: \n"+ longestPalSubstr( str1 ) );
	    
	    char str[] = "forgeeksskeegfor".toCharArray();
	    System.out.println("\nLength is: \n"+ longestPalSubstr( str ) );
	}
}
