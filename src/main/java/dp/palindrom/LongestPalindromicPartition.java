package dp.palindrom;

/**
 * 
 * @author Administrator
 *
 */
public class LongestPalindromicPartition
{

	public static boolean checkPalendrom(char[] str, int i, int j)
	{
		while (i < j)
		{
			if (str[i] != str[j])
			{
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static int findIntersection(char[] str)
	{
		int n = str.length;
		int[][] table = new int[n][n];
		for (int l = 2; l <= n; l++)
		{
			for (int i = 0; i < n - l + 1; i++)
			{
				int j = i + l - 1;
				if (checkPalendrom(str, i, j))
				{
					table[i][j] = 0;
				}
				else
				{
					int min = Integer.MAX_VALUE;
					for (int k = i; k < j; k++)
					{
						min = Math.min(min, table[i][k] + table[k + 1][j]);
					}
					table[i][j] = 1 + min;
				}
			}
		}
		return table[0][n - 1];
	}

	static int calculate(char[] arr)
	{
		int n = arr.length;
		int[][] T = new int[n][n];

		for (int l = 2; l <= n; l++)
		{
			for (int i = 0; i < n - l + 1; i++)
			{
				int j = i + l - 1;
				if (isPalindrom(arr, i, j))
				{
					T[i][j] = 0;
				} else
				{
					T[i][j] = Math.min(T[i][j - 1], T[i + 1][j]) + 1;
				}
			}
		}

//		for (int i = 0; i < T.length; i++)
//		{
//			System.out.println(Arrays.toString(T[i]));
//		}

		return T[0][n - 1];
	}

	private static boolean isPalindrom(char[] str, int i, int j)
	{
		while (i < j)
		{
			if (str[i] != str[j])
			{
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args)
	{
		LongestPalindromicPartition lps = new LongestPalindromicPartition();
		String str = "abcbm";
		System.out.println(calculate(str.toCharArray()));
		System.out.println(calculate("geeksforgeeks".toCharArray()));
		System.out.println(findIntersection("geeksforgeeks".toCharArray()));
		System.out.println(findIntersection(str.toCharArray()));
		System.out.println(findIntersection("cabababcbc".toCharArray()));
		System.out.println(findIntersection("cdaac".toCharArray()));
		System.out.println(findIntersection("tcymekt".toCharArray()));
		

	}
}
