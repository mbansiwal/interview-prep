package arr;

import java.util.Arrays;

public class PermutationWithRepeatedNumbers
{
	public static void findPermutaionInDistance(int n)
	{
		int[] input = new int[2 * n];
		boolean[] used = new boolean[n + 1];
		help(input, used, 0);
	}

	private static void help(int[] input, boolean[] used, int start)
	{
		if (start == input.length)
		{
			for (int i = 1; i < used.length; i++)
			{
				if (!used[i])
				{
					return;
				}
			}
			System.out.println(Arrays.toString(input));
		}

		for (int i = 1; i < used.length; i++)
		{
			int nextIndex = i + start + 1;
			if (used[i] || nextIndex >= input.length || input[nextIndex] != 0)
			{
				continue;
			}
			input[start] = i;
			input[nextIndex] = i;
			used[i] = true;
			int j = start;
			while (j < input.length && input[j] != 0)
			{
				j++;
			}
			help(input, used, j);
			input[start] = 0;
			input[nextIndex] = 0;
			used[i] = false;
		}
	}

	public static void main(String[] args)
	{
		findPermutaionInDistance(3);
	}
}
