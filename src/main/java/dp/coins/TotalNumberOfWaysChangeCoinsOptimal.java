package dp.coins;

public class TotalNumberOfWaysChangeCoinsOptimal {
	public static void main(String[] args) {
		System.out.println(count(4, 1, 2, 3));

		int[] nums =
		{
				1, 2, 3
		};
		System.out.println(new TotalNumberOfWaysChangeCoinsOptimal()
				.combinationSum4WithCoinChangeWhenDuplicateComboAllowed(nums, 4));
		System.out.println(new TotalNumberOfWaysChangeCoinsOptimal()
				.combinationSum4WithCoinChangeWhenDuplicateComboAllowedPractice(nums, 4));
	}
	
	private static long[] getTable(int totalCoinValue, int... coin)
	{
		long[] table = new long[totalCoinValue+1];
		table[0] = 1;
		for (int rows=0; rows<coin.length; rows++)
		{
			for (int column=coin[rows]; column<=totalCoinValue; column++)
			{
				table[column] += table[column-coin[rows]];
			}
		}
            return table;    
	}
	
	private static int count(int n, int... coins)
	{
	    // table[i] will store count of solutions for
	    // value i.
	    int[] table = new int[n+1];
	 
	    // Base case (If given value is 0)
	    table[0] = 1;
	 
	    // One by one consider given 3 moves and update the table[]
	    // values after the index greater than or equal to the
	    // value of the picked move
	    for (int i = 0; i < coins.length; i++) 
	    {
	    	int coin = coins[i];
	    	for (int j=coin; j<=n; j++)
		    {
				table[j] += table[j - coin];
		    }
		}
	 
	    return table[n];
	}

	public int combinationSum4WithCoinChangeWhenDuplicateComboAllowedPractice(int[] nums, int target)
	{
		int[] table = new int[target+1];
		table[0] = 1;
		for(int i = 1; i <= target; ++i){
			for(int j = 0; j < nums.length; ++j){
				int coinValue = nums[j];
				if(i >= coinValue){
					table[i] += table[i - coinValue];
				}
			}
		}
		return table[target];
	}

	public int combinationSum4WithCoinChangeWhenDuplicateComboAllowed(int[] nums, int target)
	{
		int[] comb = new int[target + 1];
		comb[0] = 1;
		for (int i = 1; i <= target; i++)
		{
			for (int j = 0; j < nums.length; j++)
			{
				int coinValue = nums[j];
				if (i - coinValue >= 0)
				{
					comb[i] += comb[i - coinValue];
				}
			}
		}
		return comb[target];
	}

}
