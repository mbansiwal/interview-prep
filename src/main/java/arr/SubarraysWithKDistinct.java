package arr;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDistinct
{
	public int subarraysWithKDistinct(int[] A, int K)
	{
		Window window1 = new Window();
		Window window2 = new Window();
		int ans = 0, left1 = 0, left2 = 0;

		for (int right = 0; right < A.length; ++right)
		{
			int x = A[right];
			window1.add(x);
			window2.add(x);

			while (window1.different() > K)
			{
				window1.remove(A[left1++]);
			}
			while (window2.different() >= K)
			{
				window2.remove(A[left2++]);
			}

			ans += left2 - left1;
		}

		return ans;
	}
	
	public int subarraysWithKDistinct2(int[] arr, int k)
	{
		int sum = 0;
		int left = 0;
		Window window = new Window();
		for (int i = 0; i < arr.length; i++) {
			window.add(arr[i]);
			while(window.different() > k) {
				window.remove(arr[left++]);
			}
			if(window.different() == k) {
				sum+=i-left;
			}
		}
		return sum;
	}

	public static void main(String[] args)
	{
		System.out.println(new SubarraysWithKDistinct().subarraysWithKDistinct(new int[]
		{
				1, 2, 1, 2, 3
		}, 2));
		
		System.out.println(new SubarraysWithKDistinct().subarraysWithKDistinct(new int[]
				{
						1, 2, 1, 2, 3
				}, 2));
				
		System.out.println(new SubarraysWithKDistinct().subarraysWithKDistinct2(new int[]
						{
								1,2,1,3,4
						}, 3));
				
		System.out.println(new SubarraysWithKDistinct().subarraysWithKDistinct2(new int[]
				{
						1,2,1,3,4
				}, 3));
	}
}

class Window
{
	Map<Integer, Integer> count;

	Window()
	{
		count = new HashMap<>();
	}

	void add(int x)
	{
		count.put(x, count.getOrDefault(x, 0) + 1);
	}

	void remove(int x)
	{
		count.put(x, count.get(x) - 1);
		if (count.get(x) == 0)
		{
			count.remove(x);
		}
	}

	int different()
	{
		return count.size();
	}
}
