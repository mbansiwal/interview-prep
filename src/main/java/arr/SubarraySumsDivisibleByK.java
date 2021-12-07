package arr;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * 
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0

 * 1)take an unordered map in which you will save the <remainder,frequency> in the same format,insert 0 with a frequency of 1,so that if the sum gives remainder 0 it will increment in the ans.
2)traverse the array and keep on calculating the sum upto that index.
3)take modulo of the sum of the subarray by k and check if the remainder exists in the hashmap. If it exists it means that there exists a subarray which is divisible by k.
4)for negative rem just add k to the rem and then check in the hashmap as (-5mod7 and 2mod7 are equivalent and -5+7=2),so you will be taking all the remainders in positive.
5)at last just keep on increasing the frequency of remainders.

 * @author Administrator
 *
 */
public class SubarraySumsDivisibleByK
{
	public int subarraysDivByK(int[] A, int K)
	{
		int N = A.length;
		int[] P = new int[N + 1];
		for (int i = 0; i < N; ++i)
		{
			P[i + 1] = P[i] + A[i];
		}

		int[] count = new int[K];
		for (int x : P)
		{
			count[(x % K + K) % K]++;
		}

		int ans = 0;
		for (int v : count)
		{
			ans += v * (v - 1) / 2;
		}
		return ans;
	}

	public int subarraysDivByK2(int[] A, int K)
	{
		int[] map = new int[K];
		map[0] = 1;
		int count = 0, sum = 0;
		for (int a : A)
		{
			sum = (sum + a) % K;
			if (sum < 0)
			{
				sum += K; // Because -1 % 5 = -1, but we need the positive mod 4
			}
			count += map[sum];
			map[sum]++;
		}
		return count;
	}

	public static void main(String[] args)
	{
		int arr[] =
		{
				15, 4, 5, 0, -2, -3, 1
		};
		System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK(arr, 5));
		System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK2(arr, 5));
	}
}
