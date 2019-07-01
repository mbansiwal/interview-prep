package dp.string;

public class LongestCommonSubString {
	public static void main(String args[]) {
		char arr1[] = {'a',	'b',	'c',	'd',	'a',	'f'};
		char arr2[] = {'z',	'b',	'c',	'd',	'f'};
		
		int ls[][] = find(arr1, arr2);
		for (int i = 0; i < ls.length; i++) {
			for (int is1 : ls[i]) {
				System.out.print(is1+",");
			}
			System.out.println();
		}
		
		System.out.println(ls[arr2.length][arr1.length]);
	}
	
	private static int[][] mySolution(char[] arr1, char[] arr2)
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
					ls[i][j] = 0;
				}
			}
		}
		
		return ls;
	}
	
	private static int[][] find(char[] arr1, char[] arr2)
	{
		int[][] T = new int[arr2.length+1][arr1.length+1];
		for (int i = 1; i <= arr2.length; i++) 
		{
			char c1 = arr2[i-1];
			for (int j = 1; j <= arr1.length; j++) 
			{
				if(c1  == arr1[j-1])
				{
					T[i][j] = T[i-1][j-1]+1;
				}
				else
				{
					T[i][j] = 0;
				}
			}
		}
		return T;
	}
}
