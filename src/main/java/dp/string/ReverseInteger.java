package dp.string;

public class ReverseInteger
{
	public static void main(String[] args)
	{
		int number = 153423;
		System.out.println(reverse(number));
	}

	private static int reverse(int number)
	{
		int reverseNumber = 0;

		int sign = 1;
		if (number < 0)
		{
			sign = -1;
			number = sign * number;
		}
		while (number > 0)
		{
			int remainder = number % 10;
			int previousNumber = reverseNumber;
			reverseNumber = previousNumber * 10 + remainder;
			if ((reverseNumber - remainder) / 10 != previousNumber)
			{
				return 0;
			}
			number = number / 10;
		}

		return sign * reverseNumber;
	}
}
