package arr;

public class MaxConsecutiveOnes
{
	public int longestOnes(int[] a, int k)
	{
		int one = 0;
		int start = 0;
		int maxLen = 0;

		for (int end = 0; end < a.length; end++)
		{
			if (a[end] == 1)
			{
				one++;
			}

			while (end - start + 1 > one + k)
			{
				if (a[start++] == 1)
				{
					one--;
				}
			}
			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;
	}

	public static void main(String[] args)
	{
		int[] arr =
		{
				1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0
		};
		System.out.println(new MaxConsecutiveOnes().longestOnes(arr, 2));
	}
}
