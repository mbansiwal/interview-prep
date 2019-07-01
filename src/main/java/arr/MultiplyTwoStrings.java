package arr;

public class MultiplyTwoStrings
{
	public String multiply(String num1, String num2)
	{
		int m = num1.length();
		int n = num2.length();
		int[] pos = new int[m + n];
		for (int i = m - 1; i >= 0; i--)
		{
			for (int j = n - 1; j >= 0; j--)
			{
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int pos1 = i + j;
				int pos2 = i + j + 1;
				int sum = mul + pos[pos2];
				int remainder = sum / 10;
				int digit = sum % 10;

				pos[pos1] += remainder;
				pos[pos2] = digit;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int p : pos)
			if (!(sb.length() == 0 && p == 0))
				sb.append(p);
		return sb.length() == 0 ? "0" : sb.toString();
	}

	public String multiply2(String num1, String num2)
	{
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();

		int[] d = new int[num1.length() + num2.length()];

		// multiply each digit and sum at the corresponding positions
		for (int i = 0; i < n1.length(); i++)
		{
			for (int j = 0; j < n2.length(); j++)
			{
				d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
			}
		}

		StringBuilder sb = new StringBuilder();

		// calculate each digit
		for (int i = 0; i < d.length; i++)
		{
			int mod = d[i] % 10;
			int carry = d[i] / 10;
			if (i + 1 < d.length)
			{
				d[i + 1] += carry;
			}
			sb.insert(0, mod);
		}

		// remove front 0's
		while (sb.charAt(0) == '0' && sb.length() > 1)
		{
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}
	public static void main(String[] args)
	{
		System.out.println(24 / 10);
		System.out.println(24 % 10);
		System.out.println(new MultiplyTwoStrings().multiply("18", "2"));
		System.out.println(new MultiplyTwoStrings().multiply("99", "99"));
	}
}
