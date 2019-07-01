package arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair
{
	int low;
	int high;

	public Pair(int low, int high)
	{
		super();
		this.low = low;
		this.high = high;
	}

	public String toString()
	{
		return low + " " + high;
	}
}
public class AddingTwoSetOfIntervals
{
	public List<Pair> combineInterval(Pair[] arr1, Pair[] arr2)
	{
		List<Pair> pairs = new ArrayList<>();
		Arrays.<Pair> sort(arr1, (pair1, pair2) -> pair1.low - pair2.low);
		Arrays.<Pair> sort(arr2, (pair1, pair2) -> pair1.low - pair2.low);
		int i = 0;
		int j = 0;
		Pair current = new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE + 1);
		while (i < arr1.length && j < arr2.length)
		{
			if (arr1[i].low <= arr2[j].low)
			{
				if (arr1[i].low <= current.high)
				{
					current.high = Math.max(arr1[i].high, current.high);
				} else
				{
					current = arr1[i];
					pairs.add(current);
				}
				i++;
			} else
			{
				if (arr2[j].low <= current.high)
				{
					current.high = Math.max(arr2[j].high, current.high);
				} else
				{
					current = arr2[j];
					pairs.add(current);
				}
				j++;
			}
		}
		while (i < arr1.length)
		{
			if (arr1[i].low <= current.high)
			{
				current.high = Math.max(arr1[i].high, current.high);
			} else
			{
				current = arr1[i];
				pairs.add(current);
			}
			i++;
		}
		while (j < arr2.length)
		{
			if (arr2[j].low <= current.high)
			{
				current.high = Math.max(arr2[j].high, current.high);
			} else
			{
				current = arr2[j];
				pairs.add(current);
			}
			j++;
		}
		return pairs;
	}

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
						p1, p2, p3
				};

		Pair[] arr2 =
				{
						p4, p5
				};

		AddingTwoSetOfIntervals ats = new AddingTwoSetOfIntervals();
		List<Pair> rs = ats.combineInterval(arr1, arr2);
		System.out.print(rs);
	}
}
