package arr;

/**
 * https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/
 * */
public class RotationWithMaxSum {
	static int maxSum2(int[] arr) 
    {
		int arrSum = 0;
		int rotatedSum = 0;
		for (int i = 0; i < arr.length; i++) {
			arrSum+=arr[i];
			rotatedSum += i*arr[i];
		}
		int maxSum = arrSum;
		int n = arr.length;
		for (int j = 1; j < arr.length; j++) {
			rotatedSum = rotatedSum + arrSum - n*arr[n-j];
			maxSum = Math.max(rotatedSum, maxSum);
		}
		return maxSum;
    }
	
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
		System.out.println("Max sum is " + maxSum2(arr));
		
		int arr2[] = {1, 20, 2, 10};
		System.out.println("Max sum is " + maxSum(arr2));
		System.out.println("Max sum is " + maxSum2(arr2));
	}
}
