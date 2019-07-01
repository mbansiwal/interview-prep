package arr;

import java.util.Arrays;

public class ProductOfArrayExceptSelf
{
	public static void main(String[] args)
	{
		int[] input =
		{
				5, 2, 3, 4
		};
		int[] result = new int[input.length];
		result[0] = 1;
		int n = input.length;
		for (int i = 1; i < n; i++)
		{
			result[i] = result[i - 1] * input[i-1];
		}

		int right = 1;
		for (int i = n - 1; i >= 0; i--)
		{
			result[i] = result[i] * right;
			right = input[i] * right;
		}

		System.out.println(Arrays.toString(result));
	}
}
