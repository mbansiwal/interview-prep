package arr;

import java.util.Stack;

public class NextGreaterElement
{
	public static void main(String[] args)
	{
		int arr[] =
		{
				11, 13, 21, 3
		};
		printNGE(arr);

		int arr2[] =
		{
				4, 5, 2, 25
		};
		System.out.println();
		printNGE(arr2);
	}

	private static void printNGE(int[] arr)
	{
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; --i)
		{
			int element = arr[i];
			
			while (!stack.isEmpty() && stack.peek() <= element)
			{
				stack.pop();
			}

			System.out.println("next element" + (stack.isEmpty() ? -1 : stack.peek()));
			stack.push(element);
		}
		
	}
}
