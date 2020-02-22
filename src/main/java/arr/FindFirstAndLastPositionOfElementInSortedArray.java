package arr;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class FindFirstAndLastPositionOfElementInSortedArray
{
	public int[] searchRange(int[] nums, int target)
	{
		int[] range =
		{
				-1, -1
		};
		int left = binarySearch(nums, target, 0, nums.length, true);
		if (left == nums.length || nums[left] != target)
		{
			return range;
		}

		int right = binarySearch(nums, target, left, nums.length, false) -1;
		range[0] = left;
		range[1] = right;
		return range;
	}

	private int binarySearch(int[] nums, int target, int low, int high, boolean left)
	{
		while (low < high)
		{
			int mid = (low + high) / 2;
			if (nums[mid] > target || (left && target == nums[mid]))
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
				5, 7, 7, 8, 8, 10, 11, 11
		};
		System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, 7)));
		System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, 8)));
		System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, 11)));
		System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, 6)));
	}
}
