package arr;

public class MinimumInRotatedSortedArray
{
	public int findMin(int[] nums)
	{
		if (nums.length == 0)
		{
			return -1;
		}
		int high = nums.length - 1;
		int low = 0;
		while (low < high)
		{
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[high])
			{
				low = mid + 1;
			}
			else if (nums[mid] < nums[low])
			{
				high = mid;
				// ++low;
			} 
			else
			{
				--high;
			}
		}

		return nums[low];
	}
	public int findMinWithNoDuplicate(int[] nums)
	{
		if (nums.length == 1)
		{
			return nums[0];
		}
		int high = nums.length - 1;
		int low = 0;
		if (nums[0] < nums[high])
		{
			return nums[0];
		}

		while (low <= high)
		{
			int mid = low + (high - low) / 2;

			if (nums[mid] > nums[mid + 1])
			{
				return nums[mid + 1];
			}

			if (nums[mid] < nums[mid - 1])
			{
				return nums[mid];
			}

			if (nums[mid] > nums[low])
			{
				low = mid + 1;
			} else
			{
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[] arr1 =
		{
				1
		};

		System.out.println(new MinimumInRotatedSortedArray().findMinWithNoDuplicate(arr1));

		int[] arr1_2 =
		{
				2, 1
		};

		System.out.println(new MinimumInRotatedSortedArray().findMinWithNoDuplicate(arr1_2));

		int[] arr =
		{
				3, 4, 5, 1, 2
		};

		System.out.println(new MinimumInRotatedSortedArray().findMinWithNoDuplicate(arr));

		int[] arr2 =
		{
				4, 5, 6, 7, 0, 1, 2
		};

		System.out.println(new MinimumInRotatedSortedArray().findMinWithNoDuplicate(arr2));

		int[] arr3 =
		{
				0, 0
		};
		System.out.println(new MinimumInRotatedSortedArray().findMin(arr3));
		int[] arr4 =
		{
				7, 8, 9, 5, 5, 5, 6
		};
		System.out.println(new MinimumInRotatedSortedArray().findMin(arr4));
	}
}
