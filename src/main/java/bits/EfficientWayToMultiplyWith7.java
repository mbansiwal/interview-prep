package bits;

public class EfficientWayToMultiplyWith7
{
	static long multiplyBySeven(long n)
	{
		return ((n << 3) - n);
	}

	public static void main(String[] args)
	{
		System.out.println(multiplyBySeven(4));
	}
}
