package google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/max-value-of-equation/
 * 
 * Given an array points containing the coordinates of points on a 2D plane,
 * sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all
 * 1 <= i < j <= points.length. You are also given an integer k.
 * 
 * Find the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <=
 * k and 1 <= i < j <= points.length. It is guaranteed that there exists at
 * least one pair of points that satisfy the constraint |xi - xj| <= k.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1 Output: 4 Explanation:
 * The first two points satisfy the condition |xi - xj| <= 1 and if we calculate
 * the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy
 * the condition and give a value of 10 + -10 + |5 - 6| = 1. No other pairs
 * satisfy the condition, so we return the max of 4 and 1. Example 2:
 * 
 * Input: points = [[0,0],[3,0],[9,2]], k = 3 Output: 3 Explanation: Only the
 * first two points have an absolute difference of 3 or less in the x-values,
 * and give the value of 0 + 0 + |0 - 3| = 3.
 * 
 * 
 * https://leetcode.com/problems/max-value-of-equation/discuss/1027590/Java-solution-using-Monotonic-Queue-(Decreasing)-with-explanation
 * @author Administrator
 *
 */
public class MaxValueOfEquation {
	public int findMaxValueOfEquation(int[][] points, int k) {
		// Have deque for maintaining the Monotonic Queue
		Deque<Pair<Integer, Integer>> deq = new ArrayDeque<>();
		// Since we are going to find the maximum value we initialize result with MIN
		// value
		int result = Integer.MIN_VALUE;
		// iterate through the given points
		for (int[] point : points) {
			// Assign x,y as first and second
			int first = point[0];
			int second = point[1];

			// make sure the queue is not empty and then if the (diff - first) is greater
			// than k (Pair contains diff and first)
			// if so keep poping the value from first
			while (!deq.isEmpty() && first - deq.peekFirst().value > k)
				deq.pollFirst();

			// y + x
			int total = first + second;
			// maximize our result by adding the total to the (diff + total) element in
			// queue (Pair key is diff)
			if (!deq.isEmpty())
				result = Math.max(result, deq.peekFirst().key + total);

			// y - x
			int diff = second - first;
			// make sure the queue is not empty and then if the diff is greater than the
			// last diff element in the Queue
			// if so keep poping the value from the last
			while (!deq.isEmpty() && diff > deq.peekLast().key)
				deq.pollLast();

			// insert (y-x) and x
			deq.offerLast(new Pair<>(diff, first));
		}
		// return the result
		return result;
	}
}
