package dp;

public class CountWaysToReachAScore
{
	public static void findPaths(int[] arr, int totalScore)
	{
		int[] table = new int[totalScore+1];
		table[0] = 1;
		for (int i = 0; i < arr.length; i++)
		{
			int score = arr[i];
			for (int j = score; j <=totalScore; j++)
			{
				table[j] +=  table[j - score];
			}
		}
		
		System.out.println(table[totalScore]);
	}
	
	public static void main(String[] args)
	{
		int[] arr = {3, 5, 10};
		int totalScore = 20;
		findPaths(arr, totalScore);
	}
}
