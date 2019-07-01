package dp.coins;

import java.util.Arrays;

public class MinimumCoins {
	public static void main(String[] args) {
		printMinimumCoinsAndTheSelectedCoins(11, 1,5,6,8);
		int[][] table = getTable(11, 1,5,6,8);
		for (int[] is : table) {
			for (int i : is) {
				System.out.print(i+",");
			}
			System.out.println();
		}
		System.out.println(MinimumCoins.findMinimum(11, 1, 5, 6, 8));
	}
	
	private static int[][] getTable(int n, int... coin)
	{
		int table[][] = new int[coin.length+1][n+1];
		for (int j = 0; j <= n; j++) {
			table[0][j]=j;
		}
		
		int tableRows = coin.length + 1;
		
		for (int row = 1; row < tableRows; row++) {
			int coinValue = coin[row-1];
			for (int column = 1; column <= n; column++) {
				if (coinValue > column)
				{
					table[row][column]=table[row-1][column];
				}
				else
				{
					table[row][column]=Math.min(table[row-1][column],1+table[row][column-coinValue]);
				}
			}
		}
		return table;
	}
	
	private static int findMinimum(int n, int... coin)
	{
		int table[] = new int[n + 1];
		Arrays.fill(table, Integer.MAX_VALUE);
		table[0] = 0;
		int tableRows = coin.length + 1;

		for (int row = 1; row < tableRows; row++)
		{
			int coinValue = coin[row - 1];
			for (int column = coinValue; column <= n; column++)
			{
				table[column] = Math.min(table[column], 1 + table[column - coinValue]);
			}
		}
		return table[n];
	}

	public static void printMinimumCoinsAndTheSelectedCoins(int sum, int... coins)
	{
		int[] dynamicTable = new int[sum+1];
		Arrays.fill(dynamicTable, Integer.MAX_VALUE-1);
		dynamicTable[0] = 0;
		int[] selectedCoins = new int[sum+1];
		for (int row = 0; row < coins.length; row++) 
		{
			for (int column = 1; column <= sum; column++) 
			{
				if(column >= coins[row])
				{
					int totalCoinsInclCurrentCoin = 1 + dynamicTable[column-coins[row]];
					if(totalCoinsInclCurrentCoin < dynamicTable[column])
					{
						dynamicTable[column] = totalCoinsInclCurrentCoin;
						selectedCoins[column] = row;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(dynamicTable));
		System.out.println("Coins");
		while(sum > 0)
		{
			int coin = coins[selectedCoins[sum]];
			System.out.print(coin+",");
			sum-= coin;
		}
		System.out.println();
	}
}
