package dp;

/**
 * Given a sorted array key [0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, where freq[i] is the number of searches for keys[i]. Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.
Let us first define the cost of a BST. The cost of a BST node is the level of that node multiplied by its frequency. The level of the root is 1.

 * https://www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
 */
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
