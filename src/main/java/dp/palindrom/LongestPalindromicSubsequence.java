package dp.palindrom;

import java.util.Arrays;

public class LongestPalindromicSubsequence
{
	static int calculate(char[] arr)
	{
		int n = arr.length;
		int[][] T = new int[n][n];
		for (int i = 0; i < n; i++)
		{
			T[i][i] = 1;
		}

		for (int l = 2; l <= n; l++)
		{
			for (int i = 0; i < n - l + 1; i++)
			{
				int j = i + l - 1;
				if (arr[i] == arr[j])
				{
					T[i][j] = l == 2 ? 2 : T[i + 1][j - 1] + 2;
				} else
				{
					T[i][j] = Math.max(T[i][j - 1], T[i + 1][j]);
				}
			}
		}

		for (int i = 0; i < T.length; i++)
		{
			System.out.println(Arrays.toString(T[i]));
		}

		return T[0][n - 1];
	}

	public static void main(String[] args)
	{
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String str = "agbdba";
		System.out.print(calculate(str.toCharArray()));
	}
}
