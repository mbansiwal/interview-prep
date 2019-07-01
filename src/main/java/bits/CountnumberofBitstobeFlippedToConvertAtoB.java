package bits;

public class CountnumberofBitstobeFlippedToConvertAtoB
{
	public static int flippedCount(int a, int b)
	{
		int xor = a ^ b;

		int count = 0;
		while (xor != 0)
		{
			xor = xor & (xor - 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(flippedCount(10, 20));
		System.out.println(flippedCount(11, 21));
	}
}
