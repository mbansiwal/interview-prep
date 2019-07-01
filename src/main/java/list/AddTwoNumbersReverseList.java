package list;

import java.util.Stack;

public class AddTwoNumbersReverseList
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		int carry = 0;
		Stack<Integer> l1Stack = new Stack<>();
		Stack<Integer> resultStack = new Stack<>();
		Stack<Integer> l2Stack = new Stack<>();
		while (l1 != null)
		{
			l1Stack.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null)
		{
			l2Stack.push(l2.val);
			l2 = l2.next;
		}
		while (!l1Stack.isEmpty() || !l2Stack.isEmpty())
		{
			int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
			int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
			int sum = x + y + carry;
			int lastDigit = sum % 10;
			carry = sum / 10;
			resultStack.add(lastDigit);
		}
		if (carry != 0)
		{
			resultStack.add(carry);
		}

		ListNode head = new ListNode(0);
		ListNode top = head;
		while (!resultStack.isEmpty())
		{
			head.next = new ListNode(resultStack.pop());
			head = head.next;
		}
		return top.next;
	}

	public static void main(String[] args)
	{
		ListNode node = new ListNode(7);
		node.next = new ListNode(2);
		node.next.next = new ListNode(4);
		node.next.next.next = new ListNode(3);

		ListNode node2 = new ListNode(5);
		node2.next = new ListNode(6);
		node2.next.next = new ListNode(4);

		ListNode result = new AddTwoNumbersReverseList().addTwoNumbers(node, node2);
		while (result != null)
		{
			System.out.print(result.val + ",");
			result = result.next;
		}
	}
}
