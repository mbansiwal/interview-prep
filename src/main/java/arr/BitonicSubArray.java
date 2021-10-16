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
	
	public static int findBitonic(int[] arr)
	{ 
		//https://www.geeksforgeeks.org/maximum-length-bitonic-subarray-set-2-time-o1-space/
		int j=0;
		int start = 0;
		int n = arr.length;
		int nextStart = 0;
		int result = 1;
		while(j < n-1) {
			while(j < n - 1 && arr[j] <= arr[j+1]) {
				j++;
			}
			
			while(j < n - 1 && arr[j] >= arr[j+1]) {
				if(j < n -1 && arr[j] > arr[j+1]) {
					nextStart = j+1;
				}
				j++;
			}
			result = Math.max(result, j - (start-1));
			
			start = nextStart;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {12, 4, 78, 90, 45, 23};
		System.out.println(findMax(arr));
		System.out.println(findBitonic(arr));

		int arr2[] = {2,1,4,7,3,2,5};
		System.out.println(findMax(arr2));
		System.out.println(findBitonic(arr2));
		
		int arr3[] = {2,28,84,14,89,16,27,17,41,8,42,38,52,35,66,30,11,18,53,9,73,59,59,17,93,82,20};
		System.out.println(findMax(arr3));
		System.out.println(findBitonic(arr3));
	}
}
