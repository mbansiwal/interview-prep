package dp.lis;

import java.util.Arrays;

class Pair implements Comparable<Pair>
{
	int first;
	int second;
	public Pair(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}
	
	@Override
	public int compareTo(Pair o) 
	{
		return Integer.compare(first, o.first);
	}
}

public class MaximumChainLengthPair {
	public static void findLongestChain(Pair[] pairs)
	{
		Arrays.sort(pairs);
		
		int[] maxIncreasingChain = new int[pairs.length];
		Arrays.fill(maxIncreasingChain, 1);
		
		for (int i = 1; i < pairs.length; i++) 
		{
			for (int j = 0; j < i; j++) 
			{
				if(pairs[i].first > pairs[j].second)
				{
					maxIncreasingChain[i] = Math.max(maxIncreasingChain[j] + 1, maxIncreasingChain[i]);
				}
			}
		}
		
		System.out.println(Arrays.stream(maxIncreasingChain).max().getAsInt());
	}
	
	public static void main(String[] args) 
	{
		Pair[] pairs = {new Pair(5, 24), new Pair(15, 28), new Pair(27, 40), new Pair(39, 60), new Pair(50, 90) };
		findLongestChain(pairs);
	}
}
