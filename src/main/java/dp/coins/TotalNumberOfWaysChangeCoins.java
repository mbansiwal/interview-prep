package dp.coins;

public class TotalNumberOfWaysChangeCoins {
	public static void main(String[] args) {
		int[] coins =
		{
				1, 2
		};
		int[][] table = getTable(4, coins);
//		int[][] table = getTable(5, 1,2,3);
		for (int[] is : table) {
			for (int i : is) {
				System.out.print(i+",");
			}
			System.out.println();
		}
		System.out.println(table[2][4]);
	}
	
	private static int[][] getTable(int totalCoinValue, int... coin)
	{
		int T[][] = new int[coin.length+1][totalCoinValue+1];
		int tableRows = coin.length + 1;
		T[0][0] = 1;
//		for (int i = 0; i < tableRows; i++)
//		{
//				T[i][0]=1;
//		}
		
		for (int row = 1; row < tableRows; row++) {
			for (int column = 0; column <= totalCoinValue; column++) {
				int coinValue = coin[row-1];
				if (coinValue > column)
				{
					T[row][column]=T[row-1][column];
				}
				else 
				{
				 T[row][column]=T[row-1][column]+T[row][column-coinValue];
				} 
			}
		}
		return T;
	}
}
