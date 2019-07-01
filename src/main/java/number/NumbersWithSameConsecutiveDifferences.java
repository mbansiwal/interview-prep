package number;

import java.util.HashSet;
import java.util.Set;

public class NumbersWithSameConsecutiveDifferences
{
	public int[] numsSameConsecDiff(int N, int K)
	{
		Set<Integer> currentDigits = new HashSet<>();

		for (int i = 1; i <= 9; i++)
		{
			currentDigits.add(i);
		}

		if (N == 1)
		{
			currentDigits.add(0);
		} else
		{
			for (int steps = 1; steps <= N - 1; steps++)
			{
				Set<Integer> tempDigits = new HashSet<>();
				for (Integer digit : currentDigits)
				{
					int lastDigit = digit % 10;
					if ((lastDigit - K) >= 0)
					{
						tempDigits.add(10 * digit + (lastDigit - K));
					}
					if ((lastDigit + K) <= 9)
					{
						tempDigits.add(10 * digit + (lastDigit + K));
					}
				}
				currentDigits = tempDigits;
			}
		}

		int[] result = new int[currentDigits.size()];
		int i = 0;
		for (Integer integer : currentDigits)
		{
			result[i++] = integer;

		}
		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(2, 1));
	}
}
