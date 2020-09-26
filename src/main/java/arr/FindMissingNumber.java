package arr;

import java.util.PriorityQueue;

public class FindMissingNumber
{
	public int solution(int[] A)
	{
		PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2-num1);
		for (int i = 0; i < A.length; ++i)
		{
			if(A[i] > 0)
			{
				queue.add(A[i]);
			}
		}

		int count = 1;
		int previous = 0;
		while (!queue.isEmpty())
		{
			int currentElement = queue.poll();
			if (previous == currentElement)
			{
				continue;
			} else
			{
				previous = currentElement;
			}

			if (count < currentElement)
			{
				return count;
			}
			count++;
		}

		return count;
	}

	public static void main(String[] args)
	{
		int[] arr =
		{
				1, 3, 6, 4, 1, 2
		};
		System.out.println(new FindMissingNumber().solution(arr));
	}
}
