package arr;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60
{
	public int numPairsDivisibleBy60(int[] time)
	{
		int result = 0;
		Map<Integer, Integer> dataMap = new HashMap<>();
		for (int i = 0; i < time.length; i++)
		{
			int rem = time[i] % 60;
			result += dataMap.getOrDefault((60 - rem) % 60, 0);
			dataMap.put(rem, dataMap.getOrDefault(rem, 0) + 1);
		}

		return result;
	}
	public static void main(String[] args)
	{
		int[] time =
		{
				30, 20, 150, 100, 40
		};
		System.out.println(new PairsOfSongsWithTotalDurationsDivisibleBy60().numPairsDivisibleBy60(time));

		int[] time2 =
		{
				60, 60, 60
		};
		System.out.println(new PairsOfSongsWithTotalDurationsDivisibleBy60().numPairsDivisibleBy60(time2));
	}
}
