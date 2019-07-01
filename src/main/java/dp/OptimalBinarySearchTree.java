package dp;

public class OptimalBinarySearchTree
{
	public static void search(int[] input, int[] freq)
	{
		int n = input.length;
		int[][] table = new int[n][n];
		
		for (int i = 0; i < n; i++)
		{
			table[i][i] = freq[i];
		}
		
		for (int l = 2; l <= n; l++)
		{
			for (int i = 0; i < n-l+1; i++)
			{
				int j = i + l - 1;
				int sum = getSum(freq, i, j);
				int minVal =Integer.MAX_VALUE;
				for (int root = i; root <= j; root++)
				{
					int tempMinVal = sum + ((root > i)?table[i][root-1]:0) + ((root < j)?table[root+1][j]:0);
					
					if(tempMinVal< minVal)
					{
						minVal = tempMinVal;
					}
				}
				table[i][j] = minVal;				
			}
		}
		
		System.out.println(table[0][n-1]);
	}
	
	private static int getSum(int[] freq, int i, int j)
	{
		int sum = 0;
		for (int j2 = i; j2 <= j; j2++)
		{
			sum+= freq[j2];
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		int keys[] = {10, 12, 20};
	    int freq[] = {34, 8, 50};
	    search(keys, freq);
	}
}
