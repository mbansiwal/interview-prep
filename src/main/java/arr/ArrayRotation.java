package arr;

import java.util.Arrays;

public class ArrayRotation
{
	/**
	 * Printing the rotation of array.
	 * It requires extra space O(n) to save results and recreate the array if we in place update
	 * Time Complexity: O(n)
	 *
	 * @param arr
	 * @param n
	 * @param k
	 */
	static void leftRotate(int arr[], int n, int k)
	{
		for (int i = 0; i < n; i++)
		{
			int index = (i + k) % n;
			System.out.print(arr[index] + ",");
		}
		System.out.println();
	}

	/**
	 * Printing the rotation of array.
	 * It requires extra space O(n) to save results and recreate the array if we in place update
	 * Time Complexity: O(n)
	 *
	 * @param arr
	 * @param n
	 * @param k
	 */
	static void rightRotate(int arr[], int n, int k)
	{
		System.out.print("Right Rotate:::");
		for (int i = 0; i < n; i++)
		{
			int index = (((i - k) % n) + n) % n;
			System.out.print(arr[index] + ",");
		}
		System.out.println();
	}

	/**
	 * Actual Roation of Array
	 * Time Complexity is O(n) but less performing than {@link #leftRotate(int[], int, int)} method
	 *
	 * @param arr
	 * @param n
	 * @param k
	 */
	static void rightRotateInPlace(int arr[], int n, int k)
	{
		reverseArray(arr, 0, n - 1);
		reverseArray(arr, 0, k - 1);
		reverseArray(arr, k, n - 1);
		System.out.println();
	}

	static void leftRotateInPlace(int arr[], int d, int n)
	{
		reverseArray(arr, 0, d - 1);
		reverseArray(arr, d, n - 1);
		reverseArray(arr, 0, n - 1);
	}

	private static void reverseArray(int[] arr, int start, int end)
	{
		while (start < end)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}
	}

	public static void main(String[] args)
	{
		int arr[] =
		{
				1, 2, 3, 4, 5, 6
		};
		int n = arr.length;

		int k = 2;
		leftRotate(arr, n, k);

		k = 3;
		leftRotate(arr, n, k);

		k = 4;
		leftRotate(arr, n, k);

		k = 2;
		rightRotate(arr, n, k);

		k = 3;
		rightRotate(arr, n, k);

		k = 4;
		rightRotate(arr, n, k);

		rightRotateInPlace(arr, n, 2);
		System.out.println(Arrays.toString(arr));
		leftRotateInPlace(arr, n, 2);
		System.out.println(Arrays.toString(arr));
	}
}
