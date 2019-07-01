package dp;

public class EggDropPuzzle
{
	public static void main(String args[])
	{
		int n = 2, k = 10;
		System.out.println(
				"Minimum number of trials in worst case with " + n + "  eggs and " + k + " floors is " + eggDrop(n, k));
	}

	private static int eggDrop(int noOfEggs, int noOfFloors)
	{
		int[][] eggDropTable = new int[noOfEggs + 1][noOfFloors + 1];

		for (int i = 1; i <= noOfEggs; i++)
		{
			eggDropTable[i][1] = 1;
		}

		for (int j = 1; j <= noOfFloors; j++)
		{
			eggDropTable[1][j] = j;
		}
		for (int i = 2; i <= noOfEggs; i++)
		{
			for (int j = 2; j <= noOfFloors; j++)
			{
				int result = Integer.MAX_VALUE;
				for (int k = 1; k <= j; k++)
				{
					result = Math.min(result, 1 + Math.max(eggDropTable[i - 1][k - 1], eggDropTable[i][j - k]));
				}
				eggDropTable[i][j] = result;
			}
		}
		return eggDropTable[noOfEggs][noOfFloors];
	}
}
