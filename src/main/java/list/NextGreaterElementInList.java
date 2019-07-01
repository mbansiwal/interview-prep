package list;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementInList
{
	public int[] nextLargerNodes(ListNode head)
	{
		if (head == null)
		{
			return null;
		}
		int count = 0;
		ListNode node = head;
		while (head != null)
		{
			head = head.next;
			count++;
		}

		int array[] = new int[count];
		for (int i = 0; i < count; i++)
		{
			array[i] = node.val;
			node = node.next;
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(array[count - 1]);
		array[count - 1] = 0;
		for (int i = count - 2; i >= 0; --i)
		{
			int element = array[i];
			while (!stack.isEmpty() && stack.peek() <= element)
			{
				stack.pop();
			}
			int newElement = stack.isEmpty()?0:stack.peek();
			array[i] = newElement;
			stack.push(element);
		}

		return array;
	}

	public static void main(String[] args)
	{
		ListNode node = new ListNode(2);
		node.next = new ListNode(7);
		node.next.next = new ListNode(4);
		node.next.next.next = new ListNode(3);
		node.next.next.next.next = new ListNode(5);
		
		System.out.println(Arrays.toString(new NextGreaterElementInList().nextLargerNodes(node)));
	}
}
