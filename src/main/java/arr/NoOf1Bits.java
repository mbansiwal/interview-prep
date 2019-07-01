package arr;

import java.util.ArrayList;
import java.util.List;

public class NoOf1Bits
{
	List<String> results = new ArrayList<String>();

	private int countDigits(int n)
	{
		int digitCount = 0;
		while (n != 0)
		{
			n &= (n - 1);
			digitCount++;
		}
		return digitCount;
	}

	public static void main(String[] args)
	{
		System.out.println(new NoOf1Bits().countDigits(-3));
	}
}
