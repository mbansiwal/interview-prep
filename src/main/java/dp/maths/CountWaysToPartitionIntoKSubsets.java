package dp.maths;

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
