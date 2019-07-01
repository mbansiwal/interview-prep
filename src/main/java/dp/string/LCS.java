package dp.string;

import java.util.Arrays;

public class LCS {
	public static void main(String args[]) {
		char arr1[] = {'a',	'b',	'c',	'd',	'e',	'f'};
		char arr2[] = {'a',	'c',	'b',	'c',	'f'};
		
		mySolution(arr1, arr2);
		findLcsSpaceOptimized(arr1, arr2);
		
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		mySolution(X.toCharArray(), Y.toCharArray());
		findLcsSpaceOptimized(X.toCharArray(), Y.toCharArray());
		findLcsSpaceOpt(X.toCharArray(), Y.toCharArray());
		
	}
	
	private static void mySolution(char[] arr1, char[] arr2)
	{
		int[][] ls = new int[arr2.length+1][arr1.length+1];
		for (int i = 1; i <= arr2.length; i++) 
		{
			char c = arr2[i-1];
			for (int j = 1; j <= arr1.length; j++) 
			{
				if(c == arr1[j-1])
				{
					ls[i][j] = ls[i-1][j-1]+1;
				}
				else
				{
					ls[i][j] = Math.max(ls[i][j-1], ls[i-1][j]);
				}
			}
		}
		System.out.println(ls[arr2.length][arr1.length]);
	}
	
	private static void findLcsSpaceOptimized(char[] arr1, char[] arr2)
	{
		int n = arr2.length;
		int[][] T = new int[2][n+1];
		
		int currentRow = 0;
		for (int i = 1; i <= arr1.length; i++) 
		{
			for (int j = 1; j <= n; j++) 
			{
				if(arr1[i-1] == arr2[j-1])
				{
					T[currentRow][j] = T[1 - currentRow][j-1] + 1;
				}
				else
				{
					T[currentRow][j] = Math.max(T[currentRow][j-1], T[1 - currentRow][j]);
				}
			}
			currentRow = currentRow==0?1:0;
		}
		System.out.println(Arrays.toString(T[currentRow==0?1:0]));
	}
	
	private static int findLcsSpaceOpt(char[] arr1, char[] arr2)
	{
		int[] T = new int[arr2.length+1];
		
		for (int i = 0; i < arr1.length; i++) 
		{
			for (int j = 1; j <= arr2.length; j++) 
			{
				if(arr1[i] == arr2[j-1])
				{
					T[j] = T[j-1] + 1;
				}
				else
				{
					T[j] = Math.max(T[j-1], T[j]);
				}
			}
		}
		System.out.println(Arrays.toString(T));
		return T[arr2.length];
	}
}
