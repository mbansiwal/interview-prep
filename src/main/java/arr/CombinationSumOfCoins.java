package arr;

import java.util.HashSet;
import java.util.Set;

public class CombinationSumOfCoins
{
	public void printSums(int c1, int c2, int c3) {
		int start = Math.min(c1, Math.min(c2, c3));
		Set<Integer> sumSet = new HashSet<>();
		sumSet.add(0);
		for (int sum = start; sum < 1000; sum++)
		{
			if (sumSet.contains(sum - c1) || sumSet.contains(sum - c2) || sumSet.contains(sum - c3))
			{
				System.out.println(sum);
				sumSet.add(sum);
			}
		}
	}

	public static void main(String[] args)
	{
		new CombinationSumOfCoins().printSums(10, 15, 55);
	}
}
