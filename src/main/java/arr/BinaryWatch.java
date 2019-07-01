package arr;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch
{
	List<String> results = new ArrayList<String>();

	// private int countDigits(int n)
	// {
	// int digitCount = 0;
	// while (n != 0)
	// {
	// if (n % 2 == 1)
	// {
	// digitCount++;
	// }
	// n = n / 2;
	// }
	// return digitCount;
	// }

	private int countDigits(int n)
	{
		int digitCount = 0;
		while (n > 0)
		{
			n &= (n - 1);
			digitCount++;
		}
		return digitCount;
	}

	public List<String> readBinaryWatch(int num)
	{
		for (int i = 0; i < 12; i++)
		{
			for (int j = 0; j < 60; j++)
			{
				int totalDigits = countDigits(j) + countDigits(i);
				if (totalDigits == num)
				{
					String result = "";

					result = result + i + ":";
					if (j < 10)
					{
						result += "0";
					}
					result += j;
					results.add(result);
				}
			}
		}
		return results;
	}

	public static void main(String[] args)
	{
		System.out.println(new BinaryWatch().readBinaryWatch(1));
	}
}
