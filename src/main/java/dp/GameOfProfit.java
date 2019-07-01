package dp;

public class GameOfProfit 
{
	static class Score
	{
		int first;
		int second;
		public int getFirst() {
			return first;
		}
		public int getSecond() {
			return second;
		}
		public Score(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		@Override
		public String toString() {
			return "first=="+first+", second=="+second;
		}
	}
	
	public static void main(String[] args) 
	{
		int[] arr = {3,	9,	1,	2};
		findScrore(arr);
	}
	
	static Score findScrore(int[] arr)
	{
		int n = arr.length;
		Score[][] table = new Score[n+1][n+1];
		
		for (int len = n; len > 0; len--) 
		{
			for (int row = 1, col=(n-len)+1; col <= n && row <= len; row++, col++) 
			{
				
				if(row == col)
				{
					table[row][col] = new Score(arr[row-1], 0);
					continue;
				}
				
				if(table[row+1][col] == null)
				{
					table[row+1][col] = new Score(0, 0);
				}
				if(table[row][col-1] == null)
				{
					table[row][col-1] = new Score(0, 0);
				}
				
				int bottomValue = table[row+1][col].second+arr[row-1];
				int topValue = table[row][col-1].second+arr[col-1];

				if(bottomValue > topValue)
				{
					int first = bottomValue;
					int second = table[row+1][col].first;
					table[row][col] = new Score(first, second);
				}
				else
				{
					int first  = topValue;
					int second  = table[row][col-1].first;
					table[row][col] = new Score(first, second);
				}
			}
		}
		
		System.out.println(table[1][n]);
		return null;
	}
}
