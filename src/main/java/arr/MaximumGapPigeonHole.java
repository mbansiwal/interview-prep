package arr;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-gap
 * 
 * Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

Algorithm

We choose a bucket size bb such that 1 < b \leq (max - min)/(n-1)1<b≤(max−min)/(n−1). Let's just choose b = \lfloor (max - min)/(n-1) \rfloorb=⌊(max−min)/(n−1)⌋.

Thus all the nn elements would be divided among k = \lceil (max - min)/b \rceilk=⌈(max−min)/b⌉ buckets.

Hence the i^{th}i 
th
  bucket would hold the range of values: \bigg [min + (i-1) * b, \space min + i*b \bigg )[min+(i−1)∗b, min+i∗b) (1-based indexing).

It is trivial to calculate the index of the bucket to which a particular element belongs. That is given by \lfloor (num - min)/b \rfloor⌊(num−min)/b⌋ (0-based indexing) where numnum is the element in question.

Once all nn elements have been distributed, we compare k-1k−1 adjacent bucket pairs to find the maximum gap.



 * @author mbbansiw
 *
 */
public class MaximumGapPigeonHole {
	private static class Bucket{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean used;
	}
	
	 public int maximumGap(int[] nums) {
		 if(nums == null || nums.length < 2) {
			 return 0;
		 }
		 
		 int min = Arrays.stream(nums).min().getAsInt();
		 int max = Arrays.stream(nums).max().getAsInt();
		 int n = nums.length;
		 int bucketSize = Math.max(1, (max - min)/(n-1));
		 int numOfBuckets = (max-min)/bucketSize + 1;
		 Bucket[] buckets = new Bucket[numOfBuckets];
		 for (int i = 0; i < numOfBuckets; i++) {
			 buckets[i] = new Bucket();
		 }
		 
		 for (int num : nums) {
			int bucketIndex = (num - min)/bucketSize;
			Bucket bucket = buckets[bucketIndex];
			bucket.used = true;
			bucket.min = Math.min(num, bucket.min);
			bucket.max = Math.max(num, bucket.max);
		 }
		 
		 int maxGap = 0;
		 int previousMax = min;
		 for (Bucket bucket : buckets) {
			 if(bucket.used) {
				maxGap = Math.max(maxGap, bucket.min - previousMax);
				previousMax = bucket.max;
			 }
		 }
		 return maxGap;
	 }
	 
	 public static void main(String[] args) {
		MaximumGapPigeonHole maximumGap = new MaximumGapPigeonHole();
		int[] input1 = {3,6,9,1};
		int[] input2 = {10};
		System.out.println(maximumGap.maximumGap(input1));
		System.out.println(maximumGap.maximumGap(input2));
	}
}
