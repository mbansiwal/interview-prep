package binarysearch;

import java.util.Arrays;

/**
 * https://www.spoj.com/problems/AGGRCOW/
 * 
 * Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The
 * stalls are located along a straight line at positions x1,...,xN (0 <= xi <=
 * 1,000,000,000).
 * 
 * His C (2 <= C <= N) cows don't like this barn layout and become aggressive
 * towards each other once put into a stall. To prevent the cows from hurting
 * each other, FJ wants to assign the cows to the stalls, such that the minimum
 * distance between any two of them is as large as possible. What is the largest
 * minimum distance? Input t – the number of test cases, then t test cases
 * follows. Line 1: Two space-separated integers: N and C Lines 2..N+1: Line i+1
 * contains an integer stall location, xi Output For each test case output one
 * integer: the largest minimum distance.
 * 
 * @author Administrator
 *
 */
public class AggressiveCows {
	static int maxDistance(int[] arr, int cows) {
		Arrays.sort(arr);
		int low = 0;
		int high = Arrays.stream(arr).max().getAsInt();
		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isValid(arr, mid, cows)) {
				low = mid + 1;
				ans = mid;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	private static boolean isValid(int[] arr, int mid, int cows) {
		int placed = 1;
		int lastPlaced = arr[0];
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] - lastPlaced >= mid) {
				placed++;
				if (placed == cows) {
					return true;
				}
				lastPlaced = arr[i];
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 8, 4, 9 };
		System.out.println(maxDistance(arr, 3));
	}
}
