package bits;

public class RecursiveUsingBitwiseOperator
{
	static void bin(Integer n)
	{
		if (n > 1)
		{
			bin(n >> 1);
		}

		System.out.print(n & 1);
	}

	public static void main(String[] args)
	{
		bin(2);
		System.out.println();
		bin(131);
		System.out.println();
		bin(3);
		System.out.println();
	}
}
