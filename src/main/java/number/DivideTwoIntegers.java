package number;

public class DivideTwoIntegers
{
	public int divide(int dividend, int divisor)
	{
		if (dividend == Integer.MIN_VALUE && divisor == -1)
		{
			return Integer.MAX_VALUE;
		}
		if (dividend == Integer.MIN_VALUE && divisor == 1)
		{
			return Integer.MIN_VALUE;
		}

		if (dividend == 0)
		{
			return 0;
		}

		int count = 0;
		int sign = 1;
		if (dividend < 0)
		{
			sign = -1;
			dividend = -dividend;
		}
		if (divisor < 0)
		{
			sign = -sign;
			divisor = -divisor;
		}

		if (divisor == 0)
		{
			return sign * Integer.MAX_VALUE;
		}

		if (divisor == 1)
		{
			if (sign == -1)
			{
				return -dividend;
			} else
			{
				return dividend;
			}
		}

		while (divisor <= dividend)
		{
			dividend -= divisor;
			count++;
		}

		if (sign < 0)
		{
			count = -count;
		}

		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(new DivideTwoIntegers().divide(10, 3));
		System.out.println(new DivideTwoIntegers().divide(-2147483648, 1));
	}
}
