package arr;

import java.util.Arrays;

public class TotalTimeCoveredInIntervals
{

	public static void main(String args[])
	{
		Pair p1 = new Pair(1, 4);
		Pair p2 = new Pair(6, 8);
		Pair p3 = new Pair(2, 4);
		Pair p4 = new Pair(7, 9);
		Pair p5 = new Pair(10, 15);

		// 1,4,6,9,10,15
		Pair[] arr1 =
		{
				p1, p2, p3, p4, p5
		};

		TotalTimeCoveredInIntervals ats = new TotalTimeCoveredInIntervals();
		System.out.print(ats.combineInterval(arr1));
	}

	public int combineInterval(Pair[] arr1)
	{
		Arrays.<Pair> sort(arr1, (pair1, pair2) -> pair1.low - pair2.low);
		int i = 0;
		int interval = 0;
		int high = Integer.MIN_VALUE;
		while (i < arr1.length)
		{
			if (arr1[i].low <= high)
			{
				if (arr1[i].high > high)
				{
					interval += (arr1[i].high - high);
					high = arr1[i].high;
				}
			} else
			{
				high = arr1[i].high;
				interval += (arr1[i].high - arr1[i].low);
			}
			i++;
		}
		return interval;
	}
}
