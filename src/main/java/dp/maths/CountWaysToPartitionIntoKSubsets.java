package dp.maths;

/**
 *
 * Given two numbers n and k where n represents number of elements in a set, find number of ways to partition the set into k subsets.
 *
 * Example:
 *
 * Input: n = 3, k = 2
 * Output: 3
 * Explanation: Let the set be {1, 2, 3}, we can partition
 *              it into 2 subsets in following ways
 *              {{1,2}, {3}},  {{1}, {2,3}},  {{1,3}, {2}}
 *
 * Input: n = 3, k = 1
 * Output: 1
 * Explanation: There is only one way {{1, 2, 3}}
 *
 * When we add a (n+1)’th element to k partitions, there are two possibilities.
 * 1) It is added as a single element set to existing partitions, i.e, S(n, k-1)
 * 2) It is added to all sets of every partition, i.e., k*S(n, k)
 *
 * Therefore S(n+1, k) = k*S(n, k) + S(n, k-1) which means S(n, k) = k*S(n-1, k) + S(n-1, k-1)
 *
 *
 * https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
 */
public class CountWaysToPartitionIntoKSubsets
{
	public static void findWays(int noOfElements, int noOfSubSets)
	{
		//formula s(noOfElements,noOfSubSets) = noOfSubSets*s(noOfElements-1,noOfSubSets) +s(noOfElements-1,noOfSubSets-1)
		
		int[][] noOfWays = new int[noOfElements+1][noOfSubSets+1];
		for (int i = 1; i <= noOfElements; i++)
		{
			for (int k = 1; k <= noOfSubSets; k++)
			{
				if(i == k || k ==1)
				{
					noOfWays[i][k] = 1;
				}
				else
				{
					noOfWays[i][k] = k*noOfWays[i-1][k] + noOfWays[i-1][k-1];
				}
			}
		}
		
		System.out.println(noOfWays[noOfElements][noOfSubSets]);
	}
	
	public static void main(String[] args)
	{
		findWays(5, 2);
	}
}
