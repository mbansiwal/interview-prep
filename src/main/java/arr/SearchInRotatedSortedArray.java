package arr;

public class SearchInRotatedSortedArray
{
	public int search(int[] arr, int target)
	{
		int low = 0;
		int high = arr.length - 1;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;

			if (arr[mid] == target)
			{
				return mid;
			}
			else if (arr[high] > arr[mid])
			{
				if (target > arr[mid] && target <= arr[high])
				{
					low = mid + 1;
				} else
				{
					high = mid - 1;
				}
			}
			else
			{
				if (target >= arr[low] && target < arr[mid])
				{
					high = mid - 1;
				} else
				{
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[] arr =
		{
				1
		};

		System.out.println(new SearchInRotatedSortedArray().search(arr, 0));

		int[] arr2 =
				{
						3, 4, 5, 1, 2
				};
		System.out.println(new SearchInRotatedSortedArray().search(arr2, 5));

		int[] arr3 =
				{
						4,5,1,2,3
				};
		System.out.println(new SearchInRotatedSortedArray().search(arr3, 2));
	}
}
