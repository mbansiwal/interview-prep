package arr;

import java.util.ArrayList;
import java.util.List;

public class AdjacentAlphabetCombination
{
	int count = 0;

	public int combinations(int[] arr)
	{
		if (arr.length < 2)
		{
			return 1;
		}
		int table[] = new int[arr.length];
		table[0] = 1;
		if (isValid(arr[0], arr[1]))
		{
			table[1] = 2;
		}

		for (int i = 2; i < arr.length; i++)
		{
			int combo = 0;
			if (isValid(arr[i - 1], arr[i]))
			{
				combo = table[i - 2];
			}
			table[i] = table[i - 1] + combo;
		}
		return table[arr.length - 1];
	}

	public void allCombinations(int[] arr, int[] result, int start, int end, int k)
	{
		if (start == arr.length)
		{
			for (int i = 0; i < end; i++)
			{
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < (start + k) && i < arr.length; i++)
		{
			// int number = formNumber(arr, start, i);
			// if (number < 26)
			{
				result[end] = formNumber(arr, start, i);
				allCombinations(arr, result, i + 1, end + 1, k);
			}
		}
	}

	public void allCombinations(int[] numbers, List<Integer> result, int start, int k)
	{
		if (start == numbers.length)
		{
			System.out.println(result);
			return;
		}
		for (int i = start; i < (start + k) && i < numbers.length; ++i)
		{
			int number = formNumber(numbers, start, i);
			result.add(number);
			allCombinations(numbers, result, i + 1, k);
			result.remove(result.size() - 1);
		}
	}

	private int formNumber(int input[], int start, int end)
	{
		int num = 0;
		for (int i = start; i <= end; i++)
		{
			num = num * 10 + input[i];
		}
		return num;
	}


	private boolean isValid(int a1, int a2)
	{
		int number = a1 * 10 + a2;
		return number <= 26;
	}

	public static void main(String[] args)
	{
		int[] arr =
		{
				1, 1, 1, 1
		};
		System.out.println(new AdjacentAlphabetCombination().combinations(arr));

		int[] arr2 =
		{
				1, 2, 1, 4
		};
		int[] result = new int[arr2.length];
		new AdjacentAlphabetCombination().allCombinations(arr2, result, 0, 0, 2);
		System.out.println("========");
		new AdjacentAlphabetCombination().allCombinations(arr2, new ArrayList<>(), 0, 2);
	}
}
