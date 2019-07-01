package sort;

import java.util.Arrays;

public class QuickSort
{
	private int partition(int[] arr, int low, int high)
	{
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++)
		{
			if (arr[j] < pivot)
			{
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}

	private void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void sort(int[] arr, int low, int high)
	{
		if (low < high)
		{
			int pivot = partition(arr, low, high);
			sort(arr, low, pivot - 1);
			sort(arr, pivot + 1, high);
		}
	}

	public int ktSmallestElement(int[] arr, int low, int high, int k)
	{
		if (low <= high)
		{
			int partition = partition(arr, low, high);
			if (partition == k - 1)
			{
				return arr[partition];
			}
			if (partition > k - 1)
			{
				return ktSmallestElement(arr, low, partition - 1, k);
			}
			return ktSmallestElement(arr, partition + 1, high, k);

		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args)
	{
		int arr[] =
		{
				10, 7, 8, 9, 1, 5
		};
		int n = arr.length;

		QuickSort ob = new QuickSort();
		System.out.println(ob.ktSmallestElement(arr, 0, n - 1, 6));
		// ob.sort(arr, 0, n - 1);

		System.out.println("sorted array");
		System.out.println(Arrays.toString(arr));
	}
}
