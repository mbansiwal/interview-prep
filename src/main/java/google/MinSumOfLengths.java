package google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 * 
 * Given an array of integers arr and an integer target.

You have to find two non-overlapping sub-arrays of arr each with sum equal target. There can be multiple answers so you have to find an answer where the sum of the lengths of the two sub-arrays is minimum.

Return the minimum sum of the lengths of the two required sub-arrays, or return -1 if you cannot find such two sub-arrays.

 

Example 1:

Input: arr = [3,2,2,4,3], target = 3
Output: 2
Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.
Example 2:

Input: arr = [7,3,4,7], target = 7
Output: 2
Explanation: Although we have three non-overlapping sub-arrays of sum = 7 ([7], [3,4] and [7]), but we will choose the first and third sub-arrays as the sum of their lengths is 2.
Example 3:

Input: arr = [4,3,2,6,2,3,4], target = 6
Output: -1
Explanation: We have only one sub-array of sum = 6.
Example 4:

Input: arr = [5,5,4,4,5], target = 3
Output: -1
Explanation: We cannot find a sub-array of sum = 3.
Example 5:

Input: arr = [3,1,1,1,5,1,2,1], target = 3
Output: 3
Explanation: Note that sub-arrays [1,2] and [2,1] cannot be an answer because they overlap.
 * @author Administrator
 *
 */
public class MinSumOfLengths {
	public int minSumOfLengths(int[] arr, int target) {
		int len = arr.length;
// map from prefix sum value to the last index where the prefix ends
		Map<Integer, Integer> prefixSumIndexes = new HashMap<>();
		prefixSumIndexes.put(0, -1);
		int prefixSum = 0, res = len + 1;
// length of subarray of target sum that ends before or at the index
		int[] minArrayLen = new int[len];
		Arrays.fill(minArrayLen, len + 1);
		for (int i = 0; i < len; i++) {
			prefixSum += arr[i];
			if (prefixSumIndexes.containsKey(prefixSum - target)) {
				int index = prefixSumIndexes.get(prefixSum - target);
				if (index >= 0) { 
					// when there is another prefix ending at index that sum to target
					res = Math.min(res, minArrayLen[index] + i - index);
				}
				minArrayLen[i] = Math.min(i - index, minArrayLen[i]);
			}
			if (i - 1 >= 0) {
				minArrayLen[i] = Math.min(minArrayLen[i - 1], minArrayLen[i]);
			}
			prefixSumIndexes.put(prefixSum, i);
		}
		if (res == len + 1) {
			return -1;
		}
		return res;
	}
}
