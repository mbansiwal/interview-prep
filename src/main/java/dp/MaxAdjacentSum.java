package dp;

/**
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 *
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
 *
 * Examples :
 *
 * Input : arr[] = {5, 5, 10, 100, 10, 5}
 * Output : 110
 *
 * Input : arr[] = {1, 2, 3}
 * Output : 4
 *
 * Input : arr[] = {1, 20, 3}
 * Output : 20
 *
 */
public class MaxAdjacentSum {
	public static void main(String[] args) {
		System.out.println(getTable(4,	1,	1,	4,	2,	1));
		System.out.println(getTable(5, 5, 10, 100, 10, 5));
		System.out.println(getTable(1, 2, 3));
		System.out.println(getTable(1, 20, 3));
	}
	
	private static int getTable(int... input )
	{
		int inclusive = input[0];
		int exclude = 0;
		int n = input.length;
		for (int i = 1; i < n; i++) 
		{
			int tempInclusive = inclusive;
			inclusive = Math.max(inclusive, exclude + input[i]);
			exclude = tempInclusive;
		}
		return inclusive;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static boolean[][] getTable2(int sum, int... input )
	{
		int n = input.length;
		boolean[][] table = new boolean[n+1][sum+1];
		
		for (int i = 0; i < n; i++) {
			table[i][0] = true;
		}
		for (int i = 1; i <=n; i++) 
		{
			for (int j = 1; j <= sum; j++) 
			{
				if(input[i-1] > j)
				{
					table[i][j] = table[i-1][j];
				}
				else
				{
					table[i][j] = table[i-1][j] || table[i-1][j-input[i-1]];
				}
			}
		}
		
		return table;
	}
}
