package dp;

public class SubSetSum {
	public static void main(String[] args) {
//		print(getTable(11, 2,3,7,8,10));
		print(getTable2(11, 2,3,7,8,10));
	}
	
	private static void print(boolean[][] table)
	{
		for (boolean[] is : table) 
		{
			for (boolean i : is) 
			{
				System.out.print(i+",");
			}
			System.out.println();
		}
 		System.out.println();
 		System.out.println();
 		System.out.println();
 		System.out.println();
	}
	
	private static boolean[][] getTable(int sum, int... input )
	{
		int tableRows = input.length + 1;
		boolean table[][] = new boolean[tableRows][sum+1];
		
		for (int i = 0; i < tableRows; i++) {
			table[i][0]=true;
		}
		
		for (int row = 1; row < tableRows; row++) 
		{
			for (int column = 1; column <= sum; column++) 
			{
				if (input[row-1] > column)
				{
					table[row][column]=table[row-1][column];
				}
				else
				{
					table[row][column]=table[row-1][column]||table[row-1][column-input[row-1]];
				}
			}
		}
		return table;
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
	
	public static boolean isSumExist(int sum, int... input )
	{
		return getTable2(sum, input)[input.length][sum];
	}

	private static int numberOfSubSetSums(int sum, int m, int... input)
	{
		int n = input.length;
		int table[][] = new int[n + 1][sum + 1];
		for (int i = 1; i < n; i++)
		{
			table[i][0]++;
		}
		for (int i = 1; i <= n; i++)
		{
			table[i][input[i - 1]]++;
			for (int j = 1; j <= sum; j++)
			{
				if (table[i - 1][j] > 0)
				{
					table[i][j]++;
					table[i][j + input[i - 1]]++;
				}
			}
		}

		int count = 0;
		for (int j = 1; j <= sum; j++)
		{
			if (table[n][j] > 0)
			{
				if (table[n][j] % m == 0)
				{
					count += table[n][j];
				}
			}

		}
		return count;
	}
}
