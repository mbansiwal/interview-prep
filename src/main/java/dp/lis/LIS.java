package dp.lis;

import java.util.Arrays;

public class LIS {
	/*
	 * lis() returns the length of the longest increasing subsequence in arr[]
	 * of size n
	 */
	static int lis(int arr[], int n) {
		int lis[] = new int[n];
		int i, j, max = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++)
		{
			lis[i] = 1;
		}

		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < n; i++)
		{	
			for (j = 0; j < i; j++)
			{	if (arr[i] > arr[j])
				{
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}
		return Arrays.stream(lis).max().getAsInt();
	}

	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60,80 };
//		int arr[] = {3,	4,	-1,	0,	6,	2,	3};
//		int arr[] = {0,1,1,2};
		int n = arr.length;
//		System.out.println("Length of lis is " + mySolution(arr) + "\n");
		int ls[] = mySolution(arr);
		for (int i = 0; i < ls.length; i++) {
			System.out.print(ls[i]+",");
		}
		int max = 1;
		/* Pick maximum of all LIS values */
		for (int i = 0; i < n; i++)
		{	
			if (max < ls[i])
			{
				max = ls[i];
			}
		}
		System.out.println("\n"+max);
		
		System.out.println("mySol "+ mySol(arr));
		
		Pair[] pairs = {new Pair(5, 24), new Pair(15, 25), new Pair(27, 40), new Pair(50, 60)};
		System.out.println(lisOfPairs(pairs));
	}
	
	private static int[] mySolution(int[] arr)
	{
		int[] ls = new int[arr.length];
		Arrays.fill(ls, 1);
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j])
				{
					ls[i] = Math.max(ls[i], ls[j]+1);
				}
			}
		}
		
		return ls;
	}
	
	private static int mySol(int[] arr)
	{
		int[] T = new int[arr.length];
		Arrays.fill(T, 1);
		
		for (int i = 0; i < T.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j])
				{
					T[i] = Math.max(T[i], T[j] + 1);
				}
			}
		}
		return findMax(T);
		
	}

	private static int findMax(int[] T)
	{
		int maxVal = T[0];
		for (int i = 1; i < T.length; i++) {
			if(T[i]>maxVal)
			{
				maxVal = T[i];
			}
		}
		return maxVal;
	}
	

	static class Pair
	{
		int a;
		int b;
		
		public Pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		public int getA() {
			return a;
		}
		public int getB() {
			return b;
		}
		
	}

	private static int lisOfPairs(Pair[] pairs)
	{
		int n = pairs.length;
		int[] table = new int[n];
		Arrays.fill(table, 1);
		 for (int i = 1; i < n; i++) 
		 {
			 Pair pair = pairs[i];
			for (int j = 0; j < i; j++) 
			{
				if(pair.a > pairs[j].b)
				{
					table[i] = Math.max(table[i], table[j] +1);
				}
			}
		 }
		 return findMax(table);
	}
}
