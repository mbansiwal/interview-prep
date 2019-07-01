package list;

public class ReorderLinkedList2
{
	public ListNode reverseBetween(ListNode head, int m, int n)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode node = head;
		int count = 1;
		ListNode previous = null;
		while (node.next != null && count < m)
		{
			previous = node;
			node = node.next;
			count++;
		}

		ListNode endOfFirstPart = previous;

		ListNode reverseList = reverse(node, n - m);

		if (endOfFirstPart != null)
		{
			endOfFirstPart.next = reverseList;
		} else
		{
			head = reverseList;
		}
		return head;
	}

	private ListNode reverse(ListNode node, int n)
	{
		ListNode head = node;
		ListNode newHead = null;
		while (node != null && n >= 0)
		{
			ListNode next = node.next;
			node.next = newHead;
			newHead = node;
			node = next;
			n--;
		}
		if (node != null)
		{
			head.next = node;
		}
		return newHead;
	}

	public static void main(String[] args)
	{
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		// node.next.next = new ListNode(3);
		// node.next.next.next = new ListNode(4);
		// node.next.next.next.next = new ListNode(5);
		// node.next.next.next.next.next = new ListNode(6);

		node = new ReorderLinkedList2().reverseBetween(node, 1, 2);
		new ReorderLinkedList2().printList(node);
	}

	private void printList(ListNode node)
	{
		while (node != null)
		{
			System.out.println(node.val);
			node = node.next;
		}
	}
}
