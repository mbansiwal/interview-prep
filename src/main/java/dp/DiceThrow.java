package dp;

/**
 * Given n dice each with m faces, numbered from 1 to m, find the number of ways
 * to get sum X. X is the summation of values on each face when all the dice are
 * thrown.
 * 
 * Recommended: Please solve it on “PRACTICE ” first, before moving on to the
 * solution. The Naive approach is to find all the possible combinations of
 * values from n dice and keep on counting the results that sum to X.
 * 
 * This problem can be efficiently solved using Dynamic Programming (DP).
 * 
 * Let the function to find X from n dice is: Sum(m, n, X) The function can be
 * represented as: Sum(m, n, X) = Finding Sum (X - 1) from (n - 1) dice plus 1
 * from nth dice + Finding Sum (X - 2) from (n - 1) dice plus 2 from nth dice +
 * Finding Sum (X - 3) from (n - 1) dice plus 3 from nth dice
 * ...................................................
 * ...................................................
 * ................................................... + Finding Sum (X - m)
 * from (n - 1) dice plus m from nth dice
 * 
 * So we can recursively write Sum(m, n, x) as following Sum(m, n, X) = Sum(m, n
 * - 1, X - 1) + Sum(m, n - 1, X - 2) + .................... + Sum(m, n - 1, X -
 * m)
 * 
 * @author mbansiwal
 *
 */
public class DiceThrow
{
	public static void diceThrow(int faces, int noOfDices, int sum)
	{
		int[][] table = new int[noOfDices + 1][sum + 1];

		for (int j = 1; j <= sum && j <= faces; j++)
		{
			table[1][j] = 1;
		}

		for (int i = 1; i <= noOfDices; i++)
		{
			for (int j = 1; j <= sum; j++)
			{
				for (int k = 1; k <= faces && k < j; k++)
				{
					table[i][j] += table[i - 1][j - k];
				}
			}
		}

		System.out.println(table[noOfDices][sum]);
	}

	public static void main(String[] args)
	{
		diceThrow(4, 2, 1);
		diceThrow(2, 2, 3);
		diceThrow(6, 3, 8);
		diceThrow(4, 2, 5);
		diceThrow(4, 3, 5);
	}
}
