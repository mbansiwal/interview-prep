package google;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 * 
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

Intuition
The problem boils down to a two dimensional version of the longest increasing subsequence problem (LIS).

We must find the longest sequence seq such that the elements in seq[i+1] are greater than the corresponding elements in seq[i] (this means that seq[i] can fit into seq[i+1]).

The problem we run into is that the items we are given come in arbitrary order - we can't just run a standard LIS algorithm because we're allowed to rearrange our data. How can we order our data in a way such that our LIS algorithm will always find the best answer?

Notes on the LIS algorithm

You can find the longest increasing subsequence problem with a solution here. If you're not familiar with the O(N \log N)O(NlogN) algorithm please go visit that question as it's a prerequisite for this one.

For the sake of completeness here's a brief explanation on how the LIS algorithm used below works:

dp is an array such that dp[i] is the smallest element that ends an increasing subsequence of length i + 1. Whenever we encounter a new element e, we binary search inside dp to find the largest index i such that e can end that subsequence. We then update dp[i] with e.

The length of the LIS is the same as the length of dp, as if dp has an index i, then it must have a subsequence of length i+1.

Approach 1: Sort + Longest Increasing Subsequence
Algorithm

We answer the question from the intuition by sorting. Let's pretend that we found the best arrangement of envelopes. We know that each envelope must be increasing in w, thus our best arrangement has to be a subsequence of all our envelopes sorted on w.

After we sort our envelopes, we can simply find the length of the longest increasing subsequence on the second dimension (h). Note that we use a clever trick to solve some edge cases:

Consider an input [[1, 3], [1, 4], [1, 5], [2, 3]]. If we simply sort and extract the second dimension we get [3, 4, 5, 3], which implies that we can fit three envelopes (3, 4, 5). The problem is that we can only fit one envelope, since envelopes that are equal in the first dimension can't be put into each other.

In order fix this, we don't just sort increasing in the first dimension - we also sort decreasing on the second dimension, so two envelopes that are equal in the first dimension can never be in the same increasing subsequence.

Now when we sort and extract the second element from the input we get [5, 4, 3, 3], which correctly reflects an LIS of one.

Implementation

Complexity Analysis

Time complexity : O(N \log N)O(NlogN), where NN is the length of the input. Both sorting the array and finding the LIS happen in O(N \log N)O(NlogN)

Space complexity : O(N)O(N). Our lis function requires an array dp which goes up to size NN. Also the sorting algorithm we use may also take additional space.

 * @author Administrator
 *
 */
public class RussianDollEnvelopes {
	public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num: nums){
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0){
                i = -(i + 1);
            }
            dp[i] = num;
            if(len == i){
                len++;
            }
        }
        
        return len;
    }
    
    public int maxEnvelopes(int[][] envelopes) {
         // sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
           }
        });
        // extract the second dimension and run LIS
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) 
        {
        	secondDim[i] = envelopes[i][1];
        }
        return lengthOfLIS(secondDim);
    }
}
