package arr;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray
{
	public int[] searchRange(int[] nums, int target)
	{
		int[] range =
		{
				-1, -1
		};
		int left = binarySearch(nums, target, 0, nums.length - 1, true);
		if (left == nums.length || nums[left] != target)
		{
			return range;
		}

		int right = binarySearch(nums, target, left, nums.length - 1, false) - 1;
		range[0] = left;
		range[1] = right;
		return range;
	}

	private int binarySearch(int[] nums, int target, int low, int high, boolean left)
	{
		while (low < high)
		{
			int mid = low + (high - low) / 2;
			if (nums[mid] > target)
			{
				high = mid - 1;
			} else if (left && target == nums[mid])
			{
				high = mid;
			} else
			{
				low = mid + 1;
			}
		}
		return low;
	}

	public int[] searchRange2(int[] nums, int target)
	{
		int[] range =
		{
				-1, -1
		};
		int left = binarySearch2(nums, target, 0, nums.length, true);
		if (left == nums.length || nums[left] != target)
		{
			return range;
		}

		int right = binarySearch2(nums, target, left + 1, nums.length, false);
		range[0] = left;
		range[1] = right;
		return range;
	}

	private int binarySearch2(int[] nums, int target, int low, int high, boolean left)
	{
		while (low < high)
		{
			int mid = (low + high) / 2;
			if (nums[mid] == target)
			{
				return mid;
			}
			if (nums[mid] > target)
			{
				high = mid;
			} else
			{
				low = mid + 1;
			}
		}
		return low;
	}

	public static void main(String[] args)
	{
		int[] nums =
		{
				5, 7, 7, 8, 8, 10
		};
		System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, 8)));
		System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, 6)));
	}
}
