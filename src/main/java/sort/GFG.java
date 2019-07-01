package sort;

public class GFG
{
	public static int partition(Integer[] arr, int l, int r)
	{
		int x = arr[r], i = l;
		for (int j = l; j <= r - 1; j++)
		{
			if (arr[j] <= x)
			{
				// Swapping arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
			}
		}

		// Swapping arr[i] and arr[r]
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;

		return i;
	}

	public static int myPartition(int[] arr, int l, int r)
	{
		int pivot = arr[r];
		int i = l - 1;
		for (int j = l; j < r; j++)
		{
			if (arr[j] < pivot)
			{
				i++;
				swap(arr, i, j);
			}
		}
		i++;
		swap(arr, i, r);
		return i;
	}

	private static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int myKthSmallest(int[] arr, int l, int r, int k)
	{
		int pivot = myPartition(arr, l, r);
		if (pivot - l == k - 1)
		{
			return arr[pivot];
		}

		if (pivot - l > k - 1)
		{
			return myKthSmallest(arr, l, pivot - 1, k);
		}
		else
		{
			return myKthSmallest(arr, pivot + 1, r, k - pivot - 1 + l);
		}
	}

	// This function returns k'th smallest element
	// in arr[l..r] using QuickSort based method.
	// ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
	public static int kthSmallest(int[] arr, int l, int r, int k)
	{
		// If k is smaller than number of elements
		// in array
		if (k > 0 && k <= r - l + 1)
		{
			// Partition the array around last
			// element and get position of pivot
			// element in sorted array
			int pos = myPartition(arr, l, r);

			// If position is same as k
			if (pos - l == k - 1)
				return arr[pos];

			// If position is more, recur for
			// left subarray
			if (pos - l > k - 1)
				return kthSmallest(arr, l, pos - 1, k);

			// Else recur for right subarray
			return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
		}

		// If k is more than number of elements
		// in array
		return Integer.MAX_VALUE;
	}

	// Driver program to test above methods
	public static void main(String[] args)
	{
		int arr[] = new int[]
		{
				10, 7, 8, 9, 1, 5
		};
		int k = 2;
		System.out.print("K'th smallest element is " + myKthSmallest(arr, 0, arr.length - 1, k));
	}
}
