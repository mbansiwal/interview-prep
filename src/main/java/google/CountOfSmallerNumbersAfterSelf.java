package google;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self
 * 
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,2,6,1] Output: [2,1,1,0] Explanation: To the right of 5
 * there are 2 smaller elements (2 and 1). To the right of 2 there is only 1
 * smaller element (1). To the right of 6 there is 1 smaller element (1). To the
 * right of 1 there is 0 smaller element.
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 10^5 -10^4 <= nums[i] <= 10^4
 * 
 * @author Administrator
 *
 */
public class CountOfSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		if(nums.length == 0) {
			return Arrays.asList();
		}
		convert(nums);
		int[] tree = new int[nums.length+1];
		Integer[] result = new Integer[nums.length];
		for (int i = nums.length-1; i >=0; i--) {
			result[i] = getSum(tree, nums[i]-1);
			update(tree, nums[i], 1);
		}
		return Arrays.asList(result);
	}
	
	private int getSum(int[] tree, int index) {
		int sum = 0;
		while(index > 0) {
			sum += tree[index];
			index -= index & (-index);
		}
		return sum;
	}

	private void update(int[] tree, int index, int value) {
		while(index < tree.length) {
			tree[index] += value;
			index += (index & (-index));
		}
	}
	
	private void convert(int[] input) {
		int[] arr = new int[input.length];
		System.arraycopy(input, 0, arr, 0, input.length);
		Arrays.sort(arr);
		for (int i = 0; i < input.length; i++) {
			input[i] = Arrays.binarySearch(arr, input[i]) + 1;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {5,2,6,1};
		System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(nums));
	}

}
