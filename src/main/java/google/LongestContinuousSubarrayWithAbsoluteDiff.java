package google;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * 
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

 

Example 1:

Input: nums = [8,2,4,7], limit = 4
Output: 2 
Explanation: All subarrays are: 
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4. 
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4. 
Therefore, the size of the longest subarray is 2.
Example 2:

Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4 
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
Example 3:

Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3

 * @author Administrator
 *
 */
public class LongestContinuousSubarrayWithAbsoluteDiff {
	public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new LinkedList<Integer>();
        Deque<Integer> min = new LinkedList<Integer>();
        
        int idx = 0;
        int res = 1;
        for(int i = 0 ; i < nums.length ; i++){
            while(max.size() != 0 && nums[max.peekLast()] < nums[i]){
                max.pollLast();
            }
            max.add(i);
            
            while(min.size() != 0 && nums[min.peekLast()] > nums[i]){
                min.pollLast();
            }
            min.add(i);
            
            while(nums[max.peekFirst()] - nums[min.peekFirst()] > limit){
                int maxIdx = -1;
                if(max.peekFirst() < min.peekFirst()){
                    maxIdx = Math.max(maxIdx, max.poll());
                }
                else{
                    maxIdx = Math.max(maxIdx, min.poll());
                }
                idx = maxIdx + 1;
            }
            res = Math.max(i - idx + 1, res);
            
        }
        return res;
    }
}
