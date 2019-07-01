package dp.string;

public class StringToInteger
{
	public static void main(String[] args)
	{
		String number = "3.14159";
		System.out.println(toInteger(number));
	}

	private static int toInteger(String number)
	{
		int limit = Integer.MAX_VALUE;
		if (number == null || number.trim().length() == 0)
		{
			return 0;
		}
		number = number.trim();

		int sign = 1;
		if (number.charAt(0) == '-')
		{
			sign = -1;
			limit = Integer.MIN_VALUE;
		}

		int index = 0;
		if (number.charAt(0) == '-' || number.charAt(0) == '+')
		{
			index = 1;
		}

		int intNumber = 0;
		for (; index < number.length(); index++)
		{
			if (number.charAt(index) == '.')
			{
				return intNumber;
			}
			if (Character.isDigit(number.charAt(index)))
			{
				int digit = Character.digit(number.charAt(index), 10);
				int oldValue = intNumber;
				intNumber = oldValue*10 + digit;
				if (oldValue != (intNumber - digit) / 10)
				{
					return limit;
				}
			} else if (intNumber == 0)
			{
				return 0;
			}
		}
		return sign * intNumber;
	}
}
