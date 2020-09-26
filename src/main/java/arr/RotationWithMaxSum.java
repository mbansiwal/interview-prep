package arr;

/**
 * https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/
 * */
public class RotationWithMaxSum {
	static int maxSum(int[] arr) 
    {
		int maxVal = 0;
		int currentVal = 0;
		int sum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			currentVal += i*arr[i];
		}
		
		for (int i = 1; i < n; i++) {
			currentVal = sum + currentVal - n*arr[n-i];
			maxVal = Math.max(maxVal, currentVal);
		}
		return maxVal;
    }
	
	public static void main(String[] args) {
		int arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("Max sum is " + maxSum(arr));
		
		int arr2[] = {1, 20, 2, 10};
		System.out.println("Max sum is " + maxSum(arr2));
	}
}
