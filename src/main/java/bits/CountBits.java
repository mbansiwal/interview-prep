package bits;

import java.util.Map;

public class CountBits
{
	public int countBitsForANumber(int number, Map<Integer, Integer> dataMap)
	{
		if (number == 0)
		{
			return 0;
		} else if (dataMap.containsKey(number))
		{
			return dataMap.get(number);
		} else
		{
			int answer = 1 + countBitsForANumber(number & (number - 1), dataMap);
			dataMap.put(number, answer);
			return answer;
		}
	}

	public int[] countBits(int num)
	{
		int[] array = new int[num + 1];

		if (num == 0)
		{
			return array;
		}
		array[1] = 1;
		int twosPower = 1;
		for (int i = 2; i <= num; i++)
		{
			if (i == twosPower * 2)
			{
				twosPower = i;
				array[i] = 1;
			} else
			{
				array[i] = array[i - twosPower] + array[twosPower];
			}

		}
		return array;
	}

	public int countBits2(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		
		int ans = 0;
		while(n != 0){
			n &= n - 1;
			ans++;
		}

		return ans;

	}

	public static void main(String[] args)
	{
		// System.out.println(new CountBits().countBits(4));
		int[] array = new CountBits().countBits(5);
		// for (int i = 0; i < array.length; i++)
		// {
		// System.out.print(array[i] + ",");
		// }

		System.out.println(new CountBits().countBits2(5));
		System.out.println(new CountBits().countBits2(3));
	}

}
