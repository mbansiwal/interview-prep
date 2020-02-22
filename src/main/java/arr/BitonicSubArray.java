package arr;

/**
 * https://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
 */
public class BitonicSubArray 
{
	public static int findMax(int[] arr)
	{
		int n = arr.length;
		int[] increasingElements = new int[n];
		int[] decreasingElements = new int[n];

		if (n > 0)
		{
			increasingElements[0] = 1;
			decreasingElements[n - 1] = 1;
		}
		else
		{
			return 0;
		}

		for (int i = 1; i < n; i++)
		{
			increasingElements[i] = arr[i - 1] < arr[i] ? increasingElements[i - 1] + 1 : 1;
		}
		
		for (int i = n - 2; i >= 0; i--)
		{
			decreasingElements[i] = arr[i + 1] < arr[i] ? decreasingElements[i + 1] + 1 : 1;
		}
		
		int max = 1;
		for (int i = 0; i < n; i++)
		{
			max = Math.max(max, increasingElements[i] + decreasingElements[i] - 1);
		}
		return max;
	}
	public static void main(String[] args) {
		int arr[] = {12, 4, 78, 90, 45, 23};
		System.out.println(findMax(arr));

		int arr2[] = {2,1,4,7,3,2,5};
		System.out.println(findMax(arr2));
	}
}
