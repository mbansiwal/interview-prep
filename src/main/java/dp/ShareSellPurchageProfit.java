package dp;

public class ShareSellPurchageProfit 
{
	static int maxProfit(int[] prices)
	{
		int n = prices.length;
		int[] profit = new int[n];
		
		int maxPrice = prices[n-1];
		for (int i = n-2; i >=0; --i) 
		{
			maxPrice = Math.max(prices[i], maxPrice);
			profit[i] = Math.max(profit[i+1], maxPrice - prices[i]);
		}
		
		int minPrice = prices[0];
		for (int i = 1; i <n; ++i) 
		{
			minPrice = Math.min(prices[i], minPrice);
			profit[i] = Math.max(profit[i-1], prices[i]-minPrice+profit[i]);
		}
		
		return profit[n-1];
	}
	
	public int maxProfitWithCoolDown(int[] prices)
	{
		int n = prices.length;
		if (n < 2)
			return 0;

		int has1DoNothing = -prices[0];
		int has1Sell = 0;
		int has0DoNothing = 0;
		int has0buy = -prices[0];
		for (int i = 1; i < n; i++)
		{
			has1DoNothing = Math.max(has1DoNothing, has0buy);
			has0buy = has0DoNothing - prices[i];

			has0DoNothing = Math.max(has0DoNothing, has1Sell);
			has1Sell = has1DoNothing + prices[i];
		}
		return Math.max(has1Sell, has0DoNothing);
	}

	public static void main(String[] args) {
		int price[] = {2, 30, 15, 10, 8, 25, 80};
        System.out.println("Maximum Profit = "+ maxProfit(price));
        
        int price2[] = {10, 22, 5, 75, 65, 80};
        System.out.println("Maximum Profit = "+ maxProfit(price2));
        maxProfit(price,2);
        maxProfit(price2,2);

		int prices[] =
		{
				2, 5, 7, 1, 4, 3, 1, 3
		};
		System.out.println(maxProfitOptimal(prices, 3));
		System.out.println(maxProfitOptimal(price2, 2));
	}
	
	
	static void maxProfit(int[] price, int k)
	{
		int n = price.length;
		int[][] T = new int[k+1][n+1];
		
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 1; i <= k; i++) 
		{
			for (int j = 1; j <= n; j++) 
			{
				maxProfit = Math.max(T[i-1][j]-price[j-1], maxProfit);
				T[i][j] = Math.max(T[i][j-1], maxProfit+price[j-1]);
			}
		}
		
		System.out.println(T[k][n]);
	}

	public static int maxProfitOptimal(int prices[], int k)
	{
		int n = prices.length;
		int[][] table = new int[k + 1][n];
		for (int i = 1; i <= k; i++)
		{
			int maxDiff = -prices[0];
			for (int j = 1; j < n; j++)
			{
				table[i][j] = Math.max(table[i][j - 1], maxDiff + prices[j]);
				maxDiff = Math.max(maxDiff, table[i - 1][j] - prices[j]);
			}
		}

		return table[k][n - 1];
	}
}
