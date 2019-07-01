package dp;

public class PartitionSubsetIntoTwoWithMinimumDiff 
{
	private static int findMinimumDiff(int[] arr)
	{
		int sum = 0;
		for (int element : arr) 
		{
			sum+=element;
		}
		int n = arr.length;
		boolean[][] table = new boolean[n+1][sum+1];
		for (int i = 0; i < n; i++) 
		{
			table[i][0] = true;
		}
		
		for (int i = 1; i <= n; i++) 
		{
			int element = arr[i-1];
			for (int j = 1; j <= sum; j++) 
			{
				if(j < element)
				{
					table[i][j] = table[i-1][j];
				}
				else
				{
					table[i][j] = table[i-1][j-element] | table[i-1][j];
				}
			}
		}
		
		int diff = Integer.MAX_VALUE;
		for (int j = sum/2; j >=0; j--) 
		{
			if(table[n][j])
			{
				diff = sum - 2*j;
				break;
			}
		}
		return diff;
	}
	public static void main(String[] args) 
	{
		int arr[] = {3, 1, 4, 2, 2, 1};
		System.out.println(findMinimumDiff(arr));
		
		int arr2[] = {1, 6, 11, 5} ;
		System.out.println(findMinimumDiff(arr2));
		
		int arr3[] = {1, 6, 11, 5,1} ;
		System.out.println(findMinimumDiff(arr3));
	}
}
