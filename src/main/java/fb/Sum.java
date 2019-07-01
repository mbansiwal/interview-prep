package fb;

import java.util.Arrays;
import java.util.List;

public class Sum
{
	/**
	 * I/P [8, 3, 2, [5, 6, [9]], 6]
	 * 
	 * O/P 8+3+2+2*(5+6+3*(9))+6 => 95
	 * 
	 * 
	 * @param list
	 * @param multiplier
	 * @return
	 */
	public static int calculate(List<Object> list, int multiplier)
	{
		int sum = 0;
		for (Object obj : list)
		{
			if (obj instanceof List && !((List<Object>) obj).isEmpty())
			{
				multiplier++;
				sum = sum + multiplier * calculate((List<Object>) obj, multiplier);
			} else
			{
				sum += (Integer) obj;
			}
		}
		return sum;
	}

	public static void main(String[] args)
	{
		System.out.println(calculate(Arrays.asList(8, 3, 2, Arrays.asList(5, 6, Arrays.asList(9)), 6), 1));
	}
}
