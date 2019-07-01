package bits;

public class DecimalToBits
{
	static String decimalToBinary2(double num, int k_prec)
	{
		int integerPart = (int) num;
		double fractionPart = num - integerPart;
		StringBuilder sb = new StringBuilder();
		findBin(integerPart, sb);

		sb.append(".");

		while (k_prec-- > 0)
		{
			fractionPart *= 2;
			int intPart = (int) fractionPart;
			if (intPart == 1)
			{
				fractionPart -= intPart;
				sb.append("1");
			} else
			{
				sb.append("0");
			}
		}

		return sb.toString();
	}

	private static void findBin(Integer num, StringBuilder sb)
	{
		if(num > 1){
			findBin(num >> 1, sb);
		}
		sb.append(num & 1);
	}

	static String decimalToBinary(double num, int k_prec)
	{
		StringBuilder sb = new StringBuilder();

		Integer integerPart = (int) num;
		double fraction = num - integerPart;
		while (integerPart > 0)
		{
			int rem = integerPart % 2;
			sb.append(rem);
			integerPart /= 2;
		}

		sb.reverse();
		sb.append('.');


		while (k_prec-- > 0)
		{
			fraction *= 2;
			int fractionBit = (int) fraction;
			if (fractionBit == 1)
			{
				fraction -= fractionBit;
				sb.append(1);
			} else
			{
				sb.append(0);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(decimalToBinary(4.47, 3));
		System.out.println(decimalToBinary(6.986, 5));

		System.out.println(decimalToBinary2(4.47, 3));
		System.out.println(decimalToBinary2(6.986, 5));
	}
}
