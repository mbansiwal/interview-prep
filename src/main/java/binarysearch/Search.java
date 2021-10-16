package binarysearch;

import java.util.Arrays;

import arr.FindFirstAndLastPositionOfElementInSortedArray;

public class Search {
	public static void main(String[] args) 
	{
//		main1(args);
		main2(args);
	}
	
	public static void main1(String[] args) 
	{
		int[] arr = {-1, 2, 3, 5, 6, 8, 9, 10};
		System.out.println(search(arr, 6));
		System.out.println(search(arr, 7));
		System.out.println(search(arr, -1));
		System.out.println(search(arr, 10));
	}

	private static int search(int[] arr, int i) {
		int low = 0;
		int high = arr.length;
		while(low <= high) {
			int mid = low+ (high-low)/2;
			if(arr[mid] == i) {
				return mid;
			}
			if(arr[mid] > i) {
				high = mid-1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main2(String[] args)
	{
		int[] nums =
		{
				5, 7, 7, 8, 8, 10, 11, 11
		};
		
		System.out.println(Arrays.toString(searchRange(nums, 7)));
		
		System.out.println(Arrays.toString(searchRange(nums, 8)));
		
		System.out.println(Arrays.toString(searchRange(nums, 11)));
		
		System.out.println(Arrays.toString(searchRange(nums, 6)));
	}

	private static int[] searchRange(int[] nums, int target) {
		int[] noRange = {-1,-1};
		int leftIndex = searchFirstOrLast(nums, 0, nums.length, target, true);
		if(leftIndex == nums.length || (nums[leftIndex] != target)) {
			return noRange;
		}
		int rightIndex = searchFirstOrLast(nums, leftIndex, nums.length, target, false);
		return new int[] {leftIndex, rightIndex-1};
	}
	
	private static int searchFirstOrLast(int[] arr, int low, int high, int target, boolean left) {
		while(low < high) {
			int mid = (low + high)/2;
			if(arr[mid] > target || (left && arr[mid] == target)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}
