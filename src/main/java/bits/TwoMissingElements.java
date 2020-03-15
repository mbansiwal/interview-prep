package bits;

public class
TwoMissingElements
{
	public void findTwoMissingElements(int[] arr)
	{
		int n = arr.length + 2;
		int xor = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			xor = xor ^ arr[i];
		}

		for (int i = 1; i <= n; i++)
		{
			xor = xor ^ i;
		}

		int setBit = xor & ~(xor - 1);

		int x = 0;
		int y = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if ((arr[i] & setBit) > 0)
			{
				x = x ^ arr[i];
			} else
			{
				y = y ^ arr[i];
			}
		}


		for (int i = 1; i <= n; i++)
		{
			if ((i & setBit) > 0)
			{
				x = x ^ i;
			} else
			{
				y = y ^ i;
			}
		}

		System.out.println("Two elements are x = " + x + ", y = " + y);
	}

	public static void main(String[] args)
	{
		int arr[] =
		{
				1, 3, 5, 6
		};
		new TwoMissingElements().findTwoMissingElements(arr);

		int arr2[] =
		{
				1, 3, 4, 5, 6, 7, 9
		};
		new TwoMissingElements().findTwoMissingElements(arr2);
	}
}
