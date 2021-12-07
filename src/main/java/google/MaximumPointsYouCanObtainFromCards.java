package google;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 * 
 * There are several cards arranged in a row, and each card has an associated number of points 
 * The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

 

Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. 
However, choosing the rightmost card first will maximize your total score. 
The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
Example 2:

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.
Example 3:

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.
Example 4:

Input: cardPoints = [1,1000,1], k = 1
Output: 1
Explanation: You cannot take the card in the middle. Your best score is 1. 
Example 5:

Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
Output: 202


 * @author Administrator
 *
 */
public class MaximumPointsYouCanObtainFromCards {
	public int maxScore2(int[] cardPoints, int k) {
		int n = cardPoints.length;
		if(k == 1) {
			return Math.max(cardPoints[0], cardPoints[n-1]);
		}
		
		int leftSum = 0;
		for (int i = 0; i < k; i++) {
			leftSum += cardPoints[i];
		}
		
		int sum = leftSum;
		int rightSum = 0;
		for (int i = 0; i < k; i++) {
			leftSum -= cardPoints[i];
			rightSum += cardPoints[n-i-1];
			sum = Math.max(sum, leftSum + rightSum);
		}
		return sum;
	}
	
	public int maxScore(int[] cardPoints, int k) {
        if(k == 1) {
        	return Math.max(cardPoints[0], cardPoints[cardPoints.length - 1]);
        }
        
        int max = getSum(cardPoints, 0, k-1);
        
        int leftSum = max;
        int rightSum = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
			leftSum = leftSum - cardPoints[k - 1 - i];
        	rightSum = rightSum + cardPoints[n - 1 - i];
			max = Math.max(max, (rightSum + leftSum));
		}
        return max;
    }
	
	private int getSum(int arr[], int start, int end) {
		int val = 0;
		for (int i = start; i <= end; i++) {
			val+=arr[i];
		}
		return val;
	}
}
