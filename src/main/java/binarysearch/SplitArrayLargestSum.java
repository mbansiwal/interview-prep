package binarysearch;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 * 
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

 

Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], m = 2
Output: 9
Example 3:

Input: nums = [1,4,4], m = 3
Output: 4

 * @author Administrator
 *
 */
public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
        int sum = 0;
        int maxElement = 0;
        for(int num: nums){
            sum+= num;
            maxElement = Math.max(maxElement, num);
        }
        
        int low = maxElement;
        int high = sum;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isValid(nums, m, mid)){
                high = mid - 1;
                ans = Math.min(mid, ans);
            } else{
                low = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean isValid(int[] nums, int m, int cap){
        int count = 1;
        int sum = 0;
        for(int num: nums){
            sum+= num;
            if(sum > cap){
                count++;
                if(count > m){
                    return false;
                }
                sum = num;
            }
        }
        return true;
    }
	 
	public static void main(String[] args) {
		int[] arr = {7,2,5,10,8};
		System.out.println(new SplitArrayLargestSum().splitArray(arr, 2));
	}
}
