package dp.string;

import java.util.Arrays;

public class EditDistance {
	public static void main(String[] args) {
		System.out.println(editDistance("sunday", "saturday"));
		System.out.println(findDistance("sunday".toCharArray(), "saturday".toCharArray()));
	}
	
	public static int editDistance(String str1, String str2)
	{
		int n1 = str1.length();
		int n2 = str2.length();
		
		int[][] table = new int[n1+1][n2+1];
		for (int i = 0; i < n1; i++)
		{
			table[i][0] = i;
		}
		for (int j = 0; j < n2; j++)
		{
			table[0][j] = j;
		}
		for (int i = 1; i <= n1; i++)
		{
			for (int j = 1; j <= n2; j++)
			{
				char c1 = str1.charAt(i - 1);
				char c2 = str2.charAt(j - 1);
				if (c1 == c2)
				{
					table[i][j] = table[i - 1][j - 1];
				} else
				{
					table[i][j] = 1 + Math.min(table[i - 1][j - 1], Math.min(table[i - 1][j], table[i][j - 1]));
				}
			}
		}
		for (int i = 0; i < table.length; i++) {
			System.out.println(Arrays.toString(table[i]));
		}
		return table[n1][n2];
	}
	
	private static int findDistance(char[] arr1, char[] arr2)
	{
		int[][] table = new int[arr2.length + 1][arr1.length + 1];
		
		int m = arr2.length;
		int n = arr1.length;
		for (int i = 0; i <= m; i++) 
		{
			for (int j = 0; j <= n; j++)
			{
				if(i == 0)
				{
					table[i][j] = j;
				}
				else if(j == 0)
				{
					table[i][j] = i;
				}
				else
				{
					char c1 = arr2[i-1];
					if(c1 == arr1[j-1])
					{
						table[i][j] = table[i-1][j-1];
					}
					else
					{
						table[i][j] = 1 + Math.min(table[i-1][j-1], Math.min(table[i][j-1], table[i-1][j]));
					}
				}
			}
		}
		
		return table[m][n];
	}
}
