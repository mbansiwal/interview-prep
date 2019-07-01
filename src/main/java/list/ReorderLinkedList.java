package list;

public class ReorderLinkedList
{
	public void reorderList(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return;
		}

		ListNode hare = head;
		ListNode tortoise = head;
		while (hare.next != null && hare.next.next != null)
		{
			hare = hare.next.next;
			tortoise = tortoise.next;
		}
		ListNode reverseList = reverse(tortoise.next);
		tortoise.next = null;

		ListNode newHead = mergeList(head, reverseList);
		printList(newHead);
	}

	private ListNode mergeList(ListNode node1, ListNode node2)
	{
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = node1;
		ListNode newHead = dummyHead;
		while (node1 != null && node2 != null)
		{
			ListNode node2Next = node2.next;
			ListNode node1Next = node1.next;
			newHead.next = node1;
			node1.next = node2;
			node2.next = null;
			newHead = node2;

			node1 = node1Next;
			node2 = node2Next;
		}

		while (node1 != null)
		{
			newHead.next = node1;
			node1 = node1.next;
			newHead = newHead.next;
		}

		while (node2 != null)
		{
			newHead.next = node2;
			node2 = node2.next;
			newHead = newHead.next;
		}
		return dummyHead.next;
	}

	private ListNode reverse(ListNode node)
	{
		ListNode newHead = null;
		while (node != null)
		{
			ListNode next = node.next;
			node.next = newHead;
			newHead = node;
			node = next;
		}
		return newHead;
	}

	public static void main(String[] args)
	{
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		// node.next.next.next.next.next = new ListNode(6);

		new ReorderLinkedList().reorderList(node);
		// while (node != null)
		// {
		// System.out.println(node.val);
		// node = node.next;
		// }
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
