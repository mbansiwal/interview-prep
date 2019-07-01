package arr;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum
{
	static void printMax(int arr[], int n, int k)
	{
		Deque<Integer> queue = new LinkedList<>();
		for (int i = 0; i < k; i++)
		{
			while (!queue.isEmpty() && (arr[i] >= arr[queue.peekLast()]))
			{
				queue.removeLast();
			}
			queue.addLast(i);
		}

		for (int i = k; i < n; i++)
		{
			System.out.print(arr[queue.peek()] + ",");
			while (!queue.isEmpty() && (queue.peek() <= (i - k)))
			{
				queue.removeFirst();
			}

			while (!queue.isEmpty() && (arr[i] >= arr[queue.peekLast()]))
			{
				queue.removeLast();
			}
			queue.addLast(i);
		}
		System.out.print(arr[queue.peek()]);
	}

	public static void main(String[] args)
	{
		int arr[] =
		{
				12, 1, 78, 90, 57, 89, 56
		};
		int k = 3;
		printMax(arr, arr.length, k);
	}
}
