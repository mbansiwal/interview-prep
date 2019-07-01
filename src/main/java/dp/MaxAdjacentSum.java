package dp;

public class MaxAdjacentSum {
	public static void main(String[] args) {
		System.out.println(getTable(4,	1,	1,	4,	2,	1));
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
