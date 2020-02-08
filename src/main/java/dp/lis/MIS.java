package dp.lis;

import java.util.Arrays;

public class MIS {
	static int mis(int arr[]) {
		int n = arr.length;
		int lis[] = Arrays.copyOf(arr, n);

		/* Compute optimized LIS values in bottom up manner */
		for (int i = 1; i < n; i++)
		{	
			for (int j = 0; j < i; j++)
			{	if (arr[i] > arr[j])
				{
					lis[i] = Math.max(lis[i], lis[j] + arr[i]);
				}
			}
		}

		return Arrays.stream(lis).max().getAsInt();
	}

	public static void main(String args[]) {
		int arr[] = {4,	6,	1,	3,	8,	4,	6};
		System.out.println("\n"+mis(arr));
		
	}
}
