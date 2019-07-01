package dp.string;

/**
 * Longest repeating and non-overlapping substring Given a string str, find the
 * longest repeating non-overlapping substring in it. In other words find 2
 * identical substrings of maximum length which do not overlap. If there exists
 * more than one such substring return any of them.
 * 
 * Examples:
 * 
 * Input : str = "geeksforgeeks" Output : geeks
 * 
 * Input : str = "aab" Output : a
 * 
 * Input : str = "aabaabaaba" Output : aaba
 * 
 * Input : str = "aaaaaaaaaaa" Output : aaaaa
 * 
 * Input : str = "banana" Output : an or na
 * http://www.geeksforgeeks.org/longest-repeating-and-non-overlapping-substring/
 * 
 * @author mbansiwal
 *
 */
public class LongestRepeatingNonOverlappingSubstring
{
	static String longestRepeatedSubstring(char[] str)
	{
		int n = str.length;
		int LCSRe[][] = new int[n + 1][n + 1];

		String result = ""; // To store result
		int resLength = 0; // To store length of result

		// building table in bottom-up manner
		int i, index = 0;
		for (i = 1; i <= n; i++)
		{
			for (int j = i + 1; j <= n; j++)
			{
				// (j-i) > LCSRe[i-1][j-1] to remove
				// overlapping
				if (str[i - 1] == str[j - 1] && LCSRe[i - 1][j - 1] < (j - i))
				{
					LCSRe[i][j] = LCSRe[i - 1][j - 1] + 1;

					// updating maximum length of the
					// substring and updating the finishing
					// index of the suffix
					if (LCSRe[i][j] > resLength)
					{
						resLength = LCSRe[i][j];
						index = Math.max(i, index);
					}
				} else
					LCSRe[i][j] = 0;
			}
		}

		// If we have non-empty result, then insert all
		// characters from first character to last
		// character of string
		if (resLength > 0)
		{
			for (i = index - resLength + 1; i <= index; i++)
			{
				result += str[i - 1];
			}
		}
		System.out.println(new String(str).substring(index - resLength, index));
		return result;
	}

	public static void main(String[] args)
	{
		String str = "geeksforgeeks";
		System.out.println(longestRepeatedSubstring(str.toCharArray()));
	}
}
